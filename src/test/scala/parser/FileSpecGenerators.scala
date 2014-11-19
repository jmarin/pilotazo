package parser

import model._
import org.scalacheck.{ Arbitrary, Prop, Gen }
import org.scalacheck.Prop.forAll

trait FileSpecGenerators {

  implicit def loan: Gen[Loan] = {
    for {
      id <- Arbitrary.arbitrary[String]
      date <- Arbitrary.arbitrary[String]
      loanType <- Arbitrary.arbitrary[Int]
      propertyType <- Arbitrary.arbitrary[Int]
      purpose <- Arbitrary.arbitrary[Int]
      occupancy <- Arbitrary.arbitrary[Int]
      amount <- Arbitrary.arbitrary[Int]
    } yield Loan(id, date, loanType, propertyType, purpose, occupancy, amount)
  }

}
