package src;

public class Pagamento {

    private int numeroPagamento;
    private double valor;
    private String modalidade;
    private String status;

    public Pagamento(int numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
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

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void realizarPagamento(double valor, String modalidade) {
        if (valor > 0 && modalidade != null && !modalidade.equals("")) {
            this.valor = valor;
            this.modalidade = modalidade;
            this.status = "APROVADO";
            System.out.println("Pagamento realizado com sucesso!");
        } else {
            this.status = "RECUSADO";
            System.out.println("Não foi possível realizar o pagamento. Verifique o valor e a modalidade informados.");
        }
    }

    public void mostrarPagamento() {
        System.out.println("Número do pagamento: " + this.numeroPagamento);
        System.out.println("Valor: R$" + this.valor);
        System.out.println("Modalidade: " + this.modalidade);
        System.out.println("Status: " + this.status);
    }
}