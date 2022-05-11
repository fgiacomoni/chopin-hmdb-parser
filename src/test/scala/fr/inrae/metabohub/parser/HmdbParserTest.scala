package fr.inrae.metabohub.parser

import org.apache.spark.sql.SparkSession
import utest.{TestSuite, Tests, test}

import java.io.File

object HmdbParserTest extends TestSuite {
  val spark = SparkSession
    .builder()
    .master("local[*]")
    .getOrCreate()

  def tests: Tests = Tests {
    test("read CSV non undefined file") {
      val df = HmdbParser(new File("/tmp/File"))
      println(df)
    }
  }
}
