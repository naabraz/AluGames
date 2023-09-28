package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.modelo.Gamer

fun main () {
    val gamer1 = Gamer("Nat", "nat@email.com")

    val gamer2 = Gamer(
        "Bia",
        "anabeatriz@email.com",
        "08/03/2002",
        "superbia")

    gamer1.let {
        it.dataNascimento = "04/01/1991"
        it.usuario = "nat"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)

    gamer1.usuario = "Jacque"

    println(gamer1)

    println(gamer2)
}