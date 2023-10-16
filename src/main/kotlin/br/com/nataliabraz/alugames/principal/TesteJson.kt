package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.modelo.Periodo
import br.com.nataliabraz.alugames.modelo.PlanoAssinatura
import br.com.nataliabraz.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()

//    println(listaGamers)
//    println(jogoJson)

    val gamerCaroline = listaGamers[3]
    val jogoResidentVillage = listaJogoJson[10]
    jogoResidentVillage.recomendar(5)
    jogoResidentVillage.recomendar(8)
    jogoResidentVillage.recomendar(3)

    val jogoSpiderMan = listaJogoJson[13]
    jogoSpiderMan.recomendar(8)
    jogoSpiderMan.recomendar(7)
    jogoSpiderMan.recomendar(10)

    val jogoTheLastOfUs = listaJogoJson[2]
    jogoTheLastOfUs.recomendar(10)
    jogoTheLastOfUs.recomendar(10)
    jogoTheLastOfUs.recomendar(9)

    val jogoDandara = listaJogoJson[5]
    val jogoAssassins = listaJogoJson[4]
    val jogoCyber = listaJogoJson[6]
    val jogoGod = listaJogoJson[7]
    val jogoSkyrim = listaJogoJson[18]

//    println(jogoResidentVillage)
//    println(jogoSpiderMan)
//    println(jogoTheLastOfUs)

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
    gamerCamila.plano = PlanoAssinatura("PRATA", BigDecimal(9.90), 3, BigDecimal(0.15))

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    gamerCamila.alugaJogo(jogoSpiderMan, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
//    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(5)
    gamerCamila.recomendar(8)
//    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
//    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)

    gamerCaroline.recomendarJogo(jogoResidentVillage, 8)
    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 9)

    println("Recomendações da Camila")
    println(gamerCamila.jogosRecomendados)

    println("Recomendações da Caroline")
    println(gamerCaroline.jogosRecomendados)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpiderMan, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
//    println(arquivo.absolutePath)
}