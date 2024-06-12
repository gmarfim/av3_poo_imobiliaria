public class Casa extends Imovel{
    protected double lote;
    protected boolean piscina;
    protected int andares;

    public Casa(String endereco, double valor, int area, int numeroQuartos, double lote, boolean piscina, int andares) {
        super(endereco, valor, area, numeroQuartos);
        this.lote = lote;
        this.piscina = piscina;
        this.andares = andares;
    }

    public double getLote() {
        return lote;
    }

    public void setLote(double lote) {
        this.lote = lote;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public int getAndares() {
        return andares;
    }

    public void setAndares(int andares) {
        this.andares = andares;
    }

    @Override
    public String mostrarComissao(){
        if(valor<=250000) {
            return "Baixo Padrao -> até R$ 250.000 || 5%";
        }else if(valor>250000 && valor<=750000){
            return "Medio Padrao -> de R$ 250.000 ate 750.000 || 4.5%";
        }else if(valor>250000 && valor<=1500000){
            return "Luxo -> de R$ 750.000 ate 1.500.000 || 4%";
        }else{
            return "Alto Luxo -> mais de 1.500.000 || 3.8%";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Casa {" +
                "lote =" + lote +
                ", piscina =" + piscina +
                ", andares =" + andares +
                '}';
    }
}
