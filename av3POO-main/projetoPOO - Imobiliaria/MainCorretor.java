import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class MainCorretor {
        private static Map<String, Corretor> corretores = new HashMap<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            boolean running = true;

            while (running) {
                System.out.println("\nMenu:");
                System.out.println("1. Cadastrar Corretor");
                System.out.println("2. Visualizar Corretor");
                System.out.println("3. Alterar Corretor");
                System.out.println("4. Excluir Corretor");
                System.out.println("5. Listar Corretores");
                System.out.println("6. Sair");
                System.out.println("Escolha uma opção: ");

                int op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1:
                        cadastrarCorretor();
                        break;
                    case 2:
                        visualizarCorretor();
                        break;
                    case 3:
                        alterarCorretor();
                        break;
                    case 4:
                        excluirCorretor();
                        break;
                    case 5:
                        listarCorretores();
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }

            scanner.close();
        }

        private static void cadastrarCorretor() {
            System.out.println("CPF do corretor: ");
            String cpf = scanner.nextLine();
            if (corretores.containsKey(cpf)) {
                System.out.println("Corretor já cadastrado.");
                return;
            }

            System.out.println("Nome do corretor: ");
            String nome = scanner.nextLine();
            System.out.println("Endereço do corretor: ");
            String endereco = scanner.nextLine();
            System.out.println("CRECI do corretor: ");
            String creci = scanner.nextLine();
            System.out.println("Comissão do corretor: ");
            double comissao = scanner.nextDouble();
            scanner.nextLine();

            Corretor corretor = new Corretor(nome, cpf, endereco, creci, comissao);
            corretores.put(cpf, corretor);
            System.out.println("Corretor cadastrado com sucesso.");
        }

        private static void visualizarCorretor() {
            System.out.println("CPF do corretor: ");
            String cpf = scanner.nextLine();
            Corretor corretor = corretores.get(cpf);
            if (corretor == null) {
                System.out.println("Corretor nao encontrado.");
            } else {
                System.out.println("CPF: " + cpf + ", Corretor: " + corretor);
            }
        }

        private static void alterarCorretor() {
            System.out.println("CPF do corretor: ");
            String cpf = scanner.nextLine();
            Corretor corretor = corretores.get(cpf);
            if (corretor == null) {
                System.out.println("Corretor nao encontrado.");
                return;
            }

            System.out.println("Novo nome do corretorr: ");
            String novoNome = scanner.nextLine();
            System.out.println("Novo endereço do corretor: ");
            String novoEndereco = scanner.nextLine();
            System.out.println("Novo CRECI do corretor: ");
            String novoCreci = scanner.nextLine();
            System.out.println("Nova comissão do corretor: ");
            double novaComissao = scanner.nextDouble();
            scanner.nextLine();

            corretor.setNome(novoNome);
            corretor.setEndereco(novoEndereco);
            corretor.setCreci(novoCreci);
            corretor.setComissao(novaComissao);
            System.out.println("Corretor atualizado com sucesso.");
        }

        private static void excluirCorretor() {
            System.out.println("CPF do corretor a ser excluído: ");
            String cpf = scanner.nextLine();
            Corretor corretor = corretores.remove(cpf);
            if (corretor == null) {
                System.out.println("Corretor não encontrado.");
            } else {
                System.out.println("Corretor excluído com sucesso.");
            }
        }

        private static void listarCorretores() {
            System.out.println("Corretores da Empresa:");
            for (Map.Entry<String, Corretor> entry : corretores.entrySet()) {
                System.out.println("CPF: " + entry.getKey() + ", Corretor: " + entry.getValue());
            }
        }
}
