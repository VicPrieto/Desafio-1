package br.com.digitalhouse.desafio

abstract class Professor(open val nome: String, open val sobrenome: String, open var tempoDeCasa: Int = 0, open val codigoProf: Int) {
    override fun equals(other: Any?): Boolean {
        other as Professor
        return this.codigoProf == other.codigoProf
    }
}