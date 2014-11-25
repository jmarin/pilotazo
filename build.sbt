name := "pilotazo"

version := "0.0.1"

scalaVersion := "2.11.4"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= {
  val parserCombinators = "1.0.2"
  val spray = "1.3.1"
  val akka = "2.3.7"
  val specs2 = "2.4.2"
  val scalacheck = "1.11.6"
  Seq(
    "org.scala-lang.modules" %% "scala-parser-combinators" % parserCombinators,
    "io.spray" %%  "spray-json" % spray,
    "com.typesafe.akka" %% "akka-persistence-experimental" % akka,
    "com.typesafe.akka" %% "akka-cluster" % akka,
    "com.github.ironfish" %% "akka-persistence-mongo-casbah" % "0.7.5-SNAPSHOT",
    "org.specs2" %% "specs2" % specs2 % "test",
    "org.scalacheck" %% "scalacheck" % scalacheck % "test"
  )
}

scalariformSettings

Revolver.settings
