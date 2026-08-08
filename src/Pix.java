package src;

public class Pix extends Pagamento {

    private String chavePix;

    public Pix(int numeroPagamento, double valor, String chavePix) {
        super(numeroPagamento, valor);
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento() {
        if (this.getValor() > 0 && this.chavePix != null && !this.chavePix.equals("")) {
            this.setStatus("APROVADO");
            System.out.println("Pagamento via Pix aprovado com sucesso!");
        } else {
            this.setStatus("RECUSADO");
            System.out.println("Pagamento via Pix recusado. Verifique o valor e a chave Pix informada.");
        }
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Chave Pix: " + this.chavePix);
    }
}