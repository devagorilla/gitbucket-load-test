package gy.modeler.gatling.simulation

import gy.modeler.gatling.gitbucket._
import gy.modeler.gatling.gitbucket.modes.{GitCalls, RestCalls, WebCalls}
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

class ContentStoreSimulation extends Simulation with WebCalls with RestCalls with GitCalls {

  val webConfig = configureWeb("http://localhost:8080", WebCalls.MOZILLA_5_0, WebCalls.LANGUAGE_ENGLISH)

  val reviewer = scenario("Reviewer Persona")
    .group("Create Project -> Repo -> User"){
      exec(Users.register)
        //exec(Authentication.signInOffline)
        //.exec(Projects.create)
        //.exec(Repositories.create)
        //.exec(Users.create)
        //.exec(Authentication.logout)
    }
  //        .exec(AdminOperations.newUser)
  //        .exec(Repositories.owner(Users.current))
  //        .exec(Authentication.login)
  //        .exec(Authentication.logout)

  setUp(reviewer.inject(atOnceUsers(1)).protocols(webConfig))

}
