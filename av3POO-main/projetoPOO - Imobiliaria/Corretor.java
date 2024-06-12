public class Corretor extends Pessoa implements Funcionario{
    protected String creci;
    protected double comissao;

    public Corretor(String nome, String cpf, String endereco, String creci, double comissao) {
        super(nome, cpf, endereco);
        this.creci = creci;
        this.comissao = comissao;
    }

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        return "Corretor{" +
                "creci='" + creci + '\'' +
                ", comissao=" + comissao +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    @Override
    public void baterPonto() {
        System.out.println("O corretor trabalhou neste dia.");
    }
}