package pilotazo

import scala.io.Source
import model._
import parser._
import akka.actor.{ ActorSystem, Props }
import persistence.{ ExamplePersistenceActor, MyView }
import persistence.Cmd

object Pilotazo extends LARSplitter {

  def main(args: Array[String]) {
    //val lines = Source.fromFile("src/main/resources/lar.dat").getLines().toList
    //val lines = Source.fromFile("/Users/marinj/Downloads/hmda_exports/bankofthewest.dat").getLines.toList
    val lines = Source.fromFile("/Users/marinj/Downloads/hmda_exports/arvestmortgagecompany.dat").getLines.toList
    val tsLine = lines.head
    val ts = TransmittalSheetReader(tsLine)
    val larLines = lines.tail
    var lars = larLines.map { line =>
      println(line)
      println(split(line))
      LARReader(line)
    }
    val filespec = FileSpec(ts, lars)
    //println(filespec)

    //val system = ActorSystem("hmda")
    //val persistentActor = system.actorOf(Props(classOf[ExamplePersistenceActor]), "persistentActor-1")
    //val viewActor = system.actorOf(Props(classOf[MyView]), "view-1")

    //lars.foreach { lar =>
    //  lar match {
    //    case Some(l) => persistentActor ! Cmd(l.toString)
    //    case None =>
    //  }
    //}

    //Thread.sleep(1000)
    //system.shutdown()
  }

}
