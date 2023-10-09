package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.modelo.Periodo
import br.com.nataliabraz.alugames.modelo.PlanoAssinatura
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
    val jogoSpiderMan = listaJogoJson[13]
    val jogoTheLastOfUs = listaJogoJson[2]

//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo4 = Periodo(LocalDate.of(2023,9,2), LocalDate.of(2023,9,15))

    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpiderMan, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCaroline.alugaJogo(jogoSpiderMan, periodo4)

//    println(gamerCaroline.jogosAlugados)
//    println(gamerCaroline.alugueisNoMes(9))

    val gamerCamila = listaGamers[5]
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    gamerCamila.alugaJogo(jogoSpiderMan, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    println(gamerCamila.jogosAlugados)
}