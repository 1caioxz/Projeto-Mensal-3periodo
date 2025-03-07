import java.util.*;

// Enum para representar tipos de usuários
enum TipoUsuario {
    ADMIN, CLIENTE, FUNCIONARIO
}

// Interface para definir ações comuns
interface Acoes {
    void exibirInfo();
}

// Classe abstrata que define um usuário genérico
abstract class Usuario implements Acoes {
    protected String nome;
    protected int idade;
    protected TipoUsuario tipo;

    public Usuario() {}

    public Usuario(String nome, int idade, TipoUsuario tipo) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    public Usuario(Usuario outro) {
        //diferencia os atributos do objeto dos parâmetros
        this.nome = outro.nome;
        this.idade = outro.idade;
        this.tipo = outro.tipo;
    }

    public abstract void exibirInfo();

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
}

// Subclasse Cliente herdando de Usuario
class Cliente extends Usuario {
    private String cpf;

    public Cliente(String nome, int idade, String cpf) {
        super(nome, idade, TipoUsuario.CLIENTE);
        this.cpf = cpf;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Cliente: " + nome + ", Idade: " + idade + ", CPF: " + cpf);
    }
}

// Subclasse Funcionario herdando de Usuario
class Funcionario extends Usuario {
    private double salario;

    public Funcionario(String nome, int idade, double salario) {
        super(nome, idade, TipoUsuario.FUNCIONARIO);
        this.salario = salario;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Funcionário: " + nome + ", Idade: " + idade + ", Salário: " + salario);
    }
}

// Classe Empresa demonstrando Composição
class Empresa {
    private String nome;
    private List<Funcionario> funcionarios;

    public Empresa(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void listarFuncionarios() {
        for (Funcionario f : funcionarios) {
            f.exibirInfo();
        }
    }
}

// Classe principal com interação via console
public class trabalho{
    private static Scanner scanner = new Scanner(System.in);
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("1. Cadastrar Cliente\n2. Cadastrar Funcionario\n3. Listar Usuarios\n4. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarFuncionario();
                case 3 -> listarUsuarios();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        usuarios.add(new Cliente(nome, idade, cpf));
    }

    private static void cadastrarFuncionario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        usuarios.add(new Funcionario(nome, idade, salario));
    }

    private static void listarUsuarios() {
        for (Usuario u : usuarios) {
            u.exibirInfo();
        }
    }
}
