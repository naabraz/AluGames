package br.com.nataliabraz.alugames.dados

import br.com.nataliabraz.alugames.modelo.Jogo

class JogosDAO {
    fun getJogos(): List<Jogo> {
        val manager = Banco.getEntityManager()

        try {
            val query = manager.createQuery("FROM Jogo", Jogo::class.java)
            return query.resultList
        } finally {
            manager.close()
        }
    }

//    fun getJogos(): List<Jogo> {
//        val listaJogos = mutableListOf<Jogo>()
//        val conexao = Banco.obterConexao()
//
//        if (conexao != null) {
//            try {
//                val statement = conexao.createStatement()
//                val resultado = statement.executeQuery("SELECT * FROM JOGOS")
//
//                while (resultado.next()) {
//                    val id = resultado.getInt("id")
//                    val titulo = resultado.getString("titulo")
//                    val descricao = resultado.getString("descricao")
//                    val capa = resultado.getString("capa")
//                    val preco = resultado.getDouble("preco")
//
//                    val jogo = Jogo(titulo, capa, preco, descricao, id)
//
//                    listaJogos.add(jogo)
//                }
//
//                statement.close()
//            } finally {
//                conexao.close()
//            }
//        }
//
//        return listaJogos
//    }
//
//    fun adicionarJogo(jogo: Jogo) {
//        val conexao = Banco.obterConexao()
//        val insert = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"
//
//        if (conexao != null) {
//            try {
//                val statement = conexao.prepareStatement(insert)
//                statement.setString(1, jogo.titulo)
//                statement.setString(2, jogo.capa)
//                statement.setBigDecimal(3, jogo.preco)
//                statement.setString(4, jogo.descricao)
//
//                statement.executeUpdate()
//                statement.close()
//            } finally {
//                conexao.close()
//            }
//        }
//    }
}