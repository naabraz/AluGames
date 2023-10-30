package br.com.nataliabraz.alugames.dados

import br.com.nataliabraz.alugames.modelo.Plano
import br.com.nataliabraz.alugames.modelo.PlanoAssinatura
import br.com.nataliabraz.alugames.modelo.PlanoAvulso
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {
    override fun toEntity(plano: Plano): PlanoEntity {
        return if (plano is PlanoAssinatura) {
            PlanoAssinaturaEntity(
                plano.tipo,
                plano.mensalidade.toDouble(),
                plano.jogosIncluidos,
                plano.percentualDescontoReputacao.toDouble(),
                plano.id)
        } else {
            PlanoAvulsoEntity(plano.tipo, plano.id)
        }
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return if (entity is PlanoAssinaturaEntity) {
            PlanoAssinatura(
                entity.tipo,
                entity.mensalidade.toBigDecimal(),
                entity.jogosIncluidos,
                entity.percentualDescontoReputacao.toBigDecimal(),
                entity.id)
        } else {
            PlanoAvulso(entity.tipo, entity.id)
        }
    }
}