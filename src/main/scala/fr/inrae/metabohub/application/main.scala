package fr.inrae.metabohub.application

import fr.inrae.metabohub.parser._
import org.apache.spark.sql.SparkSession

object Main {


  def main(args: Array[String]): Unit = {

    if (args.length <= 0) {
      System.err.println("cvs file missi !")
      System.exit(-1)
    }

    val spark = SparkSession
      .builder()
      .appName("chopin-hmdb-parser exe")
      .getOrCreate()

    HmdbXmlParser(args(0)).read(spark).show()

  }
}
