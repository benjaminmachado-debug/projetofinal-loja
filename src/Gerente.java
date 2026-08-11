package src;

public class Gerente extends Funcionario {

    private String setor;
    private double bonus;

    public Gerente(int id, String nome, String cpf, double salario, String cargo, String senha, String setor, double bonus) {
        super(id, nome, cpf, salario, cargo, senha);
        this.setor = setor;
        this.bonus = bonus;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Setor: " + this.setor);
        System.out.println("Bônus: R$" + this.bonus);
    }
}