package com.ejisan.sbt.riotjs

import com.typesafe.sbt.jse.SbtJsTask
import sbt._
import com.typesafe.sbt.web.SbtWeb
import spray.json.{JsBoolean, JsObject}
import sbt.Keys._

object Import {

  object RiotJsKeys {
    val riotjs = TaskKey[Seq[File]]("riotjs", "Invoke the RiotJs compiler.")
  }

}

object SbtRiotJs extends AutoPlugin {

  override def requires = SbtJsTask

  override def trigger = AllRequirements

  val autoImport = Import

  import SbtWeb.autoImport._
  import WebKeys._
  import SbtJsTask.autoImport.JsTaskKeys._
  import autoImport.RiotJsKeys._

  val riotJsUnscopedSettings = Seq(
    includeFilter := "*.tag"
  )

  override def projectSettings = inTask(riotjs)(
    SbtJsTask.jsTaskSpecificUnscopedSettings ++
      inConfig(Assets)(riotJsUnscopedSettings) ++
      inConfig(TestAssets)(riotJsUnscopedSettings) ++
      Seq(
        moduleName := "riotjs",
        shellFile := getClass.getClassLoader.getResource("riotjs.js"),

        taskMessage in Assets := "RiotJs compiling",
        taskMessage in TestAssets := "RiotJs test compiling"
      )
  ) ++ SbtJsTask.addJsSourceFileTasks(riotjs) ++ Seq(
    riotjs in Assets := (riotjs in Assets).dependsOn(webModules in Assets).value,
    riotjs in TestAssets := (riotjs in TestAssets).dependsOn(webModules in TestAssets).value
  )

}
