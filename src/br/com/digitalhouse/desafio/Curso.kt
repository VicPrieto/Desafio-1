package br.com.digitalhouse.desafio

data class Curso(
    val nome: String,
    val codigoCurso: Int,
    var vagas: Int,
    var alunosDoCurso: MutableList<Aluno>
) {
    init {
        var professorTitular: ProfessorTitular
        var professorAdjunto: ProfessorAdjunto
    }

    override fun equals(other: Any?): Boolean {
        other as Curso
        return this.codigoCurso == other.codigoCurso
    }
    init {
        var professorTitular: ProfessorTitular
        var professorAdjunto: ProfessorAdjunto
    }
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
        println("O(a) aluno(a) ${aluno.nome} ${aluno.sobrenome} foi excluido do curso $nome.")
    }
}