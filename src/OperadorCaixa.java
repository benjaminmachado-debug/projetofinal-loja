package src;

public class OperadorCaixa extends Funcionario {

    private int numeroCaixa;
    private String statusCaixa;

    public OperadorCaixa(int id, String nome, String cpf, double salario, String cargo, int numeroCaixa) {
        super(id, nome, cpf, salario, cargo);
        this.numeroCaixa = numeroCaixa;
        this.statusCaixa = "FECHADO";
    }

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public String getStatusCaixa() {
        return statusCaixa;
    }

    public void setStatusCaixa(String statusCaixa) {
        this.statusCaixa = statusCaixa;
    }

    public void abrirCaixa() {
        this.statusCaixa = "ABERTO";
        System.out.println("Caixa " + this.numeroCaixa + " aberto com sucesso!");
    }

    public void fecharCaixa() {
        this.statusCaixa = "FECHADO";
        System.out.println("Caixa " + this.numeroCaixa + " fechado com sucesso!");
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Número do caixa: " + this.numeroCaixa);
        System.out.println("Status do caixa: " + this.statusCaixa);
    }
}