package br.com.nataliabraz.alugames.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {

    private val valorDoAluguel = gamer.plano.obterValor(this)
    var id = 0

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor de: R$: $valorDoAluguel"
    }
}
