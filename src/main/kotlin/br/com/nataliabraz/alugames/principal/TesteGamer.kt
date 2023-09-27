import br.com.nataliabraz.alugames.modelo.Gamer

fun main () {
    val gamer1 = Gamer("Nat", "nat@email.com")

    val gamer2 = Gamer(
        "Bia",
        "bia@email.com",
        "08/03/2002",
        "superbia")

    gamer1.let {
        it.dataNascimento = "04/01/1991"
        it.usuario = "nat"
        it.idInterno= "nat1234"
    }

    println(gamer1)
    println(gamer2)
}