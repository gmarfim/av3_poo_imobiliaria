public abstract class Administracao extends Pessoa implements Funcionario{
    protected String cargo;
    protected double salario;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void baterPonto(){
        System.out.println("O funcionário administrativo trabalhou neste dia.");
    }

    @Override
    public String toString() {
        return "Administracao{" +
                "cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
