package br.com.nataliabraz.alugames.dados

import br.com.nataliabraz.alugames.modelo.Aluguel
import br.com.nataliabraz.alugames.utilitario.toEntity
import br.com.nataliabraz.alugames.utilitario.toModel
import javax.persistence.EntityManager

class AluguelDAO(manager: EntityManager): DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java) {
    override fun toEntity(objeto: Aluguel): AluguelEntity {
        return AluguelEntity(objeto.gamer.toEntity(), objeto.jogo.toEntity(), objeto.periodo)
            .apply { valorDoAluguel = objeto.valorDoAluguel.toDouble()
                id = objeto.id
            }
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(entity.gamer.toModel(), entity.jogo.toModel(), entity.periodo)
            .apply { id = entity.id }
    }
}