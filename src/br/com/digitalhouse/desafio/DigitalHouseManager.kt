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
        cursos.remove(cursos.get(codigoCurso))
        println("O curso foi removido :(")
    }

    fun registrarProfAdj(professorA: ProfessorAdjunto) {
        professorA.tempoDeCasa = 0
        professoresAdj.add(professorA)
    }

    fun registrarProfTit(professorA: ProfessorTitular) {
        professorA.tempoDeCasa = 0
        professoresTit.add(professorA)
    }

    fun excluirProfAdj(codigoProf: Int) {
        professoresAdj.remove(cursos.get(codigoProf))
        println("O Professor Adjunto foi removido :(")
    }

    fun excluirProfTit(codigoProf: Int) {
        professoresTit.remove(cursos.get(codigoProf))
        println("O Professor Titular foi removido :(")
    }

    fun registrarAluno(aluno: Aluno) {
        alunos.add(aluno)
        println("O ${aluno.nome} ${aluno.sobrenome} foi registrado com sucesso :)")
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        var cursoM = cursos.get(codigoCurso)
        var alunoM = alunos.get(codigoAluno)
        var alunosDoCurso: MutableList<Aluno> = mutableListOf()
        var data: LocalDate = LocalDate.now()
        if (cursoM.vagas == alunosDoCurso.size) {
            var matricula = Matricula(alunoM, cursoM, data)
            matriculas.add(matricula)
            println("Matrícula realizada com sucesso :)")
        } else {
            println("Não foi possível realizar a matrícula pois todas as vagas já foram preenchidas :(")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfT: Int, codigoProfA: Int) {
        var profT = professoresTit.get(codigoProfT)
        var profA = professoresAdj.get(codigoProfA)
        var curso = cursos.get(codigoCurso)

        println("O ${curso.nome} tem ${profT.nome} como professor titular e ${profA.nome} como professor adjunto.")
    }
}