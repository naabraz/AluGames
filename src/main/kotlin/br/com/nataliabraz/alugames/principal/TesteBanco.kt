package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.dados.JogosDAO
import br.com.nataliabraz.alugames.modelo.Jogo

fun main() {
    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogoDAO = JogosDAO()
    jogoDAO.adicionarJogo(jogo)

    val listaJogos: List<Jogo> = jogoDAO.getJogos()
    print(listaJogos)
}