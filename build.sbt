name := "chopin-hmdb-generator"
version := "0.1"
scalaVersion := "2.13.8"

Compile / mainClass := Some("fr.inrae.metabohub.application.Main")

lazy val utestVersion = "0.7.11"
lazy val sparkVersion = "3.2.1"

libraryDependencies ++= Seq(
      //"com.softwaremill.sttp.client3" %% "core" % sttpClient3Version % Test,
      //"com.lihaoyi" %%% "upickle" % upickleVersion,
      //"org.wvlet.airframe" %%% "airframe-log" % airframeLogVersion,
      //"io.lemonlabs" %%% "scala-uri" % scalaUriVersion,
      "org.apache.spark"%% "spark-sql" % sparkVersion % "provided",
      "com.databricks" %% "spark-xml" % "0.14.0",
      "com.lihaoyi" %% "utest" % utestVersion % Test
)

testFrameworks += new TestFramework("utest.runner.Framework")
//scalacOptions ++= Seq("-deprecation", "-feature")
Test / parallelExecution := false
coverageMinimumStmtTotal := 86
coverageFailOnMinimum := false
coverageHighlighting := true

assembly / target := file("assembly")

Global / onChangedBuildSource := ReloadOnSourceChanges
