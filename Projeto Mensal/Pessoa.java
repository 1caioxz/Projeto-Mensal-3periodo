// Classe abstrata para representar uma pessoa
public abstract class Pessoa implements Acoes {
    protected String nome;
    protected int idade;
    protected TipoPessoa tipo;

    public Pessoa(String nome, int idade, TipoPessoa tipo) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
}
