package fr.inrae.metabohub.parser

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import com.databricks.spark.xml._

case class HmdbParser(csv:String) {

  val schema = "iontype: string,mult : double,mass: double"

  def read(spark: SparkSession): sql.DataFrame = {
    spark.read
      .option("delimiter", ";")
      .option("header", "true")
      .option("schema", schema)
      .csv("ref_pos_adducts.tsv")
  }
}

case class HmdbXmlParser(xml:String) {

  val schema = new StructType()
    .add("accession", StringType)
    .add("mw",DoubleType)
    .add("pos_pseudomolecular_ion_mz",DoubleType)
    .add("neg_pseudomolecular_ion_mz",DoubleType)

  def read(spark: SparkSession): sql.DataFrame = {
    spark.read
      .option("delimiter", ";")
      .option("header", "true")
      .option("schema", schema)
      .csv("ref_pos_adducts.tsv")
  }
}
