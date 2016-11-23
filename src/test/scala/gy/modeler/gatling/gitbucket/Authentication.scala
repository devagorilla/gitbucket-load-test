package gy.modeler.gatling.gitbucket

import com.typesafe.scalalogging.StrictLogging
import io.gatling.core.Predef._
import io.gatling.core.session._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import io.gatling.http.cookie.CookieJar

/**
  * Handles all Authentication related calls for Stash
  */
object Authentication extends StrictLogging {

  def becomeAdmin = ???


  def saveSession: Expression[Session] = session => {
    session.set("stash.saved.cookies", session("gatling.http.cookies"))
    session.remove("gatling.http.cookies")
    session
  }

  def restoreSession: Expression[Session] = session => {
    val cookies = session("stash.saved.cookies").as[CookieJar]
    session.remove("stash.saved.cookies").set("gatling.http.cookies", cookies)
  }

  def createUser: ScenarioBuilder = {
    scenario("Create User")
  }

  def signInOffline: ScenarioBuilder = {
    scenario("Portal Sign in").exec {
      http("sign in offline")
        .post("/signinoffline")
        .formParam("userName", "root")
        .formParam("password", "COTSpass101!")
    }
  }

//  def login: ScenarioBuilder = {
  //    scenario("Login").exec {
  //      http("login page").get("/login")
  //    }.exec {
  //      http("login form")
  //        .post("/j_stash_security_check")
  //        .formParam("j_username", Users.currentUsername)
  //        .formParam("j_password", Users.currentPassword)
  //    }
  //  }

  def logout: ScenarioBuilder = {
    scenario("Logout Scenario").exec {
      http("logout action")
        .get("/signout")
    }
  }
}