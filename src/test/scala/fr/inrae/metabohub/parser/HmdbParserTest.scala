package fr.inrae.metabohub.parser

import org.apache.spark.sql.{DataFrame, SparkSession, functions}
import org.apache.spark.sql.functions.col
import utest.{TestSuite, Tests, test}

import scala.Option.when

object HmdbParserTest extends TestSuite {
  val spark = SparkSession
    .builder()
    .master("local[*]")
    .getOrCreate()

  def tests: Tests = Tests {
    test("read successfully HMDB formatted XML...") {
      //val xmlFile : String = getClass.getResource("csf_metabolites_dump.xml").getPath
      val xmlFile = "src/test/resources/csf_metabolites_dump.xml"
      val df: HmdbXmlParser = HmdbXmlParser(xmlFile)
      //val df2 : DataFrame = df.read(spark)

      val df2 = df.filterCSFHmdbType( df.read(spark) )

      df2.write.parquet("src/test/resources/csf_metabolites_dump.parquet")

    }
  }
}
