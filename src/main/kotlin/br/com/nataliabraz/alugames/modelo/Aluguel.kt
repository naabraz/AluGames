package br.com.nataliabraz.alugames.modelo

import kotlin.math.roundToInt
import kotlin.math.roundToLong

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {

    val valorDoAluguel = jogo.preco * periodo.emDias

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor de: R$: ${valorDoAluguel.roundToLong()}"
    }
}
