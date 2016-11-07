import sbt._
import Keys._

val metaSettings = Seq(
  name := "play_it_forward",
  description := "",
  version := "1.0.0"
)

val scalaSettings = Seq(
  scalaVersion := "2.11.8",
  scalacOptions ++=
    Seq(
      "-deprecation",
      "-encoding", "utf8",
      "-feature",
      "-unchecked",
      "-Xfuture",
      "-Yno-adapted-args",
      "-Ywarn-dead-code",
      "-Ywarn-numeric-widen",
      "-Ywarn-value-discard",
      "-Ywarn-unused")
)

val javacOptions = Seq(
  "-source", "1.8",
  "-target", "1.8"
)


libraryDependencies ++= Seq(
  cache,
  ws,
  specs2 % Test,
  "com.typesafe.play" %% "play-slick" % "2.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.0",
  "org.postgresql" % "postgresql" % "9.4.1211.jre7",
  specs2 % Test
//"org.scala-js" %% "scalajs-library" % "0.6.12",
//"org.scala-js" %% "scalajs-dom" % "0.9.1"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

lazy val `play_it_forward` = (project in file("."))
  .settings(metaSettings: _*)
  .settings(scalaSettings: _*)
  .enablePlugins(PlayScala)

//lazy val client = (project in file("client")).settings(
//  scalaVersion := scalaVersion,
//  persistLauncher := true,
//  persistLauncher in Test := false,
//  libraryDependencies ++= libraryDependencies
//).enablePlugins(ScalaJSPlugin, ScalaJSWeb).
//  dependsOn(sharedJs)
//
//lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared")).
//  settings(scalaVersion := scalaV).
//  jsConfigure(_ enablePlugins ScalaJSWeb)
//
//lazy val sharedJvm = shared.jvm
//lazy val sharedJs = shared.js
//
//// loads the server project at sbt startup
//onLoad in Global := (Command.process("project server", _: State)) compose (onLoad in Global).value

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator