package parser

import scala.util.parsing.combinator._

trait BaseParser extends JavaTokenParsers {

  val str: Parser[String] = """[a-zA-Z0-9_]+""".r ^^ { _.toString }

  val repStr: Parser[List[String]] = rep(str)

  val int: Parser[Int] = wholeNumber ^^ { _.toInt }

  val long: Parser[Long] = wholeNumber ^^ { _.toLong }

  val dot: Parser[Any] = "."

  val hiphen: Parser[Any] = "-"

  val phoneNumber: Parser[String] = """^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$""".r ^^ { _.toString }

}
