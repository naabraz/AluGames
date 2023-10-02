package br.com.nataliabraz.alugames.utilitario

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade(): Int {
    var idade = 0

    val idadeFormatter = runCatching {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val dataNascimento = LocalDate.parse(this, formatter)

        val hoje = LocalDate.now()
        idade = Period.between(dataNascimento, hoje).years
    }

    idadeFormatter.onSuccess {
        return idade
    }

    idadeFormatter.onFailure {
        println("Data de nascimento incorreta.")
    }

    return 0
}