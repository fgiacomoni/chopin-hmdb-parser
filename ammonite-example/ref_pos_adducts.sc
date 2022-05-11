import $ivy.`org.apache.spark:spark-sql_2.13:3.2.1`
import $ivy.`org.apache.spark:spark-core_2.13:3.2.1`
import org.apache.spark.sql.SparkSession

var spark = SparkSession
    .builder()
    .master("local[*]")
    .getOrCreate()

val schema = "iontype: string,mult : double,mass: double"

val df = spark.read//.option("encoding", "UTF-8").csv("test2.csv")
            .option("delimiter", ";")
            .option("header", "true")
            .option("schema", schema)
            .csv("ref_pos_adducts.tsv")

df.show()
println(df)
df.printSchema()