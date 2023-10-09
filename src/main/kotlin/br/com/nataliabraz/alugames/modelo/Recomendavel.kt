package br.com.nataliabraz.alugames.modelo

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}