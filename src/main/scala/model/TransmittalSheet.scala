package model

case class TransmittalSheet(
    id: Int,
    respId: String,
    code: Int,
    timestamp: Long,
    activityYear: Int,
    taxId: String,
    totalLines: Int,
    respondent: Respondent) {
  require(id == 1, "Firs record for Transmittal Sheet has to be 1")
}

case class Respondent(
  name: String)
//address: String),
// city: String,
// state: String,
// zipCode: String)

case class Parent(
  name: String,
  address: String,
  city: String,
  state: String,
  zipCode: String)

case class Contact(
  name: String,
  phone: String,
  fax: String,
  email: String)
