package Exercicio04;

import java.math.BigDecimal;

public abstract sealed class Veiculo implements Fretavel, Tributavel permits Caminhao, CarroPasseio {
    private final String placa;
    private final String marca;
    private BigDecimal valorLocacaoDiaria;
    private final int anoFabricacao;
    private BigDecimal precoFipe;

    public Veiculo(
            String placa,
            String marca,
            int anoFabricacao
    ){
        if (placa == null || placa.isBlank() || anoFabricacao < 1886) { // 1886: ano do 1º carro
            throw new IllegalArgumentException("Dados do veículo inválidos.");
        }
        this.placa = placa;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public BigDecimal getValorLocacaoDiaria() {
        return valorLocacaoDiaria;
    }

    public void setValorLocacaoDiaria(BigDecimal valorLocacaoDiaria) {
        this.valorLocacaoDiaria = valorLocacaoDiaria;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public BigDecimal getPrecoFipe() {
        return precoFipe;
    }

    public void setPrecoFipe(BigDecimal precoFipe) {
        this.precoFipe = precoFipe;
    }
}
