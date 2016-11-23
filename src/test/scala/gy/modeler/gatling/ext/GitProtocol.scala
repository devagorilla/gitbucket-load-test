package gy.modeler.gatling.ext

import io.gatling.core.config.GatlingConfiguration

class DefaultGitProtocol(implicit configuration: GatlingConfiguration) {
  val value = GitProtocol("/usr/bin/git")
}

case class GitProtocol(
                        gitBinaryLocation: String
                      )
