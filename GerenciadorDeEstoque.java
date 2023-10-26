package atividadeArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        int totalProdutos = 0;

        while (totalProdutos < 20) {
            System.out.println("Cadastro de Produto #" + (totalProdutos + 1));
            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();

            // Verifica se o produto já existe
            boolean produtoExistente = false;
            for (Produto produto : produtos) {
                if (produto.nome.equals(nome)) {
                    produtoExistente = true;
                    break;
                }
            }

            if (produtoExistente) {
                System.out.println("Produto já cadastrado. Informe outro nome.\n");
                continue;
            }

            System.out.print("Descrição do produto: ");
            String descricao = scanner.nextLine();

            double valor;
            do {
                System.out.print("Valor do produto: ");
                valor = scanner.nextDouble();
                if (valor < 0) {
                    System.out.println("O valor não pode ser negativo. Tente novamente.");
                }
            } while (valor < 0);

            int quantidade;
            do {
                System.out.print("Quantidade em estoque: ");
                quantidade = scanner.nextInt();
                if (quantidade < 0) {
                    System.out.println("A quantidade não pode ser negativa. Tente novamente.");
                }
            } while (quantidade < 0);

            scanner.nextLine(); // Limpa o buffer do teclado

            Produto produto = new Produto(nome, descricao, valor, quantidade);
            produtos.add(produto);
            totalProdutos++;

            System.out.println("Produto cadastrado com sucesso.\n");
        }

        double valorTotal = 0;
        int quantidadeTotal = 0;

        System.out.println("Relatório de Produtos:\n");
        for (Produto produto : produtos) {
            valorTotal += produto.calcularValorTotal();
            quantidadeTotal += produto.quantidade;

            System.out.println("Nome: " + produto.nome);
            System.out.println("Descrição: " + produto.descricao);
            System.out.println("Valor: R$" + produto.valor);
            System.out.println("Quantidade em Estoque: " + produto.quantidade);
            System.out.println("-----------------------");
        }

        double valorMedio = valorTotal / totalProdutos;

        System.out.println("\nResumo:");
        System.out.println("Valor Total dos Produtos: R$" + valorTotal);
        System.out.println("Valor Médio dos Produtos: R$" + valorMedio);
        System.out.println("Quantidade Total de Produtos em Estoque: " + quantidadeTotal);
        System.out.println("\nProdutos com Quantidade em Estoque Menor ou Igual a 5:");

        for (Produto produto : produtos) {
            if (produto.quantidade <= 5) {
                System.out.println("Nome: " + produto.nome);
                System.out.println("Quantidade em Estoque: " + produto.quantidade);
                System.out.println("-----------------------");
            }
        }
        scanner.close();
    }
}
