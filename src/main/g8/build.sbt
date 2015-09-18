name               := "$name$"
scalaVersion       := Config.ver.scala.lang
crossScalaVersions := Seq(Config.ver.scala.lang)

resolvers += Resolver.mavenLocal
resolvers += "spray repo" at "http://repo.spray.io"

/* Sub Projects */
lazy val javaProject = project.
    settings(Config.commonJavaSettings)

lazy val scalaProject = project.
    settings(Config.commonScalaSettings).
    dependsOn(javaProject)

/* The Root Project */
lazy val root = (project in file(".")).
    settings(EclipseKeys.skipProject := true).
    settings(Config.commonSettings).
    settings(Config.unidocSettings).
    settings(giter8.ScaffoldPlugin.scaffoldSettings:_*).
    aggregate(javaProject, scalaProject)

fork in run  := true
fork in test := true
connectInput in run := true
