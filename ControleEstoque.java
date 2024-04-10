import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControleEstoque {
    private static Map<String, Integer> estoque = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Adicionar Produto");
                System.out.println("2 - Vender Produto");
                System.out.println("3 - Exibir Estoque");
                System.out.println("4 - Sair");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        adicionarProduto(scanner);
                        break;
                    case 2:
                        venderProduto(scanner);
                        break;
                    case 3:
                        exibirEstoque();
                        break;
                    case 4:
                        System.out.println("Saindo do programa...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void adicionarProduto(Scanner scanner) {
        try {
            System.out.println("Digite o nome do produto:");
            String nome = formatarNomeProduto(scanner.next());

            System.out.println("Digite a quantidade do produto:");
            int quantidade = scanner.nextInt();

            if (!nome.isBlank()) {
                quantidade += estoque.getOrDefault(nome, 0);
                estoque.put(nome, quantidade);
                System.out.println("Produto adicionado com sucesso!");
            } else {
                System.out.println("Nome do produto inválido!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar o produto: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void venderProduto(Scanner scanner) {
        try {
            System.out.println("Digite o nome do produto:");
            String nome = formatarNomeProduto(scanner.next());
            System.out.println("Digite a quantidade a ser vendida:");
            int quantidade = scanner.nextInt();

            if (estoque.containsKey(nome)) {
                int estoqueAtual = estoque.get(nome);
                if (estoqueAtual >= quantidade) {
                    estoque.put(nome, estoqueAtual - quantidade);
                    System.out.println("Venda realizada com sucesso!");
                } else {
                    System.out.println("Quantidade insuficiente em estoque!");
                }
            } else {
                System.out.println("Produto não encontrado em estoque!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao vender o produto: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void exibirEstoque() {
        try {
            System.out.println("Estoque atual:");
            for (String produto : estoque.keySet()) {
                int quantidade = estoque.get(produto);
                System.out.println(produto + ": " + quantidade);
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao exibir o estoque: " + e.getMessage());
        }
    }

    private static String formatarNomeProduto(String nome) {
        if (nome.length() > 0) {
            return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        }
        return nome;
    }
}
