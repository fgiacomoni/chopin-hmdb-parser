package fr.inrae.metabohub.parser

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
    test("read CSV non undefined file") {
      val csvFile : String = getClass.getResource("ref_pos_adducts.tsv").getPath
      val df = HmdbParser(csvFile)
      println(df)
    }
  }
}
