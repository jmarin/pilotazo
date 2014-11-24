package persistence

import akka.persistence.PersistentView

class MyView extends PersistentView {

  override def persistenceId = "persistentActor-1"

  override def viewId = "view-1"

  var count: Int = 0

  def receive: Receive = {
    case payload if isPersistent =>
      println(payload)
      count += 1
      println(count)
    case payload =>
      println("Whaaat is this?")

  }

}
