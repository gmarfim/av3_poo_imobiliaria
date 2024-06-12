import java.util.ArrayList;
import java.util.List;


public class Prospecto extends Pessoa implements Cliente{
    protected List<Imovel> imoveis;

    public Prospecto(String nome, String cpf, String endereco) {
        super(nome, cpf, endereco);
        this.imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    @Override
    public List<Imovel> listarImoveis() {
        return null;
    }

    @Override
    public void transacao(){
        System.out.println("Este cliente quer vender!");
    }

    @Override
    public String toString() {
        return "Prospecto{" +
                "interesses=" + imoveis +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
