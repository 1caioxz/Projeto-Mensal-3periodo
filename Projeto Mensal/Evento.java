// Classe Evento para gerenciar a agenda
public class Evento {
    String titulo;
    String data;
    Palestrante palestrante;

    public Evento(String titulo, String data, Palestrante palestrante) {
        this.titulo = titulo;
        this.data = data;
        this.palestrante = palestrante;
    }

    public void exibirInfo() {
        System.out.println("Evento: " + titulo + ", Data: " + data);
        palestrante.exibirInfo();
    }
}