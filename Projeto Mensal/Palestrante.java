// Classe Palestrante que herda de Pessoa
public class Palestrante extends Pessoa {
    String especialidade;

    public Palestrante(String nome, int idade, String especialidade) {
        super(nome, idade, TipoPessoa.PALESTRANTE);
        this.especialidade = especialidade;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Palestrante: " + nome + ", Idade: " + idade + ", Especialidade: " + especialidade);
    }
}
