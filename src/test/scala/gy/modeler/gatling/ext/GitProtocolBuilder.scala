package gy.modeler.gatling.ext

import io.gatling.http.util.HttpHelper
import java.net.InetAddress


import io.gatling.core.filter.{ BlackList, Filters, WhiteList }
import io.gatling.core.session._
import io.gatling.http.HeaderNames._
import io.gatling.http.ahc.ProxyConverter
import io.gatling.http.check.HttpCheck
import io.gatling.http.request.ExtraInfoExtractor
import io.gatling.http.response.Response
import io.gatling.http.util.HttpHelper

object GitProtocolBuilder {

  implicit def toGitProtocol(builder: GitProtocolBuilder): GitProtocol = builder.build

}

case class GitProtocolBuilder(protocol: GitProtocol) {

  def baseURL(url: String) = {} // copy(protocol = protocol.copy(baseURLs = List(url)))

  def basicAuth(username: Expression[String], password: Expression[String]) = {}

  def build = {
    protocol
  }

}
