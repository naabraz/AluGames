package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.dados.AluguelDAO
import br.com.nataliabraz.alugames.dados.Banco
import br.com.nataliabraz.alugames.dados.GamerDAO
import br.com.nataliabraz.alugames.dados.JogosDAO
import br.com.nataliabraz.alugames.modelo.Periodo

fun main() {
    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val aluguelDAO = AluguelDAO(manager)

    val gamer = gamerDAO.recuperarPeloId(1)
    val jogo = jogoDAO.recuperarPeloId(1)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDAO.adicionar(aluguel)

    val listaAluguel = aluguelDAO.getLista()

    println(listaAluguel)

    manager.close()
}