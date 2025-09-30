package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {
  val cj = new ConjuntosDifusos

  // TESTS PARA PERTENECE

  test("pertenece con número 0 debe dar 0.0") {
    val grandes = cj.grande(2, 2)
    assert(cj.pertenece(0, grandes) == 0.0)
  }

  test("pertenece con número 1 en grande(2,2)") {
    val grandes = cj.grande(2, 2)
    assert(Math.abs(cj.pertenece(1, grandes) - 0.11) < 0.01)
  }

  test("pertenece con número 10 en grande(2,2)") {
    val grandes = cj.grande(2, 2)
    assert(Math.abs(cj.pertenece(10, grandes) - 0.69) < 0.01)
  }

  test("pertenece con número 100 en grande(2,2)") {
    val grandes = cj.grande(2, 2)
    assert(Math.abs(cj.pertenece(100, grandes) - 0.96) < 0.01)
  }

  test("pertenece con número 50 en grande(2,2)") {
    val grandes = cj.grande(2, 2)
    assert(Math.abs(cj.pertenece(50, grandes) - 0.92) < 0.01)
  }

  // TESTS PARA GRANDE

  test("grande(1,2) con x=1 debe dar 0.25") {
    val g1 = cj.grande(1, 2)
    assert(Math.abs(g1(1) - 0.25) < 0.01)
  }

  test("grande(1,2) con x=10 debe ser cercano a 0.82") {
    val g1 = cj.grande(1, 2)
    assert(Math.abs(g1(10) - 0.82) < 0.01)
  }

  test("grande(5,3) con x=5 debe dar (5/10)^3") {
    val g2 = cj.grande(5, 3)
    assert(Math.abs(g2(5) - Math.pow(5.0/10.0, 3)) < 0.01)
  }

  test("grande(5,3) con x=20 debe dar (20/25)^3") {
    val g2 = cj.grande(5, 3)
    assert(Math.abs(g2(20) - Math.pow(20.0/25.0, 3)) < 0.01)
  }

  test("grande con d=0 debe lanzar IllegalArgumentException") {
    intercept[IllegalArgumentException] {
      cj.grande(0, 2)
    }
  }

  // TESTS PARA COMPLEMENTO

  test("complemento de x=0 debe ser 1") {
    val grandes = cj.grande(2, 2)
    val noGrandes = cj.complemento(grandes)
    assert(Math.abs(noGrandes(0) - 1.0) < 0.01)
  }

  test("complemento de x=10 en grande(2,2)") {
    val grandes = cj.grande(2, 2)
    val noGrandes = cj.complemento(grandes)
    assert(Math.abs(noGrandes(10) - (1 - 0.69)) < 0.01)
  }

  test("complemento de x=100 en grande(2,2)") {
    val grandes = cj.grande(2, 2)
    val noGrandes = cj.complemento(grandes)
    assert(Math.abs(noGrandes(100) - (1 - 0.96)) < 0.01)
  }

  test("complemento de x=2 en grande(2,2)") {
    val grandes = cj.grande(2, 2)
    val noGrandes = cj.complemento(grandes)
    assert(Math.abs(noGrandes(2) - (1 - grandes(2))) < 0.01)
  }

  test("complemento de x=50 en grande(2,2)") {
    val grandes = cj.grande(2, 2)
    val noGrandes = cj.complemento(grandes)
    assert(Math.abs(noGrandes(50) - (1 - grandes(50))) < 0.01)
  }
  // TESTS PARA UNION
  test("union de conjuntos con parámetros distintos y x=18") {
    val grandes = cj.grande(8, 8)
    val masGrande = cj.grande(15, 9)
    val unionConjuntos = cj.union(grandes, masGrande)
    assert(Math.abs(unionConjuntos(18) - Math.max(grandes(18), masGrande(18))) < 0.01)
  }

  test("union de conjuntos con parámetros distintos y x=50") {
    val grandes = cj.grande(10, 13)
    val masGrande = cj.grande(20, 11)
    val unionConjuntos = cj.union(grandes, masGrande)
    assert(Math.abs(unionConjuntos(50) - Math.max(grandes(50), masGrande(50))) < 0.01)
  }

  test("union de conjuntos con parámetros distintos y x=5") {
    val grandes = cj.grande(3, 5)
    val masGrande = cj.grande(7, 4)
    val unionConjuntos = cj.union(grandes, masGrande)
    assert(Math.abs(unionConjuntos(5) - Math.max(grandes(5), masGrande(5))) < 0.01)
  }

  test("union de conjuntos con parámetros invertidos y x=25") {
    val grandes = cj.grande(12, 6)
    val masGrande = cj.grande(6, 12)
    val unionConjuntos = cj.union(grandes, masGrande)
    assert(Math.abs(unionConjuntos(25) - Math.max(grandes(25), masGrande(25))) < 0.01)
  }

  test("union de conjuntos con valores grandes y x=100") {
    val grandes = cj.grande(50, 10)
    val masGrande = cj.grande(100, 8)
    val unionConjuntos = cj.union(grandes, masGrande)
    assert(Math.abs(unionConjuntos(100) - Math.max(grandes(100), masGrande(100))) < 0.01)
  }

  // TESTS PARA INTERSECCION
  test("interseccion de conjuntos con parámetros distintos y x=18") {
    val grandes = cj.grande(8, 8)
    val masGrande = cj.grande(15, 9)
    val interseccionConjuntos = cj.interseccion(grandes, masGrande)
    assert(Math.abs(interseccionConjuntos(18) - Math.min(grandes(18), masGrande(18))) < 0.01)
  }

  test("interseccion de conjuntos con parámetros distintos y x=50") {
    val grandes = cj.grande(10, 13)
    val masGrande = cj.grande(20, 11)
    val interseccionConjuntos = cj.interseccion(grandes, masGrande)
    assert(Math.abs(interseccionConjuntos(50) - Math.min(grandes(50), masGrande(50))) < 0.01)
  }

  test("interseccion de conjuntos con parámetros distintos y x=5") {
    val grandes = cj.grande(3, 5)
    val masGrande = cj.grande(7, 4)
    val interseccionConjuntos = cj.interseccion(grandes, masGrande)
    assert(Math.abs(interseccionConjuntos(5) - Math.min(grandes(5), masGrande(5))) < 0.01)
  }

  test("interseccion de conjuntos con parámetros invertidos y x=25") {
    val grandes = cj.grande(12, 6)
    val masGrande = cj.grande(6, 12)
    val interseccionConjuntos = cj.interseccion(grandes, masGrande)
    assert(Math.abs(interseccionConjuntos(25) - Math.min(grandes(25), masGrande(25))) < 0.01)
  }

  test("interseccion de conjuntos con valores grandes y x=100") {
    val grandes = cj.grande(50, 10)
    val masGrande = cj.grande(100, 8)
    val interseccionConjuntos = cj.interseccion(grandes, masGrande)
    assert(Math.abs(interseccionConjuntos(100) - Math.min(grandes(100), masGrande(100))) < 0.01)
  }
}
