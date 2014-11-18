package parser

import org.specs2.mutable.Specification
import org.specs2.matcher.ParserMatchers
import LARParser._

class LARParserTest extends Specification with ParserMatchers {
  override def is = s2"""

 Parsers for LAR
  
  ${number("1") must beASuccess}

"""

  val parsers = LARParser

}
