package src;

public class CartaoDebito extends Cartao {

    private double saldoDisponivel;
    private String senhaCartao;

    public CartaoDebito(int numeroPagamento, double valor, String numeroCartao, String nomeTitular, String bandeira, String cvv, double saldoDisponivel, String senhaCartao) {
        super(numeroPagamento, valor, numeroCartao, nomeTitular, bandeira, cvv);
        this.saldoDisponivel = saldoDisponivel;
        this.senhaCartao = senhaCartao;
    }

    public double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public String getSenhaCartao() {
        return senhaCartao;
    }

    public void setSenhaCartao(String senhaCartao) {
        this.senhaCartao = senhaCartao;
    }

    @Override
    public void processarPagamento() {
        if (this.getValor() <= 0) {
            this.setStatus("RECUSADO");
            System.out.println("Pagamento recusado. O valor deve ser maior que zero.");
        } else if (!this.dadosCartaoValidos()) {
            this.setStatus("RECUSADO");
            System.out.println("Pagamento recusado. Os dados do cartão estão incompletos.");
        } else if (this.saldoDisponivel < this.getValor()) {
            this.setStatus("RECUSADO");
            System.out.println("Pagamento recusado. Saldo insuficiente no cartão de débito.");
        } else {
            this.saldoDisponivel = this.saldoDisponivel - this.getValor();
            this.setStatus("APROVADO");
            System.out.println("Pagamento com cartão de débito aprovado com sucesso!");
        }
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Saldo restante: R$" + this.saldoDisponivel);
    }
}
 