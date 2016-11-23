package gy.modeler.gatling.gitbucket.types

case class CSGroup (
                     groupName: String,
                     url: Option[String] = None,
                     fileId: Option[String] = None,
                     members: List[CSGroupMember]
                   )

case class CSGroupMember (name: String, isManager: Boolean)
