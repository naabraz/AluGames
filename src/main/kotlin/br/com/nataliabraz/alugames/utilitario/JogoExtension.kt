package br.com.nataliabraz.alugames.utilitario

import br.com.nataliabraz.alugames.dados.JogoEntity
import br.com.nataliabraz.alugames.modelo.InfoJogoJson
import br.com.nataliabraz.alugames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao)
}

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(
        this.titulo,
        this.capa,
        this.preco.toDouble(),
        this.descricao,
        this.id)
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao,
        this.id)
}
