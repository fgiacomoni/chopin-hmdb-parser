package fr.inrae.metabohub.parser

import utest.{TestSuite, Tests, test}

import java.io.File

object HmdbParserTest extends TestSuite {

  def tests: Tests = Tests {
    test("read CSV non undefined file") {
      val df = HmdbParser(new File("/tmp/File"))
      println(df)
    }
  }
}
