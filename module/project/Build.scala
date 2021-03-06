import sbt._
import sbt.Keys._
import play.Project._
import com.typesafe.config._
import scala.Some
import xerial.sbt.Sonatype.SonatypeKeys._

object Publish {
  lazy val settings = Seq(
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    organization := "com.scalableminds",
    organizationName := "scalable minds UG (haftungsbeschränkt) & Co. KG",
    organizationHomepage := Some(url("http://scalableminds.com")),
    startYear := Some(2014),
    profileName := "com.scalableminds",
    description := "Play framework 2.x module to execute mongo DB evolutions via comand line",
    licenses := Seq("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    homepage := Some(url("https://github.com/sclableminds/play-mongev")),
    scmInfo := Some(ScmInfo(url("https://github.com/sclableminds/play-mongev"), "https://github.com/scalableminds/play-mongev.git")),
    pomExtra := (
      <developers>
        <developer>
          <id>tmbo</id>
          <name>Tom Bocklisch</name>
          <email>tom.bocklisch@scalableminds.com</email>
          <url>http://github.com/tmbo</url>
        </developer>
      </developers>
    )
    )
}

object ApplicationBuild extends Build {

  val version = "0.2.5"

  val name = "play-mongev"

  val mongev = play.Project(name, version, Seq(), settings = xerial.sbt.Sonatype.sonatypeSettings ++ Publish.settings)
}
