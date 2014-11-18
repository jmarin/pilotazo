name := "pilotazo"

version := "0.0.1"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.2",
  "io.spray" %%  "spray-json" % "1.3.1",
  "org.specs2" %% "specs2" % "2.4.2" % "test" 
)

scalariformSettings
