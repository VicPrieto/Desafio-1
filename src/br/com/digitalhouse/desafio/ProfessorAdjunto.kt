package br.com.digitalhouse.desafio

data class ProfessorAdjunto(override val nome: String, override val sobrenome: String, override var tempoDeCasa: Int, override val codigoProf: Int, var horasDeMonitoria: Int) :
    Professor(nome, sobrenome, tempoDeCasa, codigoProf) {
}