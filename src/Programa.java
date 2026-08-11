package src;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        int opcao = 0;

        do {
            System.out.println("======= LOGIN ======");
            System.out.println("1 - Acessar Sistema");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                acessarSistema(scanner, loja);

            } else if (opcao == 2) {
                System.out.println("Encerrando o programa...");

            } else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 2);

        scanner.close();
    }
    //acessar sistema
    private static void acessarSistema(Scanner scanner, Loja loja) {
        int perfil = 0;

        do {
            System.out.println("");
            System.out.println("1 - Gerente");
            System.out.println("2 - Operador de Caixa");
            System.out.println("3 - Voltar");
            System.out.print("Escolha uma opção: ");
            perfil = scanner.nextInt();

            if (perfil == 1) {
                fazerLoginGerente(scanner, loja);

            } else if (perfil == 2) {
                fazerLoginOperador(scanner, loja);

            } else if (perfil == 3) {
                System.out.println("Voltando ao menu principal...");

            } else {
                System.out.println("Opção inválida!");
            }

        } while (perfil != 3 && perfil != 1 && perfil != 2);
    }

    private static void fazerLoginGerente(Scanner scanner, Loja loja) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Funcionario funcionario = loja.autenticar(id, senha);

        if (funcionario != null && funcionario instanceof Gerente) {
            Gerente gerente = (Gerente) funcionario;
            System.out.println("Login realizado com sucesso! Bem-vindo(a), " + gerente.getNome() + ".");
            menuGerente(scanner, loja, gerente);
        } else {
            System.out.println("ID, senha inválidos ou este perfil não é de Gerente.");
        }
    }

    private static void fazerLoginOperador(Scanner scanner, Loja loja) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Funcionario funcionario = loja.autenticar(id, senha);

        if (funcionario != null && funcionario instanceof OperadorCaixa) {
            OperadorCaixa operador = (OperadorCaixa) funcionario;
            System.out.println("Login realizado com sucesso! Bem-vindo(a), " + operador.getNome() + ".");
            menuOperador(scanner, loja, operador);
        } else {
            System.out.println("ID, senha inválidos ou este perfil não é de Operador de Caixa.");
        }
    }

    // menu de funcionalidades do gerente
    private static void menuGerente(Scanner scanner, Loja loja, Gerente gerente) {
        int opcao = 0;

        do {
            System.out.println("");
            System.out.println("--- Funcionalidades do Gerente ---");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Cadastrar Gerente");
            System.out.println("3 - Listar Funcionários");
            System.out.println("4 - Gerar Relatório de Vendas");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                cadastrarOperador(scanner, loja);

            } else if (opcao == 2) {
                cadastrarGerente(scanner, loja);

            } else if (opcao == 3) {
                System.out.println("");
                System.out.println("--- Lista de Funcionários ---");
                loja.listarFuncionarios();

            } else if (opcao == 4) {
                System.out.println("");
                loja.gerarRelatorioVendas();

            } else if (opcao == 5) {
                System.out.println("Voltando...");

            } else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 5);
    }

    // menu de funcionalidades do operador de caixa
    private static void menuOperador(Scanner scanner, Loja loja, OperadorCaixa operador) {
        int opcao = 0;

        do {
            System.out.println("");
            System.out.println("--- Funcionalidades do Operador de Caixa ---");
            System.out.println("1 - Abrir Caixa");
            System.out.println("2 - Fechar Caixa");
            System.out.println("3 - Realizar Pagamento");
            System.out.println("4 - Listar Pagamentos");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                operador.abrirCaixa();

            } else if (opcao == 2) {
                operador.fecharCaixa();

            } else if (opcao == 3) {
                if (operador.getStatusCaixa().equals("ABERTO")) {
                    realizarPagamento(scanner, loja);
                } else {
                    System.out.println("O caixa está fechado. Abra o caixa antes de realizar pagamentos.");
                }

            } else if (opcao == 4) {
                System.out.println("");
                System.out.println("--- Lista de Pagamentos ---");
                loja.listarPagamentos();

            } else if (opcao == 5) {
                System.out.println("Voltando...");

            } else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 5);
    }

    private static void cadastrarGerente(Scanner scanner, Loja loja) {
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
        System.out.print("Senha de acesso: ");
        String senha = scanner.nextLine();
        System.out.print("Setor: ");
        String setor = scanner.nextLine();
        System.out.print("Bônus: ");
        double bonus = scanner.nextDouble();

        Gerente gerente = new Gerente(id, nome, cpf, salario, cargo, senha, setor, bonus);
        loja.adicionarFuncionario(gerente);
    }

    private static void cadastrarOperador(Scanner scanner, Loja loja) {
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
        System.out.print("Senha de acesso: ");
        String senha = scanner.nextLine();
        System.out.print("Número do caixa: ");
        int numeroCaixa = scanner.nextInt();

        OperadorCaixa operador = new OperadorCaixa(id, nome, cpf, salario, cargo, senha, numeroCaixa);
        loja.adicionarFuncionario(operador);
    }

    // fluxo completo de realizar um pagamento (Pix, Boleto ou Cartão)
    private static void realizarPagamento(Scanner scanner, Loja loja) {
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
    }
}