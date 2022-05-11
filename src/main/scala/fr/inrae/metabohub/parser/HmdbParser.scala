package fr.inrae.metabohub.parser

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession

case class HmdbXmlParser(xml:String) {

  val schema = "accession: string, mw : double, pos_pseud_ion_mz: double, neg_pseud_ion_mz: double"

  def read(spark: SparkSession): sql.DataFrame = {
    spark.read
      .format("xml")
      .option("rowTag", "metabolite")
      .schema(schema)
      .load("csf_metabolites_dump.xml")
  }
}
