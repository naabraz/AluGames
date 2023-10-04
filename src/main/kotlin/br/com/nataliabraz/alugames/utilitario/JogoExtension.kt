package br.com.nataliabraz.alugames.utilitario

import br.com.nataliabraz.alugames.modelo.InfoJogoJson
import br.com.nataliabraz.alugames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao)
}