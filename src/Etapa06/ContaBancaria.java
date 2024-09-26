package Etapa06;

public class ContaBancaria {
    private double saldo; // Aqui fica o dinheiro da conta
    private int contadorConsultas; // Conta quantas vezes o saldo foi consultado

    // Construtor
    public ContaBancaria(double saldoInicial) {
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial; // Define o saldo inicial
        } else {
            this.saldo = 0; // Se o saldo inicial for negativo, a gente coloca como 0
            System.out.println("Saldo inicial não pode ser negativo, vamos deixar como 0.");
        }
        this.contadorConsultas = 0; // Começa com zero consultas
    }

    // Método para fazer um depósito
    public void deposito(double valor) {
        if (valor > 0) { // verifica se o valor é positivo
            double taxa = valor * 0.01; // Taxa de 1%
            saldo += (valor - taxa); // Adiciona o valor menos a taxa ao saldo
            System.out.println("Depósito de R$" + valor + " feito com sucesso! Taxa de R$" + taxa + " aplicada.");
        } else {
            System.out.println("O valor do depósito precisa ser positivo."); // Mensagem de erro para valor inválido
        }
    }

    // Método para fazer um saque
    public void saque(double valor) {
        if (valor > 0) { // Verifica se o valor do saque é positivo
            double taxa = valor * 0.005; // Taxa de 0,5%
            if (saldo >= (valor + taxa)) { // Confere se o saldo é suficiente
                saldo -= (valor + taxa); // Deduz o valor do saque e a taxa do saldo
                System.out.println("Saque de R$" + valor + " realizado com sucesso! Taxa de R$" + taxa + " aplicada.");
            } else {
                System.out.println("Saldo insuficiente para fazer o saque."); // Mensagem de erro se não tiver saldo
            }
        } else {
            System.out.println("O valor do saque precisa ser positivo."); // Mensagem de erro para valor inválido
        }
    }

    // Método para consultar o saldo
    public double consultaSaldo() {
        contadorConsultas++; // Incrementa o contador de consultas
        if (contadorConsultas % 5 == 0) { // A cada 5 consultas, cobra uma taxa
            saldo -= 0.10; // Deduz 10 centavos do saldo
            System.out.println("Cobrança de R$0.10 pela consulta de saldo.");
        }
        return saldo; // Retorna o saldo atual
    }

    // Método para obter o saldo atual
    public double getSaldo() {
        return saldo; // Retorna o saldo atual
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000); // Cria uma conta com R$1000
        conta.deposito(500); // Faz um depósito de R$500
        conta.saque(200); // Faz um saque de R$200
        System.out.println("Saldo atual: R$" + conta.consultaSaldo()); // Consulta o saldo
        conta.consultaSaldo(); // Consulta o saldo de novo
        conta.consultaSaldo(); // E mais uma vez
        conta.consultaSaldo(); // Outra consulta
        conta.consultaSaldo(); // Última consulta (cobrança de taxa aqui)
        System.out.println("Saldo final: R$" + conta.getSaldo()); // Mostra o saldo final
    }
}

