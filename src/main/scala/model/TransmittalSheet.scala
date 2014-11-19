package model

case class TransmittalSheet(
    id: Int) {
  require(id == 1, "Firs record for Transmittal Sheet has to be 1")
}
