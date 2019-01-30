package xyz.trankvila.menteia

import scala.util.Random

object Vortilo {
  val komenco: Map[String, Double] = Map(
    "k1" -> 0.5,
    "k2" -> 0.3,
    "k3" -> 0.1,
    "k1k2" -> 0.1
  )

  val k1: Map[String, Double] = Map(
    "p" -> 0.15,
    "b" -> 0.05,
    "t" -> 0.25,
    "d" -> 0.15,
    "k" -> 0.25,
    "g" -> 0.1,
    "f" -> 0.05
  )

  val k2: Map[String, Double] = Map(
    "r" -> 0.4,
    "l" -> 0.6
  )

  val k3: Map[String, Double] = Map(
    "m" -> 0.3,
    "n" -> 0.2,
    "v" -> 0.2,
    "s" -> 0.2,
    "ʃ" -> 0.1
  )

  val vokalo: Map[String, Double] = Map(
    "a" -> 0.3,
    "e" -> 0.1,
    "i" -> 0.3,
    "o" -> 0.2,
    "u" -> 0.1
  )

  val fino: Map[String, Double] = Map(
    "" -> 0.7,
    "s" -> 0.07,
    "m" -> 0.13,
    "n" -> 0.1
  )

  val silaboj: Map[Int, Double] = Map(
    1 -> 0.2,
    2 -> 0.5,
    3 -> 0.3
  )

  def elekti[T](opcioj: Map[T, Double]): T = {
    var p = Random.nextDouble()
    for ((opcio, ebleco) <- opcioj) {
      if (p < ebleco) {
        return opcio
      }
      p = p - ebleco
    }
    sys.error("Ne pli da opcioj")
  }

  def kreiSilabon(): String = {
    val komencoTipo = elekti(Vortilo.komenco)
    val vokalo = elekti(Vortilo.vokalo)
    val fino = elekti(Vortilo.fino)
    val komenco = komencoTipo match {
      case "k1" => elekti(k1)
      case "k2" => elekti(k2)
      case "k1k2" => elekti(k1) + elekti(k2)
      case "k3" => elekti(k3)
      case _ => sys.error("Kio okazis?!")
    }
    komenco + vokalo + fino
  }
}
