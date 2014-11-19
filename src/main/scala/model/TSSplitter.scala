package model

trait TSSplitter {

  def split(s: String): String = {
    val id = s.toList(0).toString
    val respId = s.substring(1, 11)
    val code = s.substring(11, 12)
    val timestamp = s.substring(12, 24)
    val activityYear = s.substring(25, 29)
    val taxId = s.substring(29, 39)

    id ++ " " ++
      respId ++ " " ++
      code ++ " " ++
      timestamp ++ " " ++
      activityYear ++ " " ++
      taxId
  }

}
