package gy.modeler.gatling.gitbucket.types



case class CSUser(
                   userName: String,
                   password: String,
                   fullName: String,
                   site: String,
                   mailAddress: String,
                   url: Option[String] = None,
                   fileId: Option[String] = None)

case class ModCSUser (
                       userName: String,
                       password: Option[String] = None,
                       fullName: Option[String] = None,
                       site: String,
                       mailAddress: String,
                       url: Option[String] = None,
                       fileId: Option[String] = None)

