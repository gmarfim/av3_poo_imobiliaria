public class Apartamento extends Imovel{
    protected int numeroAndar;
    protected double taxaCondominio;
    protected boolean elevador;
    protected boolean areaLazer;

    public Apartamento(String endereco, double valor, int area, int numeroQuartos, int numeroAndar, double taxaCondominio, boolean elevador, boolean areaLazer) {
        super(endereco, valor, area, numeroQuartos);
        this.numeroAndar = numeroAndar;
        this.taxaCondominio = taxaCondominio;
        this.elevador = elevador;
        this.areaLazer = areaLazer;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    public void setNumeroAndar(int numeroAndar) {
        this.numeroAndar = numeroAndar;
    }

    public double getTaxaCondominio() {
        return taxaCondominio;
    }

    public void setTaxaCondominio(double taxaCondominio) {
        this.taxaCondominio = taxaCondominio;
    }

    public boolean isElevador() {
        return elevador;
    }

    public void setElevador(boolean elevador) {
        this.elevador = elevador;
    }

    public boolean isAreaLazer() {
        return areaLazer;
    }

    public void setAreaLazer(boolean areaLazer) {
        this.areaLazer = areaLazer;
    }

    @Override
    public String mostrarComissao(){
        if(valor<=250.000) {
            return "Baixo Padrao -> até R$ 250.000 || 5%";
        }else if(valor>250.000 && valor<=750.000){
            return "Medio Padrao -> de R$ 250.000 ate 750.000 || 4.5%";
        }else{
            return "Luxo -> mais de 750.000 || 4%";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Apartamento {" +
                "numeroAndar =" + numeroAndar +
                ", taxaCondominio =" + taxaCondominio +
                ", elevador =" + elevador +
                ", areaLazer =" + areaLazer +
                '}';
    }
}
