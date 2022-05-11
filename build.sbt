name := "chopin-hmdb-generator"
version := "0.1"
scalaVersion := "2.13.8"

Compile / mainClass := Some("fr.inrae.metabohub.application.Main")

lazy val utestVersion = "0.7.11"

libraryDependencies ++= Seq(
      //"com.softwaremill.sttp.client3" %% "core" % sttpClient3Version % Test,
      //"com.lihaoyi" %%% "upickle" % upickleVersion,
      //"org.wvlet.airframe" %%% "airframe-log" % airframeLogVersion,
      //"io.lemonlabs" %%% "scala-uri" % scalaUriVersion,
      "com.lihaoyi" %% "utest" % utestVersion % Test
    )

Global / onChangedBuildSource := ReloadOnSourceChanges
