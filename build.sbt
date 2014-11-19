name := "pilotazo"

version := "0.0.1"

scalaVersion := "2.11.4"

libraryDependencies ++= {
  val parserCombinators = "1.0.2"
  val spray = "1.3.1"
  val specs2 = "2.4.2"
  val scalacheck = "1.11.6"
  Seq(
    "org.scala-lang.modules" %% "scala-parser-combinators" % parserCombinators,
    "io.spray" %%  "spray-json" % spray,
    "org.specs2" %% "specs2" % specs2 % "test",
    "org.scalacheck" %% "scalacheck" % scalacheck % "test"
  )
}

scalariformSettings
