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
        println("O/A professor(a) ${professorA.nome} ${professorA.sobrenome} foi registrado com sucesso!")
    }

    fun registrarProfTit(professorA: ProfessorTitular) {
        professorA.tempoDeCasa = 0
        professoresTit.add(professorA)
        println("O/A professor(a) ${professorA.nome} ${professorA.sobrenome} foi registrado com sucesso!")
    }

    fun excluirProfAdj(codigoProf: Int) {
        lateinit var prof: ProfessorAdjunto
        for (professor: ProfessorAdjunto in professoresAdj) {
            if (professor.codigoProf == codigoProf) {
                prof = professor
                professoresAdj.remove(prof)
            }
        }
        println("O/A Prof ${prof.nome} foi removido.")
    }

    fun excluirProfTit(codigoProf: Int) {
        var profT = professoresTit.groupBy(ProfessorTitular::codigoProf, ProfessorTitular::nome)
        professoresTit.remove(profT)
        println("O Professor Titular ${profT.get(codigoProf)} foi removido :(")
    }

    fun registrarAluno(aluno: Aluno) {
        alunos.add(aluno)
        println("O ${aluno.nome} ${aluno.sobrenome} foi registrado com sucesso :)")
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        lateinit var cursoM: Curso
        lateinit var alunoM: Aluno
        var data: LocalDate = LocalDate.now()

        for (curso: Curso in cursos) {
            if (curso.codigoCurso == codigoCurso) {
                cursoM = curso
            }
        }
        for (aluno: Aluno in alunos) {
            if (aluno.codigoAluno == codigoAluno) {
                alunoM = aluno
            }
        }

        if (cursoM.vagas > matriculas.size) {
            var matricula: Matricula = Matricula(alunoM, cursoM, data)
            matriculas.add(matricula)
            println("Matrícula realizada com sucesso :)")
        } else {
            println("Não foi possível realizar a matrícula pois todas as vagas já foram preenchidas :(")
        }

    }

    fun alocarProfessores(codigoCurso: Int, codigoProfT: Int, codigoProfA: Int) {
        var profT = professoresTit.groupBy(ProfessorTitular::codigoProf, ProfessorTitular::nome)
        var profA = professoresAdj.groupBy(ProfessorAdjunto::codigoProf, ProfessorAdjunto::nome)
        var curso = cursos.groupBy(Curso::codigoCurso, Curso::nome)


        println(
            "\nO ${curso.get(codigoCurso)} tem ${profT.get(codigoProfT)} como professor titular e ${
                profA.get(
                    codigoProfA
                )
            } como professor adjunto."
        )
    }
}