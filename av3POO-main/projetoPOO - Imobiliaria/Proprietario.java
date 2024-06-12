import java.util.ArrayList;
import java.util.List;

public class Proprietario extends Pessoa implements Cliente {

    protected List<Imovel> imoveis;

    public Proprietario(String nome, String cpf, String endereco) {
        super(nome, cpf, endereco);
        this.imoveis = new ArrayList<>();
    }

    @Override
    public List<Imovel> listarImoveis() {
        return imoveis;
    }


    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }
    @Override
    public void transacao(){
        System.out.println("Este cliente quer vender!");
    }

    @Override
    public String toString() {
        return "Proprietario{" +
                "imoveis=" + imoveis +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}