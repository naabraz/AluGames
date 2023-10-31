package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.dados.Banco
import br.com.nataliabraz.alugames.dados.PlanosDAO
import br.com.nataliabraz.alugames.modelo.PlanoAssinatura
import br.com.nataliabraz.alugames.modelo.PlanoAvulso

fun main() {
    val avulso = PlanoAvulso("BRONZE")
    val prata = PlanoAssinatura("PRATA", 9.90.toBigDecimal(), 3, 0.15.toBigDecimal())
    val ouro = PlanoAssinatura("OURO", 19.90.toBigDecimal(), 5, 0.20.toBigDecimal())
    val platina = PlanoAssinatura("PLATINA", 29.90.toBigDecimal(), 10, 0.30.toBigDecimal())
    val diamante = PlanoAssinatura("DIAMANTE", 49.90.toBigDecimal(), 20, 0.50.toBigDecimal())

    val manager = Banco.getEntityManager()
    val planosDAO = PlanosDAO(manager)

    planosDAO.adicionar(avulso)
//    planosDAO.adicionar(prata)
//    planosDAO.adicionar(ouro)
//    planosDAO.adicionar(platina)
//    planosDAO.adicionar(diamante)

    val listaPlanos = planosDAO.getLista()
    print(listaPlanos)

    manager.close()
}