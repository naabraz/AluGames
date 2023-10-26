package br.com.nataliabraz.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "gamers")
class GamerEntity(
    val nome: String = "Nome do Gamer",
    val email: String = "Email do Gamer",
    val dataNascimento: String? = null,
    val usuario: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0) {
}