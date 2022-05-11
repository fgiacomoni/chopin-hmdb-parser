package fr.inrae.metabohub.parser

import fr.inrae.metabohub.parser.AdductsTableParserTest.getClass
import org.apache.spark.sql.SparkSession
import utest.{TestSuite, Tests, test}

import java.io.File
import scala.io.Source

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
      df.read(spark).show()
    }
  }
}
