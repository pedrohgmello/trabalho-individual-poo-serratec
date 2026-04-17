package Exercicio04;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Caminhao extends Veiculo{
    private final double capacidadeCargaToneladas;

    public Caminhao(
            double capacidadeCargaToneladas,
            String placa,
            String marca,
            int anoFabricacao
    ) {
        super(placa,marca,anoFabricacao);
        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
    }

    @Override
    public BigDecimal alugarVeiculo(double pesoCarga, int dias) {
        if (dias <= 0 || pesoCarga < 0) {
            throw new IllegalArgumentException("Dias e peso da carga devem ser positivos.");
        }

        BigDecimal valorTotal = this.getValorLocacaoDiaria().multiply(BigDecimal.valueOf(dias));

        if (pesoCarga > capacidadeCargaToneladas) {
            BigDecimal taxa = new BigDecimal("1.10");
            return valorTotal.multiply(taxa);
        }
        return valorTotal;
    }

    @Override
    public BigDecimal calcularIpva() {
        int anoAtual = LocalDate.now().getYear();
        if(anoAtual - this.getAnoFabricacao() >= 20) return new BigDecimal("0.00");
        BigDecimal taxa = new BigDecimal("0.015");
        return this.getPrecoFipe().multiply(taxa);
    }
}
