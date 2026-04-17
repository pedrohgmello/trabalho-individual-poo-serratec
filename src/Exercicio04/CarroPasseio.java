package Exercicio04;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class CarroPasseio extends Veiculo{

    public CarroPasseio(
            String placa,
            String marca,
            int anoFabricacao
    ){
        super(placa,marca,anoFabricacao);
    }

    @Override
    public BigDecimal alugarVeiculo(double pesoCarga, int dias) {
        return this.getValorLocacaoDiaria().multiply(BigDecimal.valueOf(dias));
    }

    @Override
    public BigDecimal calcularIpva() {
        int anoAtual = LocalDate.now().getYear();
        if(anoAtual - this.getAnoFabricacao() >= 20) return new BigDecimal("0.00");
        BigDecimal taxa = new BigDecimal("0.04");
        return this.getPrecoFipe().multiply(taxa);
    }
}
