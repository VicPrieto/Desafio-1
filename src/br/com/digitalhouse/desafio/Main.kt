package br.com.digitalhouse.desafio

import java.time.LocalDate

fun main() {

    //ALUNOS
    val aluno1 = Aluno("Gabriel", "Piccolo", 80001)
    val aluno2 = Aluno("Rue", "Bennet", 80002)
    val aluno3 = Aluno("Jules", "Vaughn", 80003)
    val aluno4 = Aluno("Daniel", "Ceasar", 80004)
    var alunos = mutableListOf(aluno1, aluno2, aluno3, aluno4)

    //PROFS
    val prof1 = ProfessorTitular("Matt", "Maesom", 0, 60001, "Kotlin")
    val prof2 = ProfessorAdjunto("Alex", "Benjamin", 2, 60002, 300)
    val prof3 = ProfessorTitular("Clara", "Laffut", 8, 60003, "UX/UX Design")
    val prof4 = ProfessorAdjunto("Pedro", "Costa", 1, 60004, 50)
    var professoresTit = mutableListOf(prof1, prof3)
    var professoresAdj = mutableListOf(prof2, prof4)

    //CURSOS
    val curso1 = Curso("Web Java", 20001, 3)
    val curso2 = Curso("Mobile Kotlin", 20002, 2)
    var cursos = mutableListOf(curso1, curso2)

    //MATRICULAS
    val matricula1 = Matricula(aluno1, curso1, LocalDate.now())
    var matriculas: MutableList<Matricula> = mutableListOf(matricula1)

    val manager = DigitalHouseManager(alunos, professoresTit, professoresAdj, cursos, matriculas)

    //Registrando cursos, professores e alunos
//    manager.registrarCurso(curso1)
//    manager.registrarCurso(curso2)
//    manager.registrarProfAdj(prof2)
//    manager.registrarProfTit(prof1)
//    manager.registrarAluno(aluno1)

    //Excluindo cursos e professores
//    manager.excluirCurso(20001)
//    manager.excluirProfAdj(60002)
//    manager.excluirProfTit(60001)

    //Alocando professores
    manager.alocarProfessores(20001, 60001, 60002)
    manager.alocarProfessores(20002, 60003, 60004)

    //Matriculando alunos
//    manager.matricularAluno(80002, 20001)
//    manager.matricularAluno(80003, 20001)

//    manager.matricularAluno(80001, 20002)
//    manager.matricularAluno(80004, 20002)
//    manager.matricularAluno(80002, 20002)
    }

