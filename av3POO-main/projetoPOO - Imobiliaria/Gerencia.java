public class Gerencia extends Administracao{
    protected String areaDeGerencia;

    @Override
    public String toString() {
        return "Gerencia{" +
                "areaDeGerencia='" + areaDeGerencia + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public String getAreaDeGerencia() {
        return areaDeGerencia;
    }

    public void setAreaDeGerencia(String areaDeGerencia) {
        this.areaDeGerencia = areaDeGerencia;
    }
}
