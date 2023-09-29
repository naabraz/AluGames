package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.modelo.Gamer
import br.com.nataliabraz.alugames.modelo.Jogo
import br.com.nataliabraz.alugames.servicos.ConsumoApi
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)

    do {
        println("Digite o código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }

        resultado.onFailure {
            print("br.com.nataliabraz.alugames.modelo.Jogo inexistente. Tente outro id.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")

            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Insira a descrição personalizada para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }

            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()
    } while(resposta.equals("s", true))

    println("Jogos buscados:")
    println(gamer.jogosBuscados)
    println("Busca finalizada com sucesso.")
}