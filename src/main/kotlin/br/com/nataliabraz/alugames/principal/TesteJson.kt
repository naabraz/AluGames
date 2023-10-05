package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.modelo.Periodo
import br.com.nataliabraz.alugames.servicos.ConsumoApi
import java.time.LocalDate

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

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val aluguel = gamerCaroline.alugaJogo(jogoResidentVillage, periodo)

    println(aluguel)
}