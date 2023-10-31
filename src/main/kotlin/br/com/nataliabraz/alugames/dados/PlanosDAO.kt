package br.com.nataliabraz.alugames.dados

import br.com.nataliabraz.alugames.modelo.Plano
import br.com.nataliabraz.alugames.modelo.PlanoAssinatura
import br.com.nataliabraz.alugames.modelo.PlanoAvulso
import br.com.nataliabraz.alugames.utilitario.toEntity
import br.com.nataliabraz.alugames.utilitario.toModel
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {
    override fun toEntity(plano: Plano): PlanoEntity {
        return plano.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel()
    }
}