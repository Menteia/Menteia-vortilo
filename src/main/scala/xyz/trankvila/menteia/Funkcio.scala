package xyz.trankvila.menteia

import xyz.trankvila.menteia.Vortilo.{elekti, kreiSilabon, silaboj}

class Funkcio {
  def kreiVorton(): String = {
    val silaboKvanto = elekti(silaboj)
    silaboKvanto match {
      case 1 => kreiSilabon()
      case 2 => kreiSilabon() + kreiSilabon()
      case 3 => kreiSilabon() + kreiSilabon() + kreiSilabon()
      case _ => sys.error("Kio okazis?!")
    }
  }
}
