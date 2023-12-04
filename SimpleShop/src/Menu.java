import java.io.File;
import java.util.Scanner;

public class Menu {

  public static void main() {
    verificaCriaArquivo();
    System.out.println("Bem vindo ao sistema de compras!");
    textoMenu();
    int opcao = 0;
    do {
      Scanner scanner = new Scanner(System.in);
      opcao = scanner.nextInt();
      opcao = functionMenu(opcao);
    } while (opcao != 7);
  }

  private static void verificaCriaArquivo() {
    File db = new File("db.txt");
    if (!db.exists()) {
      try {
        db.createNewFile();
      } catch (Exception e) {
        System.out.println("Erro ao criar arquivo");
      }
    }
  }

  private static void textoMenu() {
    System.out.println("Escolha uma opção:");
    System.out.println("1 - Cadastrar produto");
    System.out.println("2 - Listar produtos");
    System.out.println("3 - Adicionar produto ao carrinho");
    System.out.println("4 - Listar produtos do carrinho");
    System.out.println("5 - Finalizar compra");
    System.out.println("6 - Cancelar compra");
    System.out.println("7 - Sair");
  }

  private static int functionMenu(int opcao) {
    switch (opcao) {
      case 1:
        System.out.println("Cadastrar produto");
        // receber dados do produto
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade em estoque do produto:");
        int estoque = scanner.nextInt();
        System.out.println("Digite o peso do produto:");
        double peso = scanner.nextDouble();
        System.out.println("Digite o id do produto:");
        int idProduto = scanner.nextInt();
        // criar produto
        Produto produto = new Produto(nome, preco, estoque, peso, idProduto);
        // inserir produto no arquivo
        Produto.inserirProduto(nome, preco, estoque, peso, idProduto, new File("productFile.txt"));
        break;

      default:
        System.out.println("Opção inválida");
        break;
    }
    return opcao;
  }

}
