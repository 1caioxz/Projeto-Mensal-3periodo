// Classe Participante que herda de Pessoa
public class Participante extends Pessoa {
    String email;

    public Participante(String nome, int idade, String email) {
        super(nome, idade, TipoPessoa.PARTICIPANTE);
        this.email = email;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Participante: " + nome + ", Idade: " + idade + ", Email: " + email);
    }
}