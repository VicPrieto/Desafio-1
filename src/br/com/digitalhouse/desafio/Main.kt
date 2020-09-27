package br.com.digitalhouse.desafio

import java.time.LocalDate

fun main() {

    //ALUNOS
    val aluno1 = Aluno("Gabriel", "Piccolo", 80001)
    val aluno2 = Aluno("Rue", "Bennet", 80002)
    val aluno3 = Aluno("Jules", "Vaughn", 80003)
    val aluno4 = Aluno("Daniel", "Ceasar", 80003)
    var listaAluno = mutableListOf<Aluno>(aluno1, aluno2, aluno3, aluno4)

    //PROFS
    val prof1 = ProfessorTitular("Matt", "Maesom", 0, 60001, "Kotlin")
    val prof2 = ProfessorAdjunto("Alex", "Benjamin", 2, 60002, 300)
    val prof3 = ProfessorTitular("Clara", "Laffut", 8, 60003, "UX/UX Design")
    val prof4 = ProfessorAdjunto("Pedro", "Costa", 1, 60004, 50)
    var listaProfT = mutableListOf<ProfessorTitular>(prof1, prof3)
    var listaProfA = mutableListOf<ProfessorAdjunto>(prof2, prof4)

    //CURSOS
    val curso1 = Curso("Web Java", 20001, 3)
    val curso2 = Curso("Mobile Kotlin", 20002, 2)
    var listaCurso = mutableListOf<Curso>(curso1, curso2)

    //MATRICULAS
    val matricula1 = Matricula(aluno1, curso1, LocalDate.now())
    var listaMatricula = mutableListOf<Matricula>(matricula1)

    val manager = DigitalHouseManager(listaAluno, listaProfT, listaProfA, listaCurso, listaMatricula)


    manager.registrarCurso(curso1)
    manager.excluirCurso(20001)
    manager.registrarProfAdj(prof2)
    manager.registrarProfTit(prof1)
    manager.excluirProfAdj(60002)
    manager.excluirProfTit(60001)
    manager.registrarAluno(aluno1)

    println(
        "---- I: Alocando Professores ---- " +
                "\n ${manager.alocarProfessores(20001, 60001, 60002)}" +
                "\n ${manager.alocarProfessores(20002, 60003, 60004)}"
    )

//    println(
//        "---- II: Matriculando alunos no curso de ${curso1.nome}" +
//                "\n ${manager.matricularAluno(80002, 20001)}" +
//                "\n ${manager.matricularAluno(80003, 20001)}"
//    )
//
//    println(
//        "---- III: Matriculando alunos no curso de ${curso2.nome}" +
//                "\n ${manager.matricularAluno(80001, 20002)}" +
//                "\n ${manager.matricularAluno(80004, 20002)}" +
//                "\n ${manager.matricularAluno(80002, 20002)}"
//    )

}

