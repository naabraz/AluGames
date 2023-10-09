package br.com.nataliabraz.alugames.modelo

data class Jogo(
    val titulo: String,
    val capa: String): Recomendavel {

    var descricao: String? = null
    var preco = 0.0
    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String): this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "Meu Jogo:\n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao \n" +
                "Preço: $preco \n" +
                "Reputação: $media"
    }
}