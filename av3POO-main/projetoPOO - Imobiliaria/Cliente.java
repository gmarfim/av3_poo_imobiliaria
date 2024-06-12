import java.util.List;

public interface Cliente {

    void adicionarImovel(Imovel imovel);

    public List<Imovel> listarImoveis();

    void transacao();
}
