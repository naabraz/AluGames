package br.com.nataliabraz.alugames.dados

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}