package parser

trait LARSplitter {
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

}
