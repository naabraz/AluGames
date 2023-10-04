package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogo("151")
    val jogoJson = consumo.buscaJogosJson()

    println(listaGamers)
    println(jogoApi)
    println(jogoJson)
}