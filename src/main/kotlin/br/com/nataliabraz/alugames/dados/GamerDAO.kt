package br.com.nataliabraz.alugames.dados

import br.com.nataliabraz.alugames.modelo.Gamer
import br.com.nataliabraz.alugames.utilitario.toEntity
import br.com.nataliabraz.alugames.utilitario.toModel
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(
    manager,
    GamerEntity::class.java) {
    override fun toEntity(gamer: Gamer): GamerEntity {
        return gamer.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plano = entity.plano.toModel() }
    }
}