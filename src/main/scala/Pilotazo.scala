package pilotazo

import scala.io.Source
import model._
import parser._

object Pilotazo {

  def main(args: Array[String]) {
    val lines = Source.fromFile("src/main/resources/lar.dat").getLines().toList
    val tsLine = lines.head
    val tInput = TransmittalSheetParser.split(tsLine)
    println(tInput)
    val ts = TransmittalSheetParser(tInput)
    println(ts)
    val larLines = lines.tail
    var lars = larLines.map { line =>
      val input = LARParser.split(line)
      LARParser(input)
    }
    //val filespec = FileSpec(ts, lars)
    //println(lars)
  }

}
