val scalaLangVersion = "2.12.4"

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Xlint",
  "-Xfuture",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-unused-import",
  "-unchecked",
  "-deprecation",
  "-feature",
  "-encoding", "UTF-8"
)

lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")
lazy val testScalastyle = taskKey[Unit]("testScalastyle")

compileScalastyle := scalastyle.in(Compile).toTask("").value
testScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Test).toTask("").value

(compile in Compile) <<= (compile in Compile) dependsOn compileScalastyle
(test in Test) <<= (test in Test) dependsOn testScalastyle