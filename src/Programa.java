package src;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        int opcao = 0;

        do {
            System.out.println("");
            System.out.println("===== BEM VINDO AO PDV =====");
            System.out.println("1 - Cadastrar Gerente");
            System.out.println("2 - Cadastrar Operador de Caixa");
            System.out.println("3 - Realizar Pagamento");
            System.out.println("4 - Listar Funcionários");
            System.out.println("5 - Listar Pagamentos");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("");
                System.out.println("--- Cadastro de Gerente ---");
                System.out.print("ID do funcionário: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Salário: ");
                double salario = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();
                System.out.print("Setor: ");
                String setor = scanner.nextLine();
                System.out.print("Bônus: ");
                double bonus = scanner.nextDouble();

                Gerente gerente = new Gerente(id, nome, cpf, salario, cargo, setor, bonus);
                loja.adicionarFuncionario(gerente);

            } else if (opcao == 2) {
                System.out.println("");
                System.out.println("--- Cadastro de Operador de Caixa ---");
                System.out.print("ID do funcionário: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Salário: ");
                double salario = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();
                System.out.print("Número do caixa: ");
                int numeroCaixa = scanner.nextInt();

                OperadorCaixa operador = new OperadorCaixa(id, nome, cpf, salario, cargo, numeroCaixa);
                loja.adicionarFuncionario(operador);

            } else if (opcao == 3) {
                System.out.println("");
                System.out.println("--- Realizar Pagamento ---");
                System.out.print("Valor da venda: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("");
                System.out.println("===== FORMA DE PAGAMENTO =====");
                System.out.println("1 - PIX");
                System.out.println("2 - Boleto");
                System.out.println("3 - Cartão");
                System.out.print("Escolha uma opção: ");
                int formaPagamento = scanner.nextInt();
                scanner.nextLine();

                int numeroPagamento = loja.getPagamentos().size() + 1;

                if (formaPagamento == 1) {
                    System.out.print("Chave Pix: ");
                    String chavePix = scanner.nextLine();

                    Pix pix = new Pix(numeroPagamento, valor, chavePix);
                    pix.processarPagamento();
                    loja.cadastrarPagamento(pix);

                } else if (formaPagamento == 2) {
                    System.out.print("Código de barras: ");
                    String codigoBarras = scanner.nextLine();

                    Boleto boleto = new Boleto(numeroPagamento, valor, codigoBarras);
                    boleto.processarPagamento();
                    loja.cadastrarPagamento(boleto);

                } else if (formaPagamento == 3) {
                    System.out.println("");
                    System.out.println("===== TIPO DE CARTÃO =====");
                    System.out.println("1 - Débito");
                    System.out.println("2 - Crédito");
                    System.out.print("Escolha uma opção: ");
                    int tipoCartao = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Número do cartão: ");
                    String numeroCartao = scanner.nextLine();
                    System.out.print("Nome do titular: ");
                    String nomeTitular = scanner.nextLine();
                    System.out.print("Bandeira: ");
                    String bandeira = scanner.nextLine();
                    System.out.print("CVV: ");
                    String cvv = scanner.nextLine();

                    if (tipoCartao == 1) {
                        System.out.print("Saldo disponível no cartão: ");
                        double saldoDisponivel = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Senha do cartão: ");
                        String senhaCartao = scanner.nextLine();

                        CartaoDebito cartaoDebito = new CartaoDebito(numeroPagamento, valor, numeroCartao, nomeTitular, bandeira, cvv, saldoDisponivel, senhaCartao);
                        cartaoDebito.processarPagamento();
                        loja.cadastrarPagamento(cartaoDebito);

                    } else if (tipoCartao == 2) {
                        System.out.print("Limite disponível no cartão: ");
                        double limiteDisponivel = scanner.nextDouble();

                        System.out.println("Como deseja pagar?");
                        System.out.println("1 - À vista");
                        System.out.println("2 - Parcelado");
                        System.out.print("Escolha uma opção: ");
                        int tipoPagamento = scanner.nextInt();

                        if (tipoPagamento == 2) {
                            System.out.print("Quantidade de parcelas: ");
                            int quantidadeParcelas = scanner.nextInt();

                            CartaoCredito cartaoCredito = new CartaoCredito(numeroPagamento, valor, numeroCartao, nomeTitular, bandeira, cvv, limiteDisponivel, quantidadeParcelas);
                            cartaoCredito.processarPagamento();
                            loja.cadastrarPagamento(cartaoCredito);

                        } else {
                            CartaoCredito cartaoCredito = new CartaoCredito(numeroPagamento, valor, numeroCartao, nomeTitular, bandeira, cvv, limiteDisponivel);
                            cartaoCredito.processarPagamento();
                            loja.cadastrarPagamento(cartaoCredito);
                        }

                    } else {
                        System.out.println("Tipo de cartão inválido!");
                    }

                } else {
                    System.out.println("Forma de pagamento inválida!");
                }

            } else if (opcao == 4) {
                System.out.println("");
                System.out.println("--- Lista de Funcionários ---");
                loja.listarFuncionarios();

            } else if (opcao == 5) {
                System.out.println("");
                System.out.println("--- Lista de Pagamentos ---");
                loja.listarPagamentos();

            } else if (opcao == 6) {
                System.out.println("Encerrando o programa...");

            } else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 6);

        scanner.close();
    }
}