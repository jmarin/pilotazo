package parser

import scala.util.parsing.combinator._
import model._

object TransmittalSheetParser extends BaseParser with TSSplitter {

  val id = int

  val respId = str

  val code = int

  val timestamp = long

  val activityYear = int

  val taxId = int ~ hiphen ~ int ^^ {
    case (pre ~ h ~ post) =>
      pre.toString + h.toString + post.toString
  }

  val zipCode = taxId | str

  val totalLines = int

  val respondent = repStr ^^ {
    case (name) =>
      Respondent(
        name.mkString(" "))
  }

  val parent = str ~ str ~ str ~ str ~ zipCode ^^ {
    case (name ~ address ~ city ~ state ~ zip) =>
      Parent(name, address, city, state, zip)
  }

  val contact = str ~ phoneNumber ~ phoneNumber ~ str ^^ {
    case (name ~ phone ~ fax ~ email) =>
      Contact(name, phone, fax, email)
  }

  val expr = id ~ respId ~ code ~ timestamp ~ activityYear ~ taxId ~ totalLines ~ respondent ^^ {
    case (id ~ respId ~ code ~ timestamp ~ activityYear ~ taxId ~ totalLines ~ respondent) =>
      TransmittalSheet(id, respId, code, timestamp, activityYear, taxId, totalLines, respondent)
  }

  def apply(input: String): Option[TransmittalSheet] = parseAll(expr, input) match {
    case Success(result, _) =>
      Some(result)
    case Failure(msg, _) =>
      println("FAILURE: " + msg)
      None
    case Error(msg, _) =>
      println("ERROR: " + msg)
      None
  }

}
