package src;

public class Caixa {

    private int numeroCaixa;
    private Funcionario operadorResponsavel;
    private String status;

    public Caixa(int numeroCaixa, Funcionario operadorResponsavel) {
        this.numeroCaixa = numeroCaixa;
            this.operadorResponsavel = operadorResponsavel;
        this.status = "FECHADO";
    }

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public Funcionario getOperadorResponsavel() {
        return operadorResponsavel;
    }

    public void setOperadorResponsavel(Funcionario operadorResponsavel) {
        this.operadorResponsavel = operadorResponsavel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void abrirCaixa() {
        this.status = "ABERTO";
        System.out.println("Caixa " + this.numeroCaixa + " aberto com sucesso!");
    }

    public void fecharCaixa() {
        this.status = "FECHADO";
        System.out.println("Caixa " + this.numeroCaixa + " fechado com sucesso!");
    }

    public void mostrarDados() {
        System.out.println("Número do caixa: " + this.numeroCaixa);
            System.out.println("Operador responsável: " + this.operadorResponsavel.getNome());
        System.out.println("Status: " + this.status);
    }
}