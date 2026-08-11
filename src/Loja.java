package src;

import java.util.ArrayList;

public class Loja {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Pagamento> pagamentos;

    public Loja() {
        this.funcionarios = new ArrayList<Funcionario>();
        this.pagamentos = new ArrayList<Pagamento>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        Funcionario encontrado = null;

        for (int i = 0; i < this.funcionarios.size(); i++) {
            Funcionario funcionario = this.funcionarios.get(i);
            if (funcionario.getId() == id) {
                encontrado = funcionario;
            }
        }

        return encontrado;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        Funcionario existente = this.buscarFuncionarioPorId(funcionario.getId());

        if (existente == null) {
            this.funcionarios.add(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Já existe um funcionário cadastrado com esse ID. Cadastro não realizado.");
        }
    }

    public void listarFuncionarios() {
        if (this.funcionarios.size() == 0) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (int i = 0; i < this.funcionarios.size(); i++) {
                Funcionario funcionario = this.funcionarios.get(i);
                funcionario.mostrarDados();
                System.out.println("------------------------------");
            }
        }
    }

    // procura o funcionario pelo id e confere se a senha bate
    public Funcionario autenticar(int id, String senha) {
        Funcionario funcionario = this.buscarFuncionarioPorId(id);

        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            return funcionario;
        }

        return null;
    }

    public void cadastrarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }

    public void listarPagamentos() {
        if (this.pagamentos.size() == 0) {
            System.out.println("Nenhum pagamento cadastrado.");
        } else {
            for (int i = 0; i < this.pagamentos.size(); i++) {
                Pagamento pagamento = this.pagamentos.get(i);
                pagamento.mostrarPagamento();
                System.out.println("------------------------------");
            }
        }
    }

    // mostra todas as vendas e o total das que foram aprovadas
    public void gerarRelatorioVendas() {
        if (this.pagamentos.size() == 0) {
            System.out.println("Nenhuma venda registrada até o momento.");
        } else {
            double totalVendas = 0;

            System.out.println("--- Relatório de Vendas ---");
            for (int i = 0; i < this.pagamentos.size(); i++) {
                Pagamento pagamento = this.pagamentos.get(i);
                pagamento.mostrarPagamento();
                System.out.println("------------------------------");

                if (pagamento.getStatus().equals("APROVADO")) {
                    totalVendas = totalVendas + pagamento.getValor();
                }
            }

            System.out.println("Total de vendas aprovadas: R$" + totalVendas);
        }
    }
}   