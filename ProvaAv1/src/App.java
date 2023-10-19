import java.util.Scanner;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) throws Exception {
    welcomeMessage();
    ArrayList<Product> products = new ArrayList<Product>();

    // novo e unico carrinho
    Cart cart = new Cart();
    int opcFinal = 0;

    while (opcFinal != 5) {
      // abre scanner
      Scanner scanner = new Scanner(System.in);
      // imprime menu de opcoes
      optionMenu();
      // recebe opcao do usuario
      opcFinal = scanner.nextInt();
      int productId;
      int quantity;
      String name;
      double price;
      switch (opcFinal) {

        case 1:
          // imprime produtos
          System.out.println("========================Produtos========================");
          for (Product product : products) {
            product.printProduct();
          }
          System.out.println("=========================================================");
          Thread.sleep(2000);

          break;

        case 2:
          // adiciona produto ao carrinho
          System.out.println("Digite o id do produto:");
          productId = scanner.nextInt();

          // verifica se existe um produto com esse id no array de produtos
          for (Product product : products) {
            if (product.getId() == productId) {
              System.out.println("Produto encontrado!");
              System.out.println("Digite a quantidade do produto:");
              quantity = scanner.nextInt();
              CartItens cartIten = new CartItens(productId, quantity);
              cart.addProduct(cartIten);
              System.out.println("Produto adicionado ao carrinho!");
              Thread.sleep(1000);
            }
          }

          break;
        case 3:
          // remove produto do carrinho
          System.out.println("Digite o id do produto:");
          productId = scanner.nextInt();
          cart.removeProduct(productId);
          System.out.println("Produto removido do carrinho!");
          Thread.sleep(1000);

          break;
        case 4:
          // imprime carrinho
          cart.printCart();
          Thread.sleep(2000);

          break;
        case 5:
          // sai do programa
          System.out.println("Até mais!");
          scanner.close();
          Thread.sleep(1000);
          System.exit(0);

          break;
        case 6:
          // cadastra produto
          System.out.println("Digite o id do produto:");
          productId = scanner.nextInt();
          System.out.println("Digite o nome do produto:");
          name = scanner.next();
          System.out.println("Digite o preço do produto:");
          price = scanner.nextDouble();
          System.out.println("Digite a quantidade do produto:");
          quantity = scanner.nextInt();
          Product produto = new Product(productId, name, price, quantity);
          products.add(produto);
          System.out.println("Produto cadastrado com sucesso!");
          Thread.sleep(1000);

          break;
        case 7:
          // remove produto por ID
          System.out.println("Digite o id do produto:");
          productId = scanner.nextInt();
          for (Product product : products) {
            if (product.getId() == productId) {
              printProductById(products, productId);
              products.remove(product);
              System.out.println("Produto removido com sucesso!");
              Thread.sleep(1000);
            }
          }

          break;
        case 8:
          // exibe todos os produtos na arraylist
          System.out.println("========================Produtos========================");
          for (Product product : products) {
            product.printProduct();
          }
          System.out.println("=========================================================");

          Thread.sleep(1000);
          break;

        default:
          break;
      }
    }
  }

  public static void clearConsole() {
    System.out.print("\033[H\033[2J");
  }

  public static void welcomeMessage() {
    System.out.println("========================Prezununca========================");
    System.out.println("Bem vindo ao Prezununca!");
    System.out.println("Aqui você encontra os melhores preços do mercado!");
    System.out.println("Aproveite nossas ofertas e boas compras!");
  }

  public static void optionMenu() {
    System.out.println("========================Cliente========================");
    System.out.println("Digite 1 para ver os produtos disponíveis.");
    System.out.println("Digite 2 para adicionar um produto ao carrinho.");
    System.out.println("Digite 3 para remover um produto do carrinho.");
    System.out.println("Digite 4 para imprimir o carrinho.");
    System.out.println("Digite 5 para sair.");
    System.out.println("========================Administrativo========================");
    System.out.println("Digite 6 para cadastrar um produto.");
    System.out.println("Digite 7 para remover um produto.");
    System.out.println("Digite 8 para imprimir os produtos.");
    System.out.println("Digite 5 para sair.");
    System.out.println("==============================================================");
  }

  public static void printProductById(ArrayList<Product> products, int productId) {
    for (Product product : products) {
      if (product.getId() == productId) {
        product.printProduct();
      }
    }
  }
}
