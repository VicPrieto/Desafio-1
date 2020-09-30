package br.com.digitalhouse.desafio

data class ProfessorTitular(override val nome: String, override val sobrenome: String, override var tempoDeCasa: Int, override val codigoProf: Int, var especialidade: String) :
    Professor(nome, sobrenome, tempoDeCasa, codigoProf) {
}