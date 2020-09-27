package br.com.digitalhouse.desafio

import java.time.LocalDate
import java.util.*

class DigitalHouseManager(
    var alunos: MutableList<Aluno>,
    var professoresTit: MutableList<ProfessorTitular>,
    var professoresAdj: MutableList<ProfessorAdjunto>,
    var cursos: MutableList<Curso>,
    var matriculas: MutableList<Matricula>
) {

    fun registrarCurso(curso: Curso) {
        cursos.add(curso)
        println("O curso ${curso.nome} foi adicionado com sucesso :)")
    }

    fun excluirCurso(codigoCurso: Int) {
        var curso = cursos.groupBy(Curso::codigoCurso, Curso::nome)
        cursos.remove(curso)
        println("O curso ${curso.get(codigoCurso)} foi removido :(")
    }

    fun registrarProfAdj(professorA: ProfessorAdjunto) {
        professorA.tempoDeCasa = 0
        professoresAdj.add(professorA)
        println("Os professores adjacentes atuais são: ${professoresAdj}")
    }

    fun registrarProfTit(professorA: ProfessorTitular) {
        professorA.tempoDeCasa = 0
        professoresTit.add(professorA)
        println("Os professores titulares atuais são: ${professoresAdj}")
    }

    fun excluirProfAdj(codigoProf: Int) {
        var prof = professoresAdj.groupBy(ProfessorAdjunto::codigoProf, ProfessorAdjunto::nome)
        professoresAdj.remove(prof)
        println("O Professor Adjunto ${prof.get(codigoProf)} foi removido :(")
    }

    fun excluirProfTit(codigoProf: Int) {
        var prof = professoresTit.groupBy(ProfessorTitular::codigoProf, ProfessorTitular::nome)
        professoresTit.remove(prof)
        println("O Professor Titular ${prof.get(codigoProf)} foi removido :(")
    }

    fun registrarAluno(aluno: Aluno) {
        alunos.add(aluno)
        println("O ${aluno.nome} ${aluno.sobrenome} foi registrado com sucesso :)")
    }

//    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
//        var cursoM = cursos.groupBy(Curso::codigoCurso, Curso::nome)
//        var alunoM = alunos.groupBy(Aluno::codigoAluno, Aluno::nome)
//        var aluno: Aluno
//        var curso: Curso
//        var data: LocalDate = LocalDate.now()
//
//        if (curso.vagas > alunos.size){
//            var matricula = Matricula(aluno, curso, data)
//            matriculas.add(matricula)
//            println("Matrícula realizada com sucesso :)")
//        }else{
//            println("Não foi possível realizar a matrícula pois todas as vagas já foram preenchidas :(")
//        }
//    }

    fun alocarProfessores(codigoCurso: Int, codigoProfT: Int, codigoProfA: Int) {
        var profT = professoresTit.groupBy(ProfessorTitular::codigoProf, ProfessorTitular::nome)
        var profA = professoresAdj.groupBy(ProfessorAdjunto::codigoProf, ProfessorAdjunto::nome)
        var curso = cursos.groupBy(Curso::codigoCurso, Curso::nome)
//        var profT = professoresTit.associateBy { it.codigoProf }
//        var profA = professoresAdj.associateBy { it.codigoProf }
//        var curso = cursos.associateBy { it.codigoCurso }

        println("O ${curso.get(codigoCurso)} tem ${profT.get(codigoProfT)} como professor titular e ${profA.get(codigoProfA)} como professor adjunto.")
    }
}