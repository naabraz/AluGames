package br.com.nataliabraz.alugames.modelo

import java.math.BigDecimal
import java.math.RoundingMode

class PlanoAssinatura(
    tipo: String,
    val mensalidade: BigDecimal,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: BigDecimal,
    id: Int = 0): Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): BigDecimal {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1

        return if (totalJogosNoMes <= jogosIncluidos) {
            BigDecimal("0.0")
        } else {
            var valorOriginal = super.obterValor(aluguel)

            if (aluguel.gamer.media > 8) {
                valorOriginal -= valorOriginal.multiply(percentualDescontoReputacao)
            }

            return valorOriginal.setScale(2, RoundingMode.HALF_EVEN)
        }
    }

    override fun toString(): String {
        return "Plano Assinatura\n" +
                "Tipo: $tipo\n" +
                "Id: $id\n" +
                "Mensalidade: $mensalidade\n" +
                "Jogos Incluidos: $jogosIncluidos\n" +
                "Percentual Desconto Reputacao: $percentualDescontoReputacao\n"
    }
}
