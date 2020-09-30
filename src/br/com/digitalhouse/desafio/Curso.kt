package br.com.digitalhouse.desafio

data class Curso(val nome: String, val codigoCurso: Int, var vagas: Int) {
    override fun equals(other: Any?): Boolean {
        other as Curso
        return this.codigoCurso == other.codigoCurso
    }

//    var alunosDoCurso: MutableList<Aluno> = mutableListOf()
//
//    fun adcAluno(aluno: Aluno): Boolean {
//        if (alunosDoCurso.size == vagas) {
//            println("Todas as vagas desse curso já foram preenchidas :(")
//            return false
//        } else {
//            alunosDoCurso.add(aluno)
//            println("${aluno.nome} ${aluno.sobrenome} adicionado com sucesso :)")
//            return true
//        }
//    }
//
//    fun excluirAluno(aluno: Aluno) {
//        alunosDoCurso.remove(aluno)
//        println("${aluno.nome} ${aluno.nome} foi removido.")
//    }
}