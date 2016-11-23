package gy.modeler.gatling.gitbucket.types

import scala.util.Random

case class Repository(
                       owner: String = "testUser",
                       name: String,
                       description: Option[String] = Some("test Repo"),
                       isPrivate: Boolean = true,
                       createReadme: Boolean = true)


object Repository {
  def auto: Repository = {
    new Repository(
      name = Random.alphanumeric.take(20).mkString)
  }
}