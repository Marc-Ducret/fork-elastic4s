package com.sksamuel.elastic4s.requests.searches

import com.sksamuel.elastic4s.requests.script.Script

case class RuntimeMapping(field: String, `type`: String, script: Option[Script] = None, fields: Seq[RuntimeMapping.Field] = Seq.empty)

object RuntimeMapping {
  def apply(field: String, `type`: String, script: Script): RuntimeMapping =
    RuntimeMapping(field, `type`, Some(script))

  def apply(field: String, `type`: String, script: Script, fields: Seq[Field]): RuntimeMapping =
    RuntimeMapping(field, `type`, Some(script), fields)

  def apply(field: String, `type`: String, scriptSource: String): RuntimeMapping =
    RuntimeMapping(field, `type`, Some(Script(scriptSource)))

  def apply(field: String, `type`: String, scriptSource: String, fields: Seq[Field]): RuntimeMapping =
    RuntimeMapping(field, `type`, Some(Script(scriptSource)), fields)

  final case class Field(name: String, `type`: String)
}
