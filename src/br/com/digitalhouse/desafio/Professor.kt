package br.com.digitalhouse.desafio

abstract class Professor(val nome: String, val sobrenome: String, var tempoDeCasa: Int, val codigoProf: Int) {
    override fun equals(other: Any?): Boolean {
        other as Professor
        return this.codigoProf == other.codigoProf
    }
}