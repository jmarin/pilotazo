package model

case class TransmittalSheet(
    id: Int,
    respId: String,
    code: Int,
    timestamp: Long,
    activityYear: Int,
    taxId: String) {
  require(id == 1, "Firs record for Transmittal Sheet has to be 1")
}
