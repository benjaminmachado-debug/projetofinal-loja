package src;

public abstract class Pagamento {

    private int numeroPagamento;
    private double valor;
    private String status;

    protected Pagamento(int numeroPagamento, double valor) {
        this.numeroPagamento = numeroPagamento;
        this.valor = valor;
        this.status = "PENDENTE";
    }

    public int getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(int numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // cada modalidade tem suas proprias regras de aprovação
    public abstract void processarPagamento();

    public void mostrarPagamento() {
        System.out.println("Número do pagamento: " + this.numeroPagamento);
        System.out.println("Valor: R$" + this.valor);
        System.out.println("Status: " + this.status);
    }
}