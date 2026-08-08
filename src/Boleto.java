package src;

public class Boleto extends Pagamento {

    private String codigoBarras;

    public Boleto(int numeroPagamento, double valor, String codigoBarras) {
        super(numeroPagamento, valor);
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processarPagamento() {
        if (this.getValor() > 0 && this.codigoBarras != null && !this.codigoBarras.equals("")) {
            this.setStatus("APROVADO");
            System.out.println("Pagamento via Boleto aprovado com sucesso!");
        } else {
            this.setStatus("RECUSADO");
            System.out.println("Pagamento via Boleto recusado. Verifique o valor e o código de barras informado.");
        }
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Código de barras: " + this.codigoBarras);
    }
}