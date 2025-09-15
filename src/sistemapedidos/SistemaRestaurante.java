package sistemapedidos;

// SistemaRestaurante.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaRestaurante {

    private static List<Pedido> listaDePedidos = new ArrayList<>(); // Estrutura de dados principal 
    private static int proximoNumeroPedido = 1; // Para gerar números sequenciais 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = -1;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner
            } catch (InputMismatchException e) {
                System.out.println("\nOpção inválida! Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer em caso de erro
                continue; // Volta para o início do loop
            }


            switch (opcao) {
                case 1:
                    registrarPedido(scanner);
                    break;
                case 2:
                    removerPedido(scanner);
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    executando = false; // Encerra o programa 
                    System.out.println("\nEncerrando o sistema. Obrigado!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Sistema de Gerenciamento de Pedidos ---");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void registrarPedido(Scanner scanner) { 
        System.out.print("\nDigite o nome do cliente: ");
        String nomeCliente = scanner.nextLine(); // Solicita nome do cliente

        Pedido novoPedido = new Pedido(proximoNumeroPedido, nomeCliente);

        boolean adicionandoItens = true;
        while (adicionandoItens) {
            System.out.print("Digite o nome do item (ou 'fim' para concluir): ");
            String nomeItem = scanner.nextLine();

            if (nomeItem.equalsIgnoreCase("fim")) {
                if(novoPedido.getItens().isEmpty()){
                    System.out.println("O pedido precisa ter ao menos um item!");
                } else {
                    adicionandoItens = false;
                }
            } else {
                double precoItem = -1;
                while(precoItem < 0){
                    try {
                        System.out.print("Digite o preço do item (R$): ");
                        precoItem = scanner.nextDouble();
                        if (precoItem < 0) System.out.println("O preço não pode ser negativo.");
                        scanner.nextLine(); // Limpa o buffer
                    } catch (InputMismatchException e){
                        System.out.println("Preço inválido. Por favor, insira um número.");
                        scanner.nextLine(); // Limpa o buffer
                    }
                }
                novoPedido.adicionarItem(new Item(nomeItem, precoItem)); // Adiciona um ou mais itens
            }
        }

        listaDePedidos.add(novoPedido); // Armazena o pedido 
        proximoNumeroPedido++; // Incrementa para o próximo pedido 

        exibirNotaConfirmacao(novoPedido); // Exibe o resumo do pedido 
    }

    /**
     * @param scanner
     */
    private static void removerPedido(Scanner scanner) { 
        System.out.print("\nDigite o número do pedido que deseja remover: ");
        try {
            int numeroRemover = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            Pedido pedidoARemover = null;
            for (Pedido p : listaDePedidos) {
                if (p.getNumero() == numeroRemover) {
                    pedidoARemover = p;
                    break;
                }
            }

            if (pedidoARemover != null) {
                listaDePedidos.remove(pedidoARemover); // Remove o pedido se existir 
                System.out.println("Pedido " + numeroRemover + " removido com sucesso!");
            } else {
                System.out.println("Erro: Pedido não encontrado."); // Mensagem de erro 
            }}
        catch (InputMismatchException e) {
            System.out.println("Número de pedido inválido. Por favor, insira um número inteiro.");
            scanner.nextLine(); // Limpa o buffer
        }
    }

    private static void listarPedidos() { 
        if (listaDePedidos.isEmpty()) {
            System.out.println("\nNenhum pedido registrado no momento.");
            return;
        }

        // Ordena a lista pelo número do pedido 
        Collections.sort(listaDePedidos, Comparator.comparingInt(Pedido::getNumero));

        System.out.println("\n--- Lista de Todos os Pedidos ---");
        for (Pedido pedido : listaDePedidos) { // Exibe todos os pedidos
            System.out.println("\n========================================");
            System.out.println("Pedido Nº: " + pedido.getNumero()); // Mostra o número 
            System.out.println("Cliente: " + pedido.getNomeCliente()); // Mostra o cliente 
            System.out.println("----------------------------------------");
            System.out.println("Itens:"); // Mostra a lista de itens 
            for (Item item : pedido.getItens()) {
                System.out.printf("- %s: R$ %.2f\n", item.getNome(), item.getPreco());
            }
            System.out.println("----------------------------------------");
            System.out.printf("Total: R$ %.2f\n", pedido.getValorTotal()); // Mostra o valor total 
            System.out.println("========================================");
        }
    }

    private static void exibirNotaConfirmacao(Pedido pedido) {
        // Modelo de saída sugerido na "Ajudinha do Prof" [cite: 58, 59, 60]
        System.out.println("\n========================================"); 
        System.out.println("      Restaurante Sabor Digital      "); 
        System.out.println("========================================");
        System.out.println("Pedido Nº " + pedido.getNumero()); 
        System.out.println("Cliente: " + pedido.getNomeCliente()); 
        System.out.println("----------------------------------------"); 
        System.out.println("Itens:"); 
        for (Item item : pedido.getItens()) { 
            System.out.printf("- %s R$ %.2f\n", item.getNome(), item.getPreco()); 
        }
        System.out.println("----------------------------------------"); 
        System.out.printf("Total: R$ %.2f\n", pedido.getValorTotal()); 
        System.out.println("========================================"); 
        System.out.println("      Obrigado pela preferência!      "); 
        System.out.println("========================================\n"); 
    }
}