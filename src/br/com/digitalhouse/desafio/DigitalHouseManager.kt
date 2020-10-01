package br.com.digitalhouse.desafio

import java.time.LocalDate
import java.util.*

class DigitalHouseManager(
    var alunos: MutableList<Aluno> = mutableListOf(),
    var professoresTit: MutableList<ProfessorTitular>,
    var professoresAdj: MutableList<ProfessorAdjunto>,
    var cursos: MutableList<Curso> = mutableListOf(),
    var matriculas: MutableList<Matricula> = mutableListOf()
) {

    fun registrarCurso(curso: Curso) {
        cursos.add(curso)
        println("O curso ${curso.nome} foi registrado com sucesso :)")
    }

    fun excluirCurso(codigoCurso: Int) {
        var curso = cursos.groupBy(Curso::codigoCurso, Curso::nome)
        cursos.remove(curso)
        println("O curso ${curso.get(codigoCurso)} foi excluido :(")
    }

    fun registrarProfAdj(professorA: ProfessorAdjunto) {
        professorA.tempoDeCasa = 0
        professoresAdj.add(professorA)
        println("O/A professor(a) ${professorA.nome} ${professorA.sobrenome} foi registrado com sucesso!")
    }

    fun registrarProfTit(professorA: ProfessorTitular) {
        professorA.tempoDeCasa = 0
        professoresTit.add(professorA)
        println("O/A professor(a) ${professorA.nome} ${professorA.sobrenome} foi registrado com sucesso!")
    }

    fun excluirProfAdj(codigoProf: Int) {
        var profA = professoresAdj.groupBy(ProfessorAdjunto::codigoProf, ProfessorAdjunto::nome)
        professoresTit.remove(profA)
        println("O Professor Adjunto ${profA.get(codigoProf)} foi excluído :(")
    }

    fun excluirProfTit(codigoProf: Int) {
        var profT = professoresTit.groupBy(ProfessorTitular::codigoProf, ProfessorTitular::nome)
        professoresTit.remove(profT)
        println("O Professor Titular ${profT.get(codigoProf)} foi excluído :(")
    }

    fun registrarAluno(aluno: Aluno) {
        alunos.add(aluno)
        println("O ${aluno.nome} ${aluno.sobrenome} foi registrado com sucesso :)")
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        lateinit var cursoM: Curso
        lateinit var alunoM: Aluno
        var data: LocalDate = LocalDate.now()

        for (curso in cursos) {
            if (curso.codigoCurso == codigoCurso) {
                cursoM = curso
            }
        }
        for (aluno in alunos) {
            if (aluno.codigoAluno == codigoAluno) {
                alunoM = aluno
            }
        }

        if (cursoM.vagas > 0) {
            var matricula: Matricula = Matricula(alunoM, cursoM, data)
            matriculas.add(matricula)
            cursoM.vagas -= 1
            println("Aluno(a) ${alunoM.nome} ${alunoM.sobrenome} matrículado com sucesso no curso ${cursoM.nome} :)" +
                    "\n Vagas restantes: ${cursoM.vagas}.")
        } else {
            println("Não foi possível matricular o ${alunoM.nome} ${alunoM.sobrenome} pois todas as vagas do curso ${cursoM.nome} já foram preenchidas :(")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfT: Int, codigoProfA: Int) {
        var profT = professoresTit.groupBy(ProfessorTitular::codigoProf, ProfessorTitular::nome)
        var profA = professoresAdj.groupBy(ProfessorAdjunto::codigoProf, ProfessorAdjunto::nome)
        var curso = cursos.groupBy(Curso::codigoCurso, Curso::nome)

        println(
            "Os(As) professores(as) ${profT.get(codigoProfT)} e ${profA.get(codigoProfA)} foram alocados(as) no curso ${curso.get(codigoCurso)}."
        )
    }
}