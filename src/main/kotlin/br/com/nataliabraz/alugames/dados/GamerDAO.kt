package br.com.nataliabraz.alugames.dados

import br.com.nataliabraz.alugames.modelo.Gamer
import javax.persistence.EntityManager

class GamerDAO(val manager: EntityManager) {
    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { entity -> Gamer(
            entity.nome,
            entity.email,
            entity.dataNascimento,
            entity.usuario)
        }
    }

    fun adicionarGamer(gamer: Gamer) {
        val entity = GamerEntity(
            gamer.nome,
            gamer.email,
            gamer.dataNascimento,
            gamer.usuario)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}