package gy.modeler.gatling.gitbucket.modes

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import io.gatling.http.HeaderNames
import io.gatling.http.HeaderValues
import io.gatling.http.protocol.HttpProtocolBuilder

object WebCalls {

  val MOZILLA_5_0 = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36"

  //en-US,en;q=0.8,zh-CN;q=0.6,zh-TW;q=0.4

  val LANGUAGE_ENGLISH = "en-US,en;q=0.8"
  val LANGUAGE_JAPANESE = "ja-JP,ja;q=0.5"
  val LANGUAGE_GERMAN = "de-DE,de;q=0.5"
  val LANGUAGE_FRENCH = "fr-FR,fr;q=0.5"
  val LANGUAGE_SIMPLE_CHINESE = "zh-CN;q=0.6"
  val LANGUAGE_TRADITIONAL_CHINESE = "zh-TW;q=0.4"

  val DEFAULT_ACCEPT_HEADER = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"

  val english = Map(HeaderNames.AcceptLanguage -> WebCalls.LANGUAGE_ENGLISH)
  val japanese = Map(HeaderNames.AcceptLanguage -> WebCalls.LANGUAGE_JAPANESE)
  val german= Map(HeaderNames.AcceptLanguage -> WebCalls.LANGUAGE_GERMAN)
  val french = Map(HeaderNames.AcceptLanguage -> WebCalls.LANGUAGE_FRENCH)

  val json = Map(HeaderNames.ContentType -> HeaderValues.ApplicationJson)
  val html = Map(HeaderNames.ContentType -> HeaderValues.TextHtml)

}

trait WebCalls {

  def configureWeb(
                    baseUrl: String = "http://localhost:8080/",
                    userAgent: String = WebCalls.MOZILLA_5_0,
                    language: String = WebCalls.LANGUAGE_ENGLISH): HttpProtocolBuilder = {
    http
      .baseURL(baseUrl)
      .acceptHeader(WebCalls.DEFAULT_ACCEPT_HEADER)
      .doNotTrackHeader("1")
      .acceptLanguageHeader(language)
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader(userAgent)
  }

}
