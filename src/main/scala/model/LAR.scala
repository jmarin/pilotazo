package model

case class LAR(
  id: Int,
  respId: String,
  code: Int,
  loan: Loan,
  preapprovals: Int,
  actionType: Int,
  actionDate: Int,
  geography: Geography,
  applicant: Applicant)

case class Loan(
  id: String,
  date: String,
  loanType: Int,
  propertyType: Int,
  purpose: Int,
  occupancy: Int,
  amount: Integer)

case class Geography(
  msa: String,
  state: String,
  county: String,
  tract: String)

case class Applicant(
  ethnicity: Int,
  coEthnicity: Int,
  race1: Int,
  race2: String,
  race3: String,
  race4: String,
  race5: String,
  coRace1: Int,
  coRace2: String,
  coRace3: String,
  coRace4: String,
  coRace5: String,
  sex: Int,
  coSex: Int,
  income: String)

