import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Cliente> clientes = new ArrayList<>();
    private static Corretor corretor;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro do Corretor de Imóveis:");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.println("Creci: ");
        String creci = scanner.nextLine();
        corretor = new Corretor(nome, cpf, endereco, creci, 0);

        boolean running = true;

        while (running) {
            try{
            System.out.println("\nMenu:");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Ler Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("5. Adicionar Imóvel ao Cliente");
            System.out.println("6. Listar Clientes");
            System.out.println("7. Listar Imóveis do Cliente");
            System.out.println("8. Sair");
            System.out.println("Escolha uma opção: ");
            int op;
                try {
                    op = scanner.nextInt();
                    scanner.nextLine();

                    if (op < 1 || op > 8) {
                        throw new DelimitarNumeroException("Número fora do intervalo permitido. Por favor, insira um número de 1 a 8.");
                    }
                } catch (InputMismatchException e) {
                    throw new DelimitarNumeroException("Entrada inválida. Por favor, insira um número de 1 a 8.");
                }


            switch (op) {
                case 1:
                    registrarCliente(scanner);
                    break;
                case 2:
                    lerCliente(scanner);
                    break;
                case 3:
                    editarCliente(scanner);
                    break;
                case 4:
                    excluirCliente(scanner);
                    break;
                case 5:
                    adicionarImovel(scanner);
                    break;
                case 6:
                    listarClientes();
                    break;
                case 7:
                    listarImoveisDoCliente(scanner);
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            } catch (InputMismatchException | DelimitarNumeroException e) {
                System.out.println("Entrada inválida. Por favor, insira um número de 1 a 8.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void registrarCliente(Scanner scanner) {
        System.out.println("Tipo de Cliente:");
        System.out.println("1. Proprietário");
        System.out.println("2. Prospecto");
        System.out.println("Escolha uma opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente;
        if (tipo == 1) {
            cliente = new Proprietario(nome, cpf, endereco);
        }else if(tipo == 2){
            cliente = new Prospecto(nome, cpf, endereco);
        }else{
            System.out.println("Erro, escolha se o cliente é Prospecto ou Proprietário!");
            return;
        }

        clientes.add(cliente);
        System.out.println("Cliente registrado com sucesso.");
    }

    private static void lerCliente(Scanner scanner) {
        try {
            System.out.println("CPF do cliente: ");
            String cpf = scanner.nextLine();
            Cliente cliente = encontrarClientePorCpf(cpf);

            if (cliente == null) {
                throw new ClienteNaoEncontradoException("Cliente não encontrado para o CPF: " + cpf);
            } else {
                System.out.println(cliente);
            }
        } catch (ClienteNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void editarCliente(Scanner scanner) {
        try {
            System.out.println("CPF do cliente: ");
            String cpf = scanner.nextLine();
            Cliente cliente = encontrarClientePorCpf(cpf);

            if (cliente == null) {
                throw new ClienteNaoEncontradoException("Cliente não encontrado para o CPF: " + cpf);
            }

            System.out.println("Novo Nome: ");
            String novoNome = scanner.nextLine();
            System.out.println("Novo Endereço: ");
            String novoEndereco = scanner.nextLine();

            ((Pessoa) cliente).setNome(novoNome);
            ((Pessoa) cliente).setEndereco(novoEndereco);
            System.out.println("Cliente atualizado com sucesso.");
        } catch (ClienteNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void excluirCliente(Scanner scanner) {
        try {
            System.out.println("CPF do cliente: ");
            String cpf = scanner.nextLine();
            Cliente cliente = encontrarClientePorCpf(cpf);

            if (cliente == null) {
                throw new ClienteNaoEncontradoException("Cliente não encontrado para o CPF: " + cpf);
            }

            clientes.remove(cliente);
            System.out.println("Cliente excluído com sucesso.");
        } catch (ClienteNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void adicionarImovel(Scanner scanner) {
        try {
            System.out.println("CPF do cliente: ");
            String cpf = scanner.nextLine();
            Cliente cliente = encontrarClientePorCpf(cpf);

            if (cliente == null) {
                throw new ClienteNaoEncontradoException("Cliente não encontrado para o CPF: " + cpf);
            }

            System.out.println("Tipo de Imóvel:");
            System.out.println("1. Casa");
            System.out.println("2. Apartamento");

            int tipoImovel = scanner.nextInt();
            scanner.nextLine();

            Imovel imovel = null;
            if (tipoImovel == 1) {
                System.out.println("Endereço do imóvel: ");
                String endereco = scanner.nextLine();
                System.out.println("Valor do imóvel: ");
                double valor = scanner.nextDouble();
                System.out.println("Area: ");
                int area = scanner.nextInt();
                System.out.println("Numero de Quartos: ");
                int numeroQuartos = scanner.nextInt();
                System.out.println("Area do lote: ");
                double lote = scanner.nextDouble();
                System.out.println("Tem piscina? (true or false)");
                boolean piscina = scanner.nextBoolean();
                System.out.println("Quantos andares? ");
                int andares = scanner.nextInt();
                scanner.nextLine();
                imovel = new Casa(endereco, valor, area, numeroQuartos, lote, piscina, andares);
            } else if (tipoImovel == 2) {
                System.out.println("Endereço do imóvel: ");
                String endereco = scanner.nextLine();
                System.out.println("Valor do imóvel: ");
                double valor = scanner.nextDouble();
                System.out.println("Area: ");
                int area = scanner.nextInt();
                System.out.println("Numero de Quartos: ");
                int numeroQuartos = scanner.nextInt();
                System.out.println("Numero de andares: ");
                int numeroAndar = scanner.nextInt();
                System.out.println("Taxa de Condominio: ");
                double taxaCondominio = scanner.nextDouble();
                System.out.println("Tem elevador? (true or false)");
                boolean elevador = scanner.nextBoolean();
                System.out.println("Tem area de lazer? (true or false)");
                boolean areaLazer = scanner.nextBoolean();
                scanner.nextLine();
                imovel = new Apartamento(endereco, valor, area, numeroQuartos, numeroAndar, taxaCondominio, elevador, areaLazer);
            }

            cliente.adicionarImovel(imovel);
            System.out.println("Imóvel adicionado com sucesso.");
        } catch (ClienteNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }



    private static void listarImoveisDoCliente(Scanner scanner) {
        try {
            System.out.println("CPF do cliente: ");
            String cpf = scanner.nextLine();
            Cliente cliente = encontrarClientePorCpf(cpf);

            if (cliente == null) {
                throw new ClienteNaoEncontradoException("Cliente não encontrado para o CPF: " + cpf);
            }

            List<Imovel> imoveis = cliente.listarImoveis();
            if (imoveis.isEmpty()) {
                System.out.println("O cliente não possui imóveis cadastrados.");
            } else {
                System.out.println("Imóveis do cliente:");
                for (Imovel imovel : imoveis) {
                    System.out.println(imovel);
                }
            }
        } catch (ClienteNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Cliente encontrarClientePorCpf(String cpf) throws ClienteNaoEncontradoException {
        for (Cliente cliente : clientes) {
            if (((Pessoa) cliente).getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new ClienteNaoEncontradoException("CPF não encontrado: " + cpf);

    }


    private static void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}