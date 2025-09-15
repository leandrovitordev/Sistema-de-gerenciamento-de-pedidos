package sistemapedidos;

// Pedido.java
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private String nomeCliente;
    private List<Item> itens;

    // Construtor da classe
    public Pedido(int numero, String nomeCliente) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>(); // Inicia a lista de itens
    }

    // Método para adicionar um item ao pedido
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    // Método para calcular o valor total do pedido [cite: 40]
    public double getValorTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    // Métodos para acessar os atributos (getters)
    public int getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public List<Item> getItens() {
        return itens;
    }
}