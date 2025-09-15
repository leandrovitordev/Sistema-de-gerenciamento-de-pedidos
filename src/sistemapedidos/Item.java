package sistemapedidos;

// Item.java
public class Item {
    private String nome;
    private double preco;

    // Construtor da classe
    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Métodos para acessar os atributos (getters)
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}