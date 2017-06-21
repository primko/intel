name := "IntelShopChecker"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.codeborne" % "selenide" % "4.4.3" % "test",
  "org.seleniumhq.selenium" % "selenium-htmlunit-driver" % "2.+" % "test",
  "org.pegdown" % "pegdown" % "1.6.0" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.5" % "test",
  "org.slf4j" % "slf4j-simple" % "1.7.5" % "test"
)

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/report")