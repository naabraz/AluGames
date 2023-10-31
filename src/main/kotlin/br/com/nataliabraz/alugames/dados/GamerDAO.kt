package br.com.nataliabraz.alugames.dados

import br.com.nataliabraz.alugames.modelo.Gamer
import br.com.nataliabraz.alugames.utilitario.toEntity
import br.com.nataliabraz.alugames.utilitario.toModel
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(
    manager,
    GamerEntity::class.java) {
    override fun toEntity(objeto: Gamer): GamerEntity {
        return GamerEntity(
            objeto.id,
            objeto.nome,
            objeto.email,
            objeto.dataNascimento,
            objeto.usuario,
            objeto.plano.toEntity())
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(
            entity.nome,
            entity.email,
            entity.dataNascimento,
            entity.usuario,
            entity.id).apply { plano = entity.plano.toModel() }
    }
}