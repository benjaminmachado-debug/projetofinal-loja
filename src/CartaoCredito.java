package src;
public class CartaoCredito extends Cartao {

    private double limiteDisponivel;
    private int quantidadeParcelas;

    // construtor para pagamento a vista
    public CartaoCredito(int numeroPagamento, double valor, String numeroCartao, String nomeTitular, String bandeira, String cvv, double limiteDisponivel) {
        super(numeroPagamento, valor, numeroCartao, nomeTitular, bandeira, cvv);
        this.limiteDisponivel = limiteDisponivel;
        this.quantidadeParcelas = 1;
    }

    // construtor para pagamento parcelado
    public CartaoCredito(int numeroPagamento, double valor, String numeroCartao, String nomeTitular, String bandeira, String cvv, double limiteDisponivel, int quantidadeParcelas) {
        super(numeroPagamento, valor, numeroCartao, nomeTitular, bandeira, cvv);
        this.limiteDisponivel = limiteDisponivel;
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    @Override
    public void processarPagamento() {
        if (this.getValor() <= 0) {
            this.setStatus("RECUSADO");
            System.out.println("Pagamento recusado. O valor deve ser maior que zero.");
        } else if (!this.dadosCartaoValidos()) {
            this.setStatus("RECUSADO");
            System.out.println("Pagamento recusado. Os dados do cartão estão incompletos.");
        } else if (this.limiteDisponivel < this.getValor()) {
            this.setStatus("RECUSADO");
            System.out.println("Pagamento recusado. Limite disponível insuficiente.");
        } else {
            this.limiteDisponivel = this.limiteDisponivel - this.getValor();
            this.setStatus("APROVADO");
            System.out.println("Pagamento com cartão de crédito aprovado com sucesso!");

            if (this.quantidadeParcelas > 1) {
                double valorParcela = this.getValor() / this.quantidadeParcelas;
                System.out.println("Pagamento parcelado em " + this.quantidadeParcelas + "x de R$" + valorParcela);
            } else {
                System.out.println("Pagamento realizado à vista.");
            }
        }
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Limite restante: R$" + this.limiteDisponivel);

        if (this.quantidadeParcelas > 1) {
            double valorParcela = this.getValor() / this.quantidadeParcelas;
            System.out.println("Quantidade de parcelas: " + this.quantidadeParcelas);
            System.out.println("Valor de cada parcela: R$" + valorParcela);
        } else {
            System.out.println("Forma de pagamento: à vista");
        }
    }
}