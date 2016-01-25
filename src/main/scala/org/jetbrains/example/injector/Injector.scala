package org.jetbrains.example.injector

import org.jetbrains.plugins.scala.lang.psi.api.toplevel.typedef.{ScClass, ScTypeDefinition}
import org.jetbrains.plugins.scala.lang.psi.impl.toplevel.typedef.SyntheticMembersInjector

class Injector extends SyntheticMembersInjector {
  override def injectFunctions(source: ScTypeDefinition): Seq[String] = {
    source match {
      case c: ScClass if c.hasAnnotation("TalkingAnimalSpell").isDefined =>
        Seq(s"def sayHello: Unit = ???")
      case _ => Seq.empty
    }
  }
}