package fr.inrae.metabohub.application

import fr.inrae.metabohub.parser._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.round

object Main {


  def main(args: Array[String]): Unit = {

    if (args.length <= 0) {
      System.err.println("HMDB xml source file is missing !")
      System.exit(-1)
    }

    val spark = SparkSession
      .builder()
      .appName("chopin-hmdb-parser exe")
      .getOrCreate()

    val df = HmdbXmlParser(args(0))
    val df2 = df.filterCSFHmdbType(df.read(spark))
    df2.show()
    df2.write.parquet("args(1)")

    val df3 = spark.read.parquet("args(1)")

    df3.select("mw").show()
    //val df4 = df3.withColumn("M+H", round ( ($"mw" + 1.0072764), 9) ).withColumn("M-H", round ( ($"mw" - 1.0072764), 9) )
    val df4 = df3.withColumn("M+H", round(df3.col("mw")+ 1.0072764, 9)  ).withColumn("M-H", round(df3.col("mw")-1.0072764, 9))

    df4.select("mw","M+H_mz","M-H").show(false)

    df4.write.json("/Users/fgiacomoni/inra/labs/scala/hmdb_metabolites.json")


  }
}
