import sbt._
import sbt.Keys._

object CheckoutKataBuild extends Build {

  lazy val checkoutkatascala = Project(
    id = "checkout-kata-scala",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "checkout-kata-scala",
      organization := "me.gladwell",
      version := "1.0.0-SNAPSHOT",
      scalaVersion := "2.11.6",
      resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
      libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6" % "test")
    )
  )

}
