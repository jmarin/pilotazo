package model

case class TransmittalSheet(
    id: Int,
    respId: String,
    code: Int,
    timestamp: Long,
    activityYear: Int,
    taxId: String,
    totalLines: Int,
    respondent: Respondent,
    parent: Parent,
    contact: Contact) {
  require(id == 1, "Firs record for Transmittal Sheet has to be 1")
}

case class Respondent(
  respName: String,
  respAddress: String,
  respCity: String,
  respState: String,
  respZip: String)

case class Parent(
  parentName: String,
  parentAddress: String,
  parentCity: String,
  parentState: String,
  parentZip: String)

case class Contact(
  contactPerson: String,
  contactPhone: String,
  contactFax: String,
  contactEmail: String)
