package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()

//    println(listaGamers)
//    println(jogoJson)

    val gamerCaroline = listaGamers[3]
    val jogoResidentVillage = listaJogoJson[10]

    println(gamerCaroline)
    println(jogoResidentVillage)

    val aluguel = gamerCaroline.alugaJogo(jogoResidentVillage)

    println(aluguel)
}