import java.math.BigDecimal;
import java.util.Scanner;

public class SimuladorCaixaEletronico {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        BigDecimal saldo = new BigDecimal("00.00");
        int saquesFeitos = 0;
        int opc = 9;
        double valorSaque = 0.0;
        double valorDeposito = 0.0;
        boolean sistemaEstaVivo = true;
        final double LIMITE_SAQUE = 1000.00;

        while(sistemaEstaVivo) {
            do {
                System.out.println("Escolha a ação: ");
                System.out.println("1 - Ver Saldo");
                System.out.println("2 - Depositar");
                System.out.println("3 - Sacar");
                System.out.println("0 - Sair");
                opc = scanner.nextInt();

                switch (opc) {
                    case 1:
                        verSaldo(saldo);
                        break;
                    case 2:
                        System.out.println("Digite o valor do deposito: ");
                        valorDeposito = scanner.nextDouble();
                        saldo = depositar(new BigDecimal(valorDeposito), saldo);
                        verSaldo(saldo);
                        valorDeposito = 0.0;
                        break;
                    case 3:
                        System.out.println("Digite o valor do saque: ");
                        valorSaque = scanner.nextDouble();
                        if(!(saquesFeitos >= 3)) {
                            if (!(valorSaque > LIMITE_SAQUE)) {
                                if(valorSaque < saldo.doubleValue()) {
                                    saldo = sacar(new BigDecimal(valorSaque), saldo);
                                    saquesFeitos++;
                                } else
                                    System.out.println("Saldo insuficiente");
                            } else
                                System.out.println("O valor máximo de saque é: R$" + LIMITE_SAQUE);
                        } else
                            System.out.println("Você só pode sacar 3 vezes ao dia.");
                        verSaldo(saldo);
                        valorSaque = 0.0;
                        break;
                    case 0:
                        sistemaEstaVivo = false;
                }

            } while (opc != 0 && opc != 1 && opc != 2 && opc != 3);
        }

    }

    public static BigDecimal depositar(BigDecimal valor, BigDecimal saldo){
        return saldo.add(valor);
    }

    public static BigDecimal sacar(BigDecimal valor, BigDecimal saldo){
        return saldo.subtract(valor);
    }

    public static void verSaldo(BigDecimal saldo){
        System.out.println("====== SALDO DA CONTA ======");
        System.out.println(saldo);
        System.out.println();
    }
}
