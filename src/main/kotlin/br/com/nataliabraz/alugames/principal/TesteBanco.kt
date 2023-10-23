package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.dados.Banco
import br.com.nataliabraz.alugames.modelo.Jogo

fun main() {
    val listaJogos: List<Jogo> = Banco.getJogos()
    print(listaJogos)
}