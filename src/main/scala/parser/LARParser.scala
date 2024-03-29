package parser

import scala.util.parsing.combinator._
import model._

object LARParser extends JavaTokenParsers with LARSplitter {

  def dot: Parser[Any] = "."

  def number: Parser[Int] = wholeNumber ^^ { _.toInt }

  def str: Parser[String] = """[a-zA-Z0-9_]+""".r ^^ { _.toString }

  def loan: Parser[Loan] = str ~ str ~ number ~ number ~ number ~ number ~ number ^^ {
    case (id ~ date ~ loanType ~ propertyType ~ purpose ~ occupancy ~ amount) =>
      Loan(id, date, loanType, propertyType, purpose, occupancy, amount)
  }

  def tract: Parser[String] = (str <~ dot) ~ str ^^ {
    case (a ~ b) => a ++ b
  }

  def geography: Parser[Geography] = str ~ str ~ str ~ tract ^^ {
    case (msa ~ state ~ county ~ tract) => Geography(msa, state, county, tract)
  }

  def applicant: Parser[Applicant] =
    number ~ number ~ number ~ str ~ str ~ str ~ str ~ number ~ str ~ str ~ str ~ str ~ number ~ number ~ str ^^ {
      case (eth ~ coeth ~ r1 ~ r2 ~ r3 ~ r4 ~ r5 ~ cr1 ~ cr2 ~ cr3 ~ cr4 ~ cr5 ~ sex ~ csex ~ income) =>
        Applicant(eth, coeth, r1, r2, r3, r4, r5, cr1, cr2, cr3, cr4, cr5, sex, csex, income)
    }

  def denial: Parser[Denial] =
    str ~ str ~ str ^^ {
      case (r1 ~ r2 ~ r3) =>
        Denial(r1, r2, r3)
    }

  def rateSpread: Parser[String] = str ~ dot ~ str ^^ {
    case (a ~ d ~ b) => a ++ d.toString ++ b
  }

  def expr = number ~ str ~ number ~ loan ~ number ~ number ~ number ~ geography ~ applicant ~ number ~ denial ~ rateSpread ~ number ~ number ^^ {
    case (id ~ respId ~ code ~ loan ~ preapproval ~ actionType ~ actionDate ~ geography ~ applicant ~ purchaser ~ denial ~ rate ~ hoepa ~ lien) =>
      LAR(id, respId, code, loan, preapproval, actionType, actionDate, geography, applicant, purchaser, denial, rate, hoepa, lien)
  }

  def apply(input: String): Option[LAR] = parseAll(expr, input) match {
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
