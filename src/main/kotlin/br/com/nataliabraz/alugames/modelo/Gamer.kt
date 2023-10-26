package br.com.nataliabraz.alugames.modelo

import br.com.nataliabraz.alugames.utilitario.formatoComDuasCasasDecimais
import java.lang.IllegalArgumentException
import java.util.Scanner
import kotlin.random.Random

data class Gamer(
    var nome: String,
    var email: String): Recomendavel {
    var dataNascimento: String? = null

    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }

    var id = 0
    var idInterno: String? = null
        private set

    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosBuscados = mutableListOf<Jogo?>()
    private val jogosAlugados = mutableListOf<Aluguel>()
    private val listaNotas = mutableListOf<Int>()
    val jogosRecomendados = mutableListOf<Jogo>()

    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        if (nota in 1..10) {
            listaNotas.add(nota)
        } else {
            println("Recomendação com nota inválida: $nota.")
        }
    }

    fun recomendarJogo(jogo: Jogo, nota: Int) {
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

    constructor(nome: String,
                email: String,
                dataNascimento: String?,
                usuario: String?,
                id: Int = 0): this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        this.id = id
        criarIdInterno()
    }

    init {
        if (nome.isBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer: \n" +
                "Nome: $nome \n" +
                "Email: $email \n" +
                "Data de Nascimento: $dataNascimento \n" +
                "Usuário: $usuario \n" +
                "ID Interno: $idInterno\n" +
                "Reputação: $media\n" +
                "Id: $id"
    }

    private fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    private fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun alugaJogo(
        jogo: Jogo,
        periodo: Periodo): Aluguel {

        val aluguel = Aluguel(this, jogo, periodo)

        jogosAlugados.add(aluguel)

        return aluguel
    }

    fun jogosDoMes(mes: Int): List<Jogo> {
        return jogosAlugados
            .filter { aluguel -> aluguel.periodo.dataInicial.month.value == mes }
            .map { aluguel -> aluguel.jogo }
    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            return if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                Gamer(nome, email, nascimento, usuario)
            } else {
                Gamer(nome, email)
            }
        }
    }
}
