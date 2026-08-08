package src;

import java.util.ArrayList;

public class Loja {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Caixa> caixas;
    private ArrayList<Pagamento> pagamentos;

    public Loja() {
        this.funcionarios = new ArrayList<Funcionario>();
        this.caixas = new ArrayList<Caixa>();
        this.pagamentos = new ArrayList<Pagamento>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Caixa> getCaixas() {
        return caixas;
    }

    public void setCaixas(ArrayList<Caixa> caixas) {
        this.caixas = caixas;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void cadastrarCaixa(Caixa caixa) {
        this.caixas.add(caixa);
        System.out.println("Caixa cadastrado com sucesso!");
    }

    public void cadastrarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
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

    public void listarCaixas() {
        if (this.caixas.size() == 0) {
            System.out.println("Nenhum caixa cadastrado.");
        } else {
            for (int i = 0; i < this.caixas.size(); i++) {
                Caixa caixa = this.caixas.get(i);
                caixa.mostrarDados();
                System.out.println("------------------------------");
            }
        }
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
}