
//import 
import java.util.Scanner;
// import thread
import java.lang.Thread;

public class Menu {

  public static void menuPrincipal(String[] args) {
    // Fluxo de cadastro de clientes
    Scanner scanner = new Scanner(System.in);

    // Switch case for menu options
    menuOpcoes();

    int opcao = scanner.nextInt();
    while (opcao < 1 || opcao > 4) {
      System.out.println("Opção inválida");
      // text menu
      menuOpcoes();
      opcao = scanner.nextInt();
    }
    while (opcao < 5) {
      switch (opcao) {
        case 1:
          // chama crud de clientes
          Cliente.clienteSubMenu();
          // pause 1 segundo
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          // limpa buffer
          scanner.nextLine();
          // pede opção novamente
          menuOpcoes();
          opcao = scanner.nextInt();
          break;
        case 2:
          // chama crud de quartos
          Quarto.quartoSubMenu();
          // limpa buffer
          scanner.nextLine();
          // pede opção novamente
          menuOpcoes();
          opcao = scanner.nextInt();
          break;
        case 3:
          // Reserva submenu
          Reserva.reservaSubMenu();
          // limpa buffer
          scanner.nextLine();
          // pede opção novamente
          menuOpcoes();
          opcao = scanner.nextInt();
          break;
        case 4:
          // chama crud de camas
          Cama.menuCama();
          // limpa buffer
          scanner.nextLine();
          // pede opção novamente
          menuOpcoes();
          opcao = scanner.nextInt();
          break;
        default:
          System.out.println("Opção inválida");
          break;
      }
      // close scanner
      scanner.close();
    }
  }

  // menu opções texto function
  public static void menuOpcoes() {
    System.out.println("Digite a opção desejada: ");
    System.out.println("1 - Cliente");
    System.out.println("2 - Quarto");
    System.out.println("3 - Reserva");
    System.out.println("4 - Cama");
    System.out.println("5 - Sair");
  }
}
