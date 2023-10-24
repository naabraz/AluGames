package br.com.nataliabraz.alugames.modelo

import br.com.nataliabraz.alugames.utilitario.formatoComDuasCasasDecimais
import com.google.gson.annotations.Expose
import java.math.BigDecimal
import java.math.RoundingMode
import javax.persistence.*

@Entity
@Table (name = "jogos")
data class Jogo(
    @Expose val titulo: String,
    @Expose val capa: String): Recomendavel {

    var descricao: String? = null
    var preco = BigDecimal("0.0")

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id = 0
    private val listaNotas = mutableListOf<Int>()

    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String,
        id: Int = 0): this(titulo, capa) {
        this.preco = BigDecimal(preco).setScale(2, RoundingMode.HALF_EVEN)
        this.descricao = descricao
        this.id = id
    }

    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "Meu Jogo:\n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao \n" +
                "Preço: $preco \n" +
                "Reputação: $media\n" +
                "Id: $id"
    }
}