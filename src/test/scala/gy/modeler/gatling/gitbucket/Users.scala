package gy.modeler.gatling.gitbucket


import com.typesafe.scalalogging.StrictLogging
import gy.modeler.gatling.gitbucket.types.CSUser
import io.gatling.commons.validation.Success
import io.gatling.core.Predef._
import io.gatling.core.session._
import io.gatling.http.Predef._


object Users extends StrictLogging {


  def current: Expression[CSUser] = _("CURRENT_USER").as[CSUser]
  def currentUsername: Expression[String] = _("CURRENT_USER").as[CSUser].userName
  def currentPassword: Expression[String] = _("CURRENT_USER").as[CSUser].password

  def admin: Expression[Session] = _.set("CURRENT_USER", CSUser("testUser", "testMypass101!",
    "test me", "", "testmything@iamhere.org"))


  def register = exec {
    http("sign in page").get("/signin")
  }.exec {
    http("register page").get("/register")
  }.exec {
    http("create user")
      .post("/register")
      .formParam("userName", "testUser")
      .formParam("password", "testMypass101!")
      .formParam("fullName", "test me")
      .formParam("mailAddress", "testmything@iamhere.org")
      .formParam("url", "")
      .formParam("fileId", "")
  }

  def trash(key: String): Expression[Session] = { session: Session =>
    Success(session.remove(key))
  }


}