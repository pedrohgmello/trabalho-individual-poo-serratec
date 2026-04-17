package Exercicio04;

import java.math.BigDecimal;

public class LocacaoMain {
    public static void main(String[] args) {
        try {
            // 1. Criando um Caminhão
            Caminhao caminhao = new Caminhao(10.0, "ABC-1234", "Volvo", 2010);
            caminhao.setPrecoFipe(new BigDecimal("200000.00"));
            caminhao.setValorLocacaoDiaria(new BigDecimal("500.00"));

            // Teste Aluguel Caminhão com sobrecarga (> 10t)
            BigDecimal aluguelCaminhao = caminhao.alugarVeiculo(12.0, 5);
            System.out.println("Caminhão Volvo - IPVA: R$ " + caminhao.calcularIpva());
            System.out.println("Caminhão Volvo - Aluguel (5 dias c/ sobrecarga): R$ " + aluguelCaminhao);

            System.out.println("------------------------------");

            // 2. Criando um Carro de Passeio (Isento - mais de 20 anos)
            CarroPasseio carro = new CarroPasseio("GHI-9012", "Honda Civic", 2000);
            carro.setPrecoFipe(new BigDecimal("40000.00"));
            carro.setValorLocacaoDiaria(new BigDecimal("150.00"));

            System.out.println("Civic 2000 - IPVA (Isento): R$ " + carro.calcularIpva());
            System.out.println("Civic 2000 - Aluguel (3 dias): R$ " + carro.alugarVeiculo(0, 3));

            // 3. Testando uma Exceção (Parâmetro Inválido)
            System.out.println("\n--- Testando Erro ---");
            carro.alugarVeiculo(0, -1); // Vai lançar exceção

        } catch (IllegalArgumentException e) {
            System.err.println("Erro de Validação: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}