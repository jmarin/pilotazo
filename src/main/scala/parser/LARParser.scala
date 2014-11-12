package parser

import scala.util.parsing.combinator._
import model._

object LARParser extends JavaTokenParsers {

  def split(s: String): String = {
    val id = s.toList(0).toString
    val respId = s.substring(1, 11)
    val code = s.substring(11, 12)
    val loanId = s.substring(12, 36)
    val loanDate = s.substring(37, 45)
    val loanType = s.substring(45, 46)
    val propertyType = s.substring(46, 47)
    val loanPurpose = s.substring(47, 48)
    val occupancy = s.substring(48, 49)
    val loanAmount = s.substring(49, 54)
    val preapprovals = s.substring(54, 55)
    val actionType = s.substring(55, 56)
    val actionDate = s.substring(56, 64)
    val msa = s.substring(64, 69)
    val state = s.substring(69, 71)
    val county = s.substring(71, 74)
    val tract = s.substring(74, 81)
    val appEthnicity = s.substring(81, 82)
    val coAppEthnicity = s.substring(82, 83)
    val appRace1 = s.substring(83, 84)
    val appRace2 = s.substring(84, 85)
    val appRace3 = s.substring(85, 86)
    val appRace4 = s.substring(86, 87)
    val appRace5 = s.substring(87, 88)
    val coAppRace1 = s.substring(88, 89)
    val coAppRace2 = s.substring(89, 90)
    val coAppRace3 = s.substring(90, 91)
    val coAppRace4 = s.substring(91, 92)
    val coAppRace5 = s.substring(92, 93)
    val appSex = s.substring(93, 94)
    val coAppSex = s.substring(94, 95)
    val appIncome = s.substring(95, 99)
    val purchaserType = s.substring(99, 100)
    val denial1 = s.substring(100, 101)
    val denial2 = s.substring(101, 102)
    val denial3 = s.substring(102, 103)
    val rateSpread = s.substring(103, 108)
    val hoepaStatus = s.substring(108, 109)
    val lienStatus = s.substring(109, 110)

    id ++ " " ++
      respId ++ " " ++
      code ++ " " ++
      loanId ++ " " ++
      loanDate ++ " " ++
      loanType ++ " " ++
      propertyType ++ " " ++
      loanPurpose ++ " " ++
      occupancy ++ " " ++
      loanAmount ++ " " ++
      preapprovals ++ " " ++
      actionType ++ " " ++
      actionDate ++ " " ++
      msa ++ " " ++
      state ++ " " ++
      county ++ " " ++
      tract ++ " " ++
      appEthnicity ++ " " ++
      appRace1 + " " ++
      appRace2 + " " ++
      appRace3 + " " ++
      appRace4 + " " ++
      appRace5 + " " ++
      coAppEthnicity ++ " " ++
      coAppRace1 + " " ++
      coAppRace2 + " " ++
      coAppRace3 + " " ++
      coAppRace4 + " " ++
      coAppRace5 + " " ++
      appSex + " " ++
      coAppSex + " " ++
      appIncome + " " ++
      purchaserType + " " ++
      denial1 + " " ++
      denial2 + " " ++
      denial3 + " " ++
      rateSpread + " " ++
      hoepaStatus + " " ++
      lienStatus
  }

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
