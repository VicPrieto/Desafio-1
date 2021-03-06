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
    fun registrarCurso(nome: String, codigoCurso: Int, vagas: Int): Curso {
        var cursoNovo: Curso = Curso(nome, codigoCurso, vagas, mutableListOf())
        cursos.add(cursoNovo)
        println("O curso ${cursoNovo.nome} foi registrado com sucesso :)")
        return cursoNovo
    }

    fun excluirCurso(codigoCurso: Int) {
        var curso = cursos.groupBy(Curso::codigoCurso, Curso::nome)
        cursos.remove(curso)
        println("O curso ${curso.get(codigoCurso)} foi excluido :(")
    }

    fun registrarProfAdj(nome: String, sobrenome: String, codigoProf: Int): ProfessorAdjunto {
        var professorA = ProfessorAdjunto(nome, sobrenome, 0, codigoProf, 0)
        professoresAdj.add(professorA)
        println("O(a) professor(a) adjunto(a) ${professorA.nome} ${professorA.sobrenome} foi registrado(a) com sucesso :)")
        return professorA
    }

    fun registrarProfTit(nome: String, sobrenome: String, codigoProf: Int, especialidade: String): ProfessorTitular {
        var professorT = ProfessorTitular(nome, sobrenome, 0, codigoProf, especialidade)
        professoresTit.add(professorT)
        println("O(a) professor(a) titular ${professorT.nome} ${professorT.sobrenome} foi registrado(a) com sucesso :)")
        return professorT
    }

    fun excluirProfAdj(codigoProf: Int) {
        var profA = professoresAdj.groupBy(ProfessorAdjunto::codigoProf, ProfessorAdjunto::nome)
        professoresTit.remove(profA)
        println("O(a) professor(a) adjunto(a) ${profA.get(codigoProf)} foi excluído(a) :(")
    }

    fun excluirProfTit(codigoProf: Int) {
        var profT = professoresTit.groupBy(ProfessorTitular::codigoProf, ProfessorTitular::nome)
        professoresTit.remove(profT)
        println("O(a) professor titular ${profT.get(codigoProf)} foi excluído(a) :(")
    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int): Aluno {
        var aluno = Aluno(nome, sobrenome, codigoAluno)
        println("O(a) aluno(a) ${aluno.nome} ${aluno.sobrenome} foi registrado(a) com sucesso :)")
        return aluno
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
            cursoM.adcAluno(alunoM)
            println(
                "Aluno(a) ${alunoM.nome} ${alunoM.sobrenome} matrículado(a) com sucesso no curso ${cursoM.nome} :)" +
                        "\nVagas restantes: ${cursoM.vagas}."
            )
        } else {
            println("Não foi possível matricular o(a) aluno(a) ${alunoM.nome} ${alunoM.sobrenome} pois todas as vagas do curso ${cursoM.nome} já foram preenchidas :(")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfT: Int, codigoProfA: Int) {
        lateinit var profT: ProfessorTitular
        lateinit var profA: ProfessorAdjunto
        lateinit var cursoA: Curso
        for (prof in professoresTit) {
            if (prof.codigoProf == codigoProfT) {
                profT = prof
            }
        }
        for (prof in professoresAdj) {
            if (prof.codigoProf == codigoProfA) {
                profA = prof
            }
        }
        for (curso in cursos) {
            if (curso.codigoCurso == codigoCurso) {
                cursoA = curso
            }
        }

        println("Os(as) professores(as) ${profT.nome} ${profT.sobrenome} (Titular, com especialidade em ${profT.especialidade}) e ${profA.nome} ${profA.sobrenome} (Adjunto, com ${profA.horasDeMonitoria} horas de monitoria) foram alocados(as) no curso ${cursoA.nome}!")

//        var profT = professoresTit.groupBy(ProfessorTitular::codigoProf, ProfessorTitular::nome)
//        var profA = professoresAdj.groupBy(ProfessorAdjunto::codigoProf, ProfessorAdjunto::nome)
//        var curso = cursos.groupBy(Curso::codigoCurso, Curso::nome)
//        println( "Os(as) professores(as) ${profT.get(codigoProfT)} -Titular e ${profA.get(codigoProfA)} -Adjunto- foram alocados(as) no curso ${curso.get(codigoCurso)}.")
    }
}