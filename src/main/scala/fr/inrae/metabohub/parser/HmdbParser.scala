package fr.inrae.metabohub.parser

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession

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
