public abstract class Imovel implements Imobiliaria{
    protected String endereco;
    protected double valor;
    protected int area;
    protected int numeroQuartos;


    public Imovel(String endereco, double valor, int area, int numeroQuartos) {
        this.endereco = endereco;
        this.valor = valor;
        this.area = area;
        this.numeroQuartos = numeroQuartos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public String mostrarComissao(){
        System.out.println("A comissao para o imovel é de: ");
        return "A comissao para o imovel é de: ";
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "endereco='" + endereco + '\'' +
                ", valor=" + valor +
                ", area=" + area +
                ", numeroQuartos=" + numeroQuartos +
                '}';
    }
}
