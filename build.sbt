sbtPlugin := true

organization := "com.ejisan"

name := """sbt-riotjs"""

version := "2.2.4"

scalaVersion := "2.10.6"

scalacOptions += "-feature"

crossScalaVersions := Seq(scalaVersion.value)

libraryDependencies ++= Seq(
  "org.webjars" % "riot" % "2.2.4",
  "org.webjars" % "mkdirp" % "0.5.0",
  "org.webjars.npm" % "simple-dom" % "0.3.0",
  "org.webjars.npm" % "simple-html-tokenizer" % "0.2.5"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.0.0")
