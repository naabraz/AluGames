package br.com.nataliabraz.alugames.dados

 import br.com.nataliabraz.alugames.modelo.Jogo
 import br.com.nataliabraz.alugames.utilitario.toEntity
 import br.com.nataliabraz.alugames.utilitario.toModel
 import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(
    manager,
    JogoEntity::class.java) {
    override fun toEntity(jogo: Jogo): JogoEntity {
        return jogo.toEntity()
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return entity.toModel()
    }
}