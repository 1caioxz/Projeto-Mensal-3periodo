import java.util.*;

// Classe principal para interação com o usuário
public class SistemaEventos {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Pessoa> pessoas = new ArrayList<>(); // Lista para armazenar palestrantes e participantes
    private static List<Evento> eventos = new ArrayList<>(); // Lista para armazenar eventos

    public static void main(String[] args) {
        int opcao;
        do {
            // Exibição do menu de opções
            System.out.println("\n1. Cadastrar Palestrante\n2. Cadastrar Participante\n3. Criar Evento\n4. Listar Pessoas\n5. Listar Eventos\n6. Editar Palestrante\n7. Editar Participante\n8. Editar Evento\n9. Excluir Palestrante\n10. Excluir Participante\n11. Excluir Evento\n12. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após o número

            // Switch-case para escolher a ação
            switch (opcao) {
                case 1 -> cadastrarPalestrante();
                case 2 -> cadastrarParticipante();
                case 3 -> criarEvento();
                case 4 -> listarPessoas();
                case 5 -> listarEventos();
                case 6 -> editarPalestrante();
                case 7 -> editarParticipante();
                case 8 -> editarEvento();
                case 9 -> excluirPalestrante();
                case 10 -> excluirParticipante();
                case 11 -> excluirEvento();
                case 12 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 12);
    }

    // Métodos de edição (não implementados no código fornecido)
    private static void editarPalestrante() { /* código de edição do palestrante */ }
    private static void editarParticipante() { /* código de edição do participante */ }
    private static void editarEvento() { /* código de edição do evento */ }

    // Método para cadastrar um palestrante
    private static void cadastrarPalestrante() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        pessoas.add(new Palestrante(nome, idade, especialidade));
    }

    // Método para cadastrar um participante
    private static void cadastrarParticipante() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        pessoas.add(new Participante(nome, idade, email));
    }

    // Método para criar um evento
    private static void criarEvento() {
        System.out.print("Título do evento: ");
        String titulo = scanner.nextLine();
        System.out.print("Data do evento: ");
        String data = scanner.nextLine();
        
        System.out.println("Escolha um palestrante:");
        List<Palestrante> palestrantes = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Palestrante) {
                palestrantes.add((Palestrante) p);
            }
        }
        
        if (palestrantes.isEmpty()) {
            System.out.println("Nenhum palestrante cadastrado!");
            return;
        }

        // Listando palestrantes disponíveis
        for (int i = 0; i < palestrantes.size(); i++) {
            System.out.println(i + ". " + palestrantes.get(i).getNome());
        }
        
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 0 || escolha >= palestrantes.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        eventos.add(new Evento(titulo, data, palestrantes.get(escolha)));
    }

    // Método para listar todas as pessoas cadastradas
    private static void listarPessoas() {
        for (Pessoa p : pessoas) {
            p.exibirInfo();
        }
    }

    // Método para listar todos os eventos cadastrados
    private static void listarEventos() {
        for (Evento e : eventos) {
            e.exibirInfo();
        }
    }

    // Método para excluir um palestrante
    private static void excluirPalestrante() {
        List<Palestrante> palestrantes = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Palestrante palestrante) {
                palestrantes.add(palestrante);
            }
        }

        if (palestrantes.isEmpty()) {
            System.out.println("Nenhum palestrante para excluir.");
            return;
        }

        System.out.println("Escolha o palestrante que deseja excluir:");
        for (int i = 0; i < palestrantes.size(); i++) {
            System.out.println(i + ". " + palestrantes.get(i).getNome());
        }

        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 0 || escolha >= palestrantes.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        pessoas.remove(palestrantes.get(escolha));
        System.out.println("Palestrante excluído com sucesso!");
    }

    // Método para excluir um participante
    private static void excluirParticipante() {
        List<Participante> participantes = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Participante participante) {
                participantes.add(participante);
            }
        }

        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante para excluir.");
            return;
        }

        System.out.println("Escolha o participante que deseja excluir:");
        for (int i = 0; i < participantes.size(); i++) {
            System.out.println(i + ". " + participantes.get(i).getNome());
        }

        int escolha = scanner.nextInt();
        scanner.nextLine(); 

        if (escolha < 0 || escolha >= participantes.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        pessoas.remove(participantes.get(escolha));
        System.out.println("Participante excluído com sucesso!");
    }

    // Método para excluir um evento
    private static void excluirEvento() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento para excluir.");
            return;
        }

        System.out.println("Escolha o evento que deseja excluir:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println(i + ". " + eventos.get(i).titulo);
        }

        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 0 || escolha >= eventos.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        eventos.remove(escolha);
        System.out.println("Evento excluído com sucesso!");
    }
}
