package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.dados.Banco

fun main() {
    val conexao = Banco.obterConexao()
    println(conexao)
}