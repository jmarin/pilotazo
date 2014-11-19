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

  val expr = id ~ respId ~ code ~ timestamp ~ activityYear ~ taxId ^^ {
    case (id ~ respId ~ code ~ timestamp ~ activityYear ~ taxId) =>
      TransmittalSheet(id, respId, code, timestamp, activityYear, taxId)
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
