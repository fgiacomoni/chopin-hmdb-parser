package fr.inrae.metabohub.parser

import org.apache.spark.sql.SparkSession
import utest.{TestSuite, Tests, test}

import java.io.File
import scala.io.Source

object AdductsTableParserTest extends TestSuite {
  val spark = SparkSession
    .builder()
    .master("local[*]")
    .getOrCreate()

  def tests: Tests = Tests {
    test("read successfully Adducts table formatted CSV...") {
      val csvFile : String = getClass.getResource("ref_pos_adducts.tsv").getPath
      val df = AdductsTableParser(csvFile)
      println(df)
    }
  }
}
