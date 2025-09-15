# Sistema de Gerenciamento de Pedidos

[cite_start]Este projeto é uma solução em Java para gerenciamento de pedidos de um restaurante, desenvolvido como atividade para o Laboratório 1 da disciplina de LP2. O sistema é executado via console e permite registrar novos pedidos, remover pedidos existentes e listar todos os pedidos ativos. 

## 📋 Funcionalidades

O sistema apresenta um menu principal com as seguintes opções[cite: 16]:

* 1. Registrar Pedido:
    * [cite_start]Solicita o nome do cliente
    * [cite_start]Gera um número de pedido sequencial automaticamente (1, 2, 3...)
    * [cite_start]Permite adicionar múltiplos itens, solicitando nome e preço para cada um
    * [cite_start]Ao final, exibe uma nota de confirmação com o resumo e o valor total do pedido
* 2. Remover Pedido:
    * Solicita o número do pedido a ser removido
    * Remove o pedido da lista caso ele exista, ou exibe uma mensagem de erro caso contrário
* 3. Listar Pedidos*:
    * Exibe todos os pedidos registrados em ordem crescente de número.
    * Para cada pedido, mostra o número, nome do cliente, a lista de itens com seus preços e o valor total calculado.
* 4. Sair:
    * Encerra a execução do programa.

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando os seguintes conceitos e tecnologias, conforme os requisitos técnicos obrigatórios:

* Linguagem: Java
* Orientação a Objetos:
    * Uso de Classes e Objetos (`Pedido`, `Item`).
    * Aplicação do conceito de Composição, onde a classe `Pedido` é composta por uma lista de objetos `Item`.
* Estrutura de Dados: `ArrayList` para armazenar a lista de pedidos.
* Interface: A interação com o usuário é feita via console, utilizando a classe `Scanner`[cite: 52].
* [Controle de Fluxo: O menu principal utiliza um laço `while` e uma estrutura `switch-case` para a navegação.

> Nota para usuários do VS Code: Se você tiver o "Extension Pack for Java" instalado, basta abrir o arquivo `SistemaRestaurante.java` e clicar no botão "Run" que aparece acima do método `main`.

## ⚙️ Como Usar o Programa

Após iniciar o programa, um menu aparecerá no console.

1.  Para registrar um pedido:
    * Digite `1` e pressione Enter.
    * Informe o nome do cliente.
    * Digite o nome do primeiro item e seu preço.
    * Continue adicionando itens. Quando terminar, digite `fim` no nome do item para concluir.
    * Uma nota de confirmação será exibida.

2.  Para remover um pedido:
    * Digite `2` e pressione Enter.
    * Informe o número do pedido que deseja remover.

3.  Para listar os pedidos:
    * Digite `3` e pressione Enter.
    * Todos os pedidos ativos serão exibidos na tela.

4.  Para sair:
    * Digite `4` e pressione Enter.
