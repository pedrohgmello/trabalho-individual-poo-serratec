package Exercicio02;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ContaBancariaMain {
    private static final double LIM_SAQUE = 1000.00;
    public static void main(String[] args){
        int idSerialContas = 0;
        List<ContaBancaria> contas = new ArrayList<>();
        var scanner = new Scanner(System.in);
        boolean sistemaEstaVivo = true;
        int opc = 9;
        int numContaBusca = 0;

        while(sistemaEstaVivo){
            do{
                System.out.println("Escolha a ação: ");
                System.out.println("1 - Criar conta");
                System.out.println("2 - Deletar conta");
                System.out.println("3 - Ver Saldo");
                System.out.println("4 - Depositar");
                System.out.println("5 - Sacar");
                System.out.println("0 - Sair");
                opc = scanner.nextInt();
                scanner.nextLine();

                switch(opc){
                    case 1:
                        System.out.println("Digite o nome do titular: ");
                        String titular = scanner.nextLine();
                        contas.add(criarContaBancaria(titular, idSerialContas, 50.0));
                        idSerialContas++;
                        break;
                    case 2:
                       System.out.println("Digite o numero da conta: ");
                       numContaBusca = scanner.nextInt();
                       scanner.nextLine();
                       deletarContaBancaria(contas, numContaBusca);
                       numContaBusca = 0;
                       break;
                    case 3:
                        System.out.println("Digite o numero da conta: ");
                        numContaBusca = scanner.nextInt();
                        scanner.nextLine();
                        verSaldo(numContaBusca, contas);
                        break;
                    case 4:
                        System.out.println("Digite o numero da conta: ");
                        numContaBusca = scanner.nextInt();
                        System.out.println("Digite o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        depositar(contas, valorDeposito, numContaBusca);
                        break;
                    case 5:
                        System.out.println("Digite o numero da conta: ");
                        numContaBusca = scanner.nextInt();
                        System.out.println("Digite o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        sacar(contas, valorSaque, numContaBusca);
                        break;
                    case 0:
                        System.out.println("Terminando o programa.");
                        sistemaEstaVivo = false;
                        break;
                    default:
                        System.out.println("Resposta inválida! Tente novamente");
                }
            }while(opc != 0 && opc != 1 && opc != 2 && opc != 3);
        }
    }

    private static ContaBancaria criarContaBancaria(String titular, int numero, double saldo){
        ContaBancaria novaContaBancaria = new ContaBancaria(titular, numero, saldo);
        return novaContaBancaria;
    }

    private static void deletarContaBancaria(List<ContaBancaria> contas, int numero){
        contas.removeIf(conta -> conta.getNumero() == numero);
    }

    private static void sacar(List<ContaBancaria> contas, double valor, int numConta){
        ContaBancaria conta = buscarConta(contas,numConta).orElse(null);
        if(conta == null){
            System.out.println("Conta não existe.");
            return;
        }
        if(conta.getNumSaques() >= 3){
            System.out.println("Limite de saques diários atingido.");
            return;
        }
        if(conta.getSaldo() < valor){
            System.out.println("Saldo insuficiente.");
            return;
        }
        if(valor > LIM_SAQUE){
            System.out.println("Limite do valor do saque é: R$" + LIM_SAQUE);
            return;
        }
        conta.sacar(valor);
        conta.setNumSaques(conta.getNumSaques()+1);
    }

    private static void depositar(List<ContaBancaria> contas, double valor, int numConta){
        ContaBancaria conta = buscarConta(contas,numConta).orElse(null);
        if(conta == null){
            System.out.println("Conta não existe.");
            return;
        }
        conta.depositar(valor);
    }

    private static void verSaldo(int numConta, List<ContaBancaria> contas){
        ContaBancaria conta = buscarConta(contas,numConta).orElse(null);
        if(conta == null){
            System.out.println("Conta não existe.");
            return;
        }
        System.out.println("====== SALDO DA CONTA: " + conta.getTitular() +  " ======");
        System.out.println(conta.getSaldo());
    }

    private static Optional<ContaBancaria> buscarConta(List<ContaBancaria> contas, int numConta){
        return contas.stream()
                .filter(conta -> conta.getNumero() == numConta)
                .findFirst();
    }
}
