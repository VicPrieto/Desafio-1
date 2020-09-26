package br.com.digitalhouse.desafio

class Aluno(val nome: String, val sobrenome: String, val codigoAluno: Int) {
    override fun equals(other: Any?): Boolean {
        other as Aluno
        return this.codigoAluno == other.codigoAluno
    }
}