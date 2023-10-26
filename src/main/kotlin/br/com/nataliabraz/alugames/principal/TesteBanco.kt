package br.com.nataliabraz.alugames.principal

import br.com.nataliabraz.alugames.dados.Banco
import br.com.nataliabraz.alugames.dados.GamerDAO
import br.com.nataliabraz.alugames.dados.JogosDAO
import br.com.nataliabraz.alugames.modelo.Gamer
import br.com.nataliabraz.alugames.modelo.Jogo

fun main() {
    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogo2 = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99, "Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")
    val gamer = Gamer("Natalia", "nat@email.com","04/01/1991", "nat")

    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = GamerDAO(manager)

    jogoDAO.adicionarJogo(jogo2)
    gamerDAO.adicionarGamer(gamer)

    val listaJogos: List<Jogo> = jogoDAO.getJogos()
    val listaGamers: List<Gamer> = gamerDAO.getGamers()

//    print(listaJogos)
    print(listaGamers)

    manager.close()
}