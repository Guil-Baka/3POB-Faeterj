import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    ArrayList<Produto> produtos = new ArrayList<Produto>();
    produtos.add(new Produto("Arroz 1KG", 10.0, 5));
    produtos.add(new Produto("Feijão 1KG", 5.0, 3));
    produtos.add(new Produto("Macarrão", 7.0, 2));
    Scanner scanner = new Scanner(System.in);
    System.out.println("Produtos atualmente cadastrados:");
    for (Produto produto : produtos) {
      System.out.println(produto);
    }
    menu();
    int opcao = 0;
    while (opcao != 5) {
      opcao = scanner.nextInt();
      limparConsole();
      switch (opcao) {
        case 1:
          limparConsole();
          System.out.println("Cadastrar novo produto:");
          System.out.println("Digite o nome do produto:");
          String nome = scanner.next();
          System.out.println("Digite o preço do produto:");
          double preco = scanner.nextDouble();

          System.out.println("Digite a quantidade do produto a cadastrar no estoque:");
          int quantidade = scanner.nextInt();
          produtos.add(new Produto(nome, preco, quantidade));
          break;
        case 2:
          limparConsole();
          System.out.println("Remover produto:");
          for (Produto produto : produtos) {
            System.out.println("ID: " + produtos.indexOf(produto) + " - " + produto);
          }
          System.out.println("Digite o ID do produto a ser removido:");
          int id = scanner.nextInt();
          produtos.remove(id);
          break;
        case 3:
          // limpar console
          limparConsole();
          System.out.println("Alterar produto");
          System.out.println("Digite o ID do produto a ser alterado:");
          id = scanner.nextInt();
          System.out.println("Digite o novo nome do produto:");
          nome = scanner.next();
          System.out.println("Digite o novo preço do produto:");
          preco = scanner.nextDouble();
          System.out.println("Digite a nova quantidade do produto:");
          quantidade = scanner.nextInt();
          produtos.set(id, new Produto(nome, preco, quantidade));
          break;
        case 4:
          System.out.println("Produtos atualmente cadastrados:");
          printArray(produtos);
          break;
        default:
          System.out.println("Opção inválida");
          break;
      }
      menu();
    }
    scanner.close();
  }

  private static void printArray(ArrayList<Produto> produtos) {
    for (Produto produto : produtos) {
      System.out.println(produto);
    }
  }

  private static void menu() {
    System.out.println("Menu de opções:");
    System.out.println("1 - Cadastrar novo produto");
    System.out.println("2 - Remover produto");
    System.out.println("3 - Alterar produto");
    System.out.println("4 - Listar produtos");
    System.out.println("5 - Encerrar programa");
  }

  private static int receberOpcao() {
    System.out.println("Digite a opção desejada:");
    Scanner opcScanner = new Scanner(System.in);
    int opc = opcScanner.nextInt();
    // fechar o scanner
    opcScanner.close();
    return opc;
  }

  private static void limparConsole() {
    System.out.print("\033[H\033[2J");
  }
}
