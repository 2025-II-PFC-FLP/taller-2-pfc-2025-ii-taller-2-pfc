package taller

class ConjuntosDifusos {
  type ConjDifuso = Int => Double

  def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
  }
  def grande(d: Int, e: Int): ConjDifuso = {
    if (d == 0) throw new IllegalArgumentException("El parámetro d debe ser mayor o igual a 1")
    else {
      (x: Int) => Math.pow(x.toDouble / (x + d).toDouble, e.toDouble)
    }
  }
  def complemento(c: ConjDifuso): ConjDifuso = {
    (x: Int) => 1 - c(x)
  }

  def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    if (cd1 == null || cd2 == null) throw new IllegalArgumentException("Los conjuntos no pueden ser vacios")
    else {
      (x: Int) => Math.max(cd1(x), cd2(x))
    }
  }
  def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    if (cd1 == null || cd2 == null) throw new IllegalArgumentException("Los conjuntos no pueden ser vacios")
    else {
      (x: Int) => Math.min(cd1(x), cd2(x))
    }
  }
  /*
  def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    // Implementaci´on de la funci´on inclusion
  ...
  }
  def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    // Implementaci´on de la funci´on igualdad
  ...
  }*/
}

