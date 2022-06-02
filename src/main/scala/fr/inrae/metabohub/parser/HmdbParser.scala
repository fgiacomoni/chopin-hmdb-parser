package fr.inrae.metabohub.parser

import org.apache.spark.sql
import org.apache.spark.sql._
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types._

case class HmdbXmlParser(xml:String) {

  val schema = new StructType()
    .add("accession", StringType)
    .add("name", StringType)
    .add("inchi", StringType)
    .add("inchikey", StringType)
    .add("monisotopic_molecular_weight", DoubleType)
    .add("chemical_formula", StringType)
    .add("predicted_properties", new StructType()
      .add("property", new StructType()
        .add("kind", StringType)
        .add("value", StringType)
      )
    )

  def read(spark: SparkSession): sql.DataFrame = {
    schema.printTreeString()

    spark.read
      .format("xml")
      .option("rowTag", "metabolite")
      .schema(schema)
      .load(xml)
  }

  def filterCSFHmdbType(df: DataFrame): sql.DataFrame = {
    val FilteredDF = df
      .select(
        col("accession"),
        col("name"),
        col("inchikey"),
        col("chemical_formula"),
        col("monisotopic_molecular_weight")
      )

    FilteredDF.toDF("accession", "name", "inchikey", "chemical_formula", "monisotopic_molecular_weight")
  }

}
