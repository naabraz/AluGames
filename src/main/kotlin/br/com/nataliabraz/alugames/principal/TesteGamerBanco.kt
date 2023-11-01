package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.dados.Banco
import br.com.nataliabraz.alugames.dados.GamerDAO
import br.com.nataliabraz.alugames.dados.PlanosDAO
import br.com.nataliabraz.alugames.modelo.Gamer

fun main(){
    val gamer = Gamer("Patricia", "pat@email.com", "15/10/1995", "pat")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamerDAO(manager)
    val planosDAO = PlanosDAO(manager)

    gamer.plano = planosDAO.recuperarPeloId(1)

    gamerDAO.adicionar(gamer)

    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}