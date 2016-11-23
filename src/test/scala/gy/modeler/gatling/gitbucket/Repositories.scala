package gy.modeler.gatling.gitbucket


import gy.modeler.gatling.gitbucket.types.Repository
import io.gatling.core.Predef._
import io.gatling.core.session._
import io.gatling.core.structure._
import io.gatling.http.Predef._

import scala.concurrent.duration._

object Repositories {



  def create(): ScenarioBuilder = {
    scenario("Create Repository")
      .exec {
        create(Repository.auto)
      }
  }

  def create(repository: Repository): ScenarioBuilder = {
    scenario("Create Repository: " + repository.name)
      .exec {
        http("new repository page")
          .get("/new")
      }
      .exec {
        http("repo create form")
          .post("/new")
          .formParam("owner", s"${repository.owner}")
          .formParam("name", s"${repository.name}")
          .formParam("description", s"${repository.description.getOrElse("")}")
          .formParam("isPrivate", repository.isPrivate)
          .formParam("createReadme", repository.createReadme)
      }
  }

  def delete(): ScenarioBuilder = ???

}