import java.util.*;

// Classe principal para interação com o usuário
public class SistemaEventos {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Pessoa> pessoas = new ArrayList<>();
    private static List<Evento> eventos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n1. Cadastrar Palestrante\n2. Cadastrar Participante\n3. Criar Evento\n4. Listar Pessoas\n5. Listar Eventos\n6. Editar Palestrante\n7. Editar Participante\n8. Editar Evento\n" + //
                                "9. Excluir Palestrante\n10. Excluir Participante\n11. Excluir Evento\n 12. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

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
    
    
    private static void editarPalestrante() {
    // Editar os palestrantes
    List<Palestrante> palestrantes = new ArrayList<>();
    for (Pessoa p : pessoas) {
        if (p instanceof Palestrante palestrante) {
            palestrantes.add(palestrante);
        }
    }

    if (palestrantes.isEmpty()) {
        System.out.println("Nenhum palestrante cadastrado para editar.");
        return;
    }

    // Edita palestrantes cadastrados
    System.out.println("Escolha o palestrante que deseja editar:");
    for (int i = 0; i < palestrantes.size(); i++) {
        System.out.println(i + ". " + palestrantes.get(i).getNome());
    }

    // Obter a escolha do usuário
    int escolha = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha após o número

    if (escolha < 0 || escolha >= palestrantes.size()) {
        System.out.println("Opcao invalida!");
        return;
    }

    // Obter o palestrante escolhido
    Palestrante palestranteEscolhido = palestrantes.get(escolha);

    // Editar nome
    System.out.print("Novo nome (atual: " + palestranteEscolhido.getNome() + "): ");
    String novoNome = scanner.nextLine();
    if (!novoNome.isEmpty()) {
        palestranteEscolhido.nome = novoNome;
    }

    // Editar idade
    System.out.print("Nova idade (atual: " + palestranteEscolhido.getIdade() + "): ");
    int novaIdade = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha após o número
    if (novaIdade > 0) {
        palestranteEscolhido.idade = novaIdade;
    }

    // Editar especialidade
    System.out.print("Nova especialidade (atual: " + palestranteEscolhido.especialidade + "): ");
    String novaEspecialidade = scanner.nextLine();
    if (!novaEspecialidade.isEmpty()) {
        palestranteEscolhido.especialidade = novaEspecialidade;
    }

    System.out.println("Palestrante editado com sucesso!");
}
    
    private static void editarParticipante() {
    // Listar todos os participantes
    List<Participante> participantes = new ArrayList<>();
    for (Pessoa p : pessoas) {
        if (p instanceof Participante participante) {
            participantes.add(participante);
        }
    }

    if (participantes.isEmpty()) {
        System.out.println("Nenhum participante cadastrado para editar.");
        return;
    }

    // Exibe palestrantes cadastrados
    System.out.println("Escolha o palestrante que deseja editar:");
    for (int i = 0; i < participantes.size(); i++) {
        System.out.println(i + ". " + participantes.get(i).getNome());
    }

    // Obter a escolha do usuário
    int escolha = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha após o número

    if (escolha < 0 || escolha >= participantes.size()) {
        System.out.println("Opcao invalida!");
        return;
    }

    // Obter o palestrante escolhido
    Participante participanteEscolhido = participantes.get(escolha);

    // Editar nome
    System.out.print("Novo nome (atual: " + participanteEscolhido.getNome() + "): ");
    String novoNome = scanner.nextLine();
    if (!novoNome.isEmpty()) {
        participanteEscolhido.nome = novoNome;
    }

    // Editar idade
    System.out.print("Nova idade (atual: " + participanteEscolhido.getIdade() + "): ");
    int novaIdade = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha após o número
    if (novaIdade > 0) {
        participanteEscolhido.idade = novaIdade;
    }

    // Editar especialidade
    System.out.print("Novo e-mail (atual: " + participanteEscolhido.email + "): ");
    String novoEmail = scanner.nextLine();
    if (!novoEmail.isEmpty()) {
        participanteEscolhido.email = novoEmail;
    }

    System.out.println("Palestrante editado com sucesso!");
}

    private static void editarEvento() {
    // Listar todos os eventos
    if (eventos.isEmpty()) {
        System.out.println("Nenhum evento criado para editar.");
        return;
    }

    // Exibir todos os eventos cadastrados
    System.out.println("Escolha o evento que deseja editar:");
    for (int i = 0; i < eventos.size(); i++) {
        System.out.println(i + ". " + eventos.get(i).titulo);
    }

    // Obter a escolha do usuário
    int escolha = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha após o número

    if (escolha < 0 || escolha >= eventos.size()) {
        System.out.println("Opcao invalida!");
        return;
    }

    // Obter o evento escolhido
    Evento eventoEscolhido = eventos.get(escolha);

    // Editar título
    System.out.print("Novo titulo (atual: " + eventoEscolhido.titulo + "): ");
    String novoTitulo = scanner.nextLine();
    if (!novoTitulo.isEmpty()) {
        eventoEscolhido.titulo = novoTitulo;
    }

    // Editar data
    System.out.print("Nova data (atual: " + eventoEscolhido.data + "): ");
    String novaData = scanner.nextLine();
    if (!novaData.isEmpty()) {
        eventoEscolhido.data = novaData;
    }

    // Editar palestrante
    System.out.println("Escolha um novo palestrante para o evento (caso deseje manter, pressione Enter):");
    List<Palestrante> palestrantes = new ArrayList<>();
    for (Pessoa p : pessoas) {
        if (p instanceof Palestrante palestrante) {
            palestrantes.add(palestrante);
        }
    }

    if (palestrantes.isEmpty()) {
        System.out.println("Nenhum palestrante cadastrado!");
        return;
    }

    for (int i = 0; i < palestrantes.size(); i++) {
        System.out.println(i + ". " + palestrantes.get(i).getNome());
    }

    System.out.print("Escolha um palestrante (ou pressione Enter para manter o atual): ");
    String escolhaPalestrante = scanner.nextLine();

    if (!escolhaPalestrante.isEmpty()) {
        int palestranteEscolhidoIndex = Integer.parseInt(escolhaPalestrante);
        if (palestranteEscolhidoIndex >= 0 && palestranteEscolhidoIndex < palestrantes.size()) {
            eventoEscolhido.palestrante = palestrantes.get(palestranteEscolhidoIndex);
        } else {
            System.out.println("Palestrante inválido!");
        }
    }

    System.out.println("Evento editado com sucesso!");
}

    
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

    private static void listarPessoas() {
        for (Pessoa p : pessoas) {
            p.exibirInfo();
        }
    }

    private static void listarEventos() {
        for (Evento e : eventos) {
            e.exibirInfo();
        }
    }
    //Excluir palestrante
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

    // Excluir participante
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

    // Excluir evento
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
