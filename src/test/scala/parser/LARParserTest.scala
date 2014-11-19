package parser

import org.specs2.mutable.Specification
import org.specs2.matcher.ParserMatchers
import org.scalacheck.{ Arbitrary, Prop, Gen }
import org.scalacheck.Prop.forAll
import LARParser._

class LARParserTest extends Specification with ParserMatchers {
  override def is = s2"""

 Parsers for LAR

  ${dot must succeedOn(".").withResult(".")}
  
  ${number("1") must beASuccess}
  ${number must succeedOn("40").withResult(40)}
  ${number("1") must beASuccess}


"""

  val parsers = LARParser

}
