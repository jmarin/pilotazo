package model

case class FileSpec(ts: Option[TransmittalSheet], lars: Seq[Option[LAR]])
