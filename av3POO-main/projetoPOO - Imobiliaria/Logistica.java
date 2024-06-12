public class Logistica extends Administracao{
    protected String areaDeLogistica;

    @Override
    public String toString() {
        return "Logistica{" +
                "areaDeLogistica='" + areaDeLogistica + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public String getAreaDeLogistica() {
        return areaDeLogistica;
    }

    public void setAreaDeLogistica(String areaDeLogistica) {
        this.areaDeLogistica = areaDeLogistica;
    }
}
