package br.com.nataliabraz.alugames.utilitario

import br.com.nataliabraz.alugames.modelo.Gamer
import br.com.nataliabraz.alugames.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
   return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}