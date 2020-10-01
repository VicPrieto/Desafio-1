package br.com.digitalhouse.desafio

data class Curso(val nome: String, val codigoCurso: Int, var vagas: Int) {
    override fun equals(other: Any?): Boolean {
        other as Curso
        return this.codigoCurso == other.codigoCurso
    }

    var alunosDoCurso: MutableList<Aluno> = mutableListOf()

    fun adcAluno(aluno: Aluno): Boolean {
        return if (alunosDoCurso.size < vagas) {
            alunosDoCurso.add(aluno)
            true
        } else {
            false
        }
    }

    fun excluirAluno(aluno: Aluno) {
        alunosDoCurso.remove(aluno)
        println("${aluno.nome} ${aluno.nome} foi removido.")
    }
}