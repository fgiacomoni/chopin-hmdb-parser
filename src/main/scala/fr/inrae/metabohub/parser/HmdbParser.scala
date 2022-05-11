package fr.inrae.metabohub.parser

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DoubleType, StringType, StructType}

case class HmdbXmlParser(xml:String) {

  //val schema = "accession:string,mw:double,pos_pseud_ion_mz:double,neg_pseud_ion_mz:double"
  val schema = new StructType()
    .add("accession", StringType)
    .add("mw",DoubleType)
    .add("pos_pseudomolecular_ion_mz",DoubleType)
    .add("neg_pseudomolecular_ion_mz",DoubleType)

  def read(spark: SparkSession): sql.DataFrame = {
    spark.read
      .format("xml")
      .option("rowTag", "metabolite")
      .schema(schema)
      .load(xml)
  }
}
