package src;

public abstract class Cartao extends Pagamento {

    private String numeroCartao;
    private String nomeTitular;
    private String bandeira;
    private String cvv;

    protected Cartao(int numeroPagamento, double valor, String numeroCartao, String nomeTitular, String bandeira, String cvv) {
        super(numeroPagamento, valor);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.bandeira = bandeira;
        this.cvv = cvv;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    // verifica se os dados basicos do cartao foram todos informados
    protected boolean dadosCartaoValidos() {
        boolean numeroValido = this.numeroCartao != null && !this.numeroCartao.equals("");
        boolean titularValido = this.nomeTitular != null && !this.nomeTitular.equals("");
        boolean bandeiraValida = this.bandeira != null && !this.bandeira.equals("");
        boolean cvvValido = this.cvv != null && !this.cvv.equals("");

        return numeroValido && titularValido && bandeiraValida && cvvValido;
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Número do cartão: " + this.numeroCartao);
        System.out.println("Titular: " + this.nomeTitular);
        System.out.println("Bandeira: " + this.bandeira);
    }
}