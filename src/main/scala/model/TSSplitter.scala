package model

trait TSSplitter {

  def split(s: String): String = {
    println(s.length)
    val id = s.toList(0).toString
    val respId = s.substring(1, 11)
    val code = s.substring(11, 12)
    val timestamp = s.substring(12, 24)
    val activityYear = s.substring(25, 29)
    val taxId = s.substring(29, 39)
    val totalLines = s.substring(39, 46)
    val respName = s.substring(46, 76).stripMargin
    val respAddress = s.substring(76, 116).stripMargin
    val respCity = s.substring(116, 141).stripMargin
    val respState = s.substring(141, 143)
    val respZip = s.substring(143, 153).stripMargin
    val parentName = s.substring(153, 183)
    val parentAddress = s.substring(183, 223)
    val parentCity = s.substring(223, 248)
    val parentState = s.substring(248, 250)
    val parentZip = s.substring(250, 260)
    val contactPerson = s.substring(260, 290)
    val contactPhone = s.substring(290, 302)
    val contactFax = s.substring(302, 314)
    val contactEmail = s.substring(314, s.length).stripMargin

    id ++ " " ++
      respId ++ " " ++
      code ++ " " ++
      timestamp ++ " " ++
      activityYear ++ " " ++
      taxId ++ " " ++
      totalLines ++ " " ++
      respName ++ " " ++
      respAddress ++ " " ++
      respCity ++ " " ++
      respState ++ " " ++
      respZip ++ " " ++
      parentName ++ " " ++
      parentAddress ++ " " ++
      parentCity ++ " " ++
      parentState ++ " " ++
      parentZip ++ " " ++
      contactPerson ++ " " ++
      contactPhone ++ " " ++
      contactFax ++ " " ++
      contactEmail

  }

}
