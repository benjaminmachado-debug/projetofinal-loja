package src;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        int opcao = 0;

        do {
            System.out.println("");
            System.out.println("=== SISTEMA DE PAGAMENTOS DA LOJA (PDV) ===");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Cadastrar Caixa");
            System.out.println("3 - Realizar Pagamento");
            System.out.println("4 - Listar Funcionários");
            System.out.println("5 - Listar Caixas");
            System.out.println("6 - Listar Pagamentos");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("");
                System.out.println("--- Cadastro de Funcionário ---");
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

                Funcionario funcionario = new Funcionario(id, nome, cpf, salario, cargo);
                loja.cadastrarFuncionario(funcionario);

            } else if (opcao == 2) {
                System.out.println("");
                System.out.println("--- Cadastro de Caixa ---");

                if (loja.getFuncionarios().size() == 0) {
                    System.out.println("Não há funcionários cadastrados. Cadastre um funcionário antes de abrir um caixa.");
                } else {
                    System.out.print("Número do caixa: ");
                    int numeroCaixa = scanner.nextInt();

                    loja.listarFuncionarios();
                    System.out.print("Digite o ID do funcionário responsável por este caixa: ");
                    int idOperador = scanner.nextInt();

                    Funcionario operador = loja.buscarFuncionarioPorId(idOperador);

                    if (operador == null) {
                        System.out.println("Funcionário não encontrado. Caixa não foi cadastrado.");
                    } else {
                        Caixa caixa = new Caixa(numeroCaixa, operador);
                        loja.cadastrarCaixa(caixa);
                    }
                }

            } else if (opcao == 3) {
                System.out.println("");
                System.out.println("--- Realizar Pagamento ---");
                System.out.print("Valor da venda: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Modalidade de pagamento (Dinheiro, Cartão, Pix...): ");
                String modalidade = scanner.nextLine();

                int numeroPagamento = loja.getPagamentos().size() + 1;
                Pagamento pagamento = new Pagamento(numeroPagamento);
                pagamento.realizarPagamento(valor, modalidade);
                loja.cadastrarPagamento(pagamento);

            } else if (opcao == 4) {
                System.out.println("");
                System.out.println("--- Lista de Funcionários ---");
                loja.listarFuncionarios();

            } else if (opcao == 5) {
                System.out.println("");
                System.out.println("--- Lista de Caixas ---");
                loja.listarCaixas();

            } else if (opcao == 6) {
                System.out.println("");
                System.out.println("--- Lista de Pagamentos ---");
                loja.listarPagamentos();

            } else if (opcao == 7) {
                System.out.println("Encerrando o programa...");

            } else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 7);

        scanner.close();
    }
}