import java.util.ArrayList;
import java.util.Scanner;

public class Cama {

  private int id;
  private int codigoCama;
  private boolean ehBeliche;
  private String posicao;
  private String descricao;
  public static ArrayList<Cama> camasLista = new ArrayList<Cama>();

  public Cama(int id, int codigoCama, boolean ehBeliche, String posicao, String descricao) {
    this.id = id;
    this.codigoCama = codigoCama;
    this.ehBeliche = ehBeliche;
    this.posicao = posicao;
    this.descricao = descricao;
  }

  //
  public static void adicionarCama(Cama cama) {
    camasLista.add(cama);
  }

  public static void listarCamas() {
    for (Cama cama : camasLista) {
      // printar variaveis do quarto
      // text separator
      System.out.println("--------------------------------------------------");
      System.out.println("ID: " + cama.getId());
      System.out.println("Código da Cama: " + cama.getCodigoCama());
      System.out.println("É Beliche: " + cama.isEhBeliche());
      System.out.println("Posição: " + cama.getPosicao());
      System.out.println("Descrição: " + cama.getDescricao());
      // text separator
      System.out.println("--------------------------------------------------");

    }
  }

  public static void removerCama(Cama cama) {
    camasLista.remove(cama);
  }

  public static void editarCama(int id, int codigoCama, boolean ehBeliche, String posicao, String descricao) {
    for (Cama cama : camasLista) {
      if (cama.getId() == id) {
        cama.setCodigoCama(codigoCama);
        cama.setEhBeliche(ehBeliche);
        cama.setPosicao(posicao);
        cama.setDescricao(descricao);
      }
    }
  }

  // menu opções texto function

  public static void menuOpcoesCama() {
    System.out.println("Digite a opção desejada: ");
    System.out.println("1 - Adicionar Cama");
    System.out.println("2 - Listar Camas");
    System.out.println("3 - Remover Cama");
    System.out.println("4 - Editar Cama");
    System.out.println("5 - Voltar");
  }

  // menu para CRUD de camas
  public static void menuCama() {
    // Fluxo de cadastro de camas
    Scanner scanner = new Scanner(System.in);

    // Switch case for menu options
    menuOpcoesCama();

    int opcao = scanner.nextInt();
    while (opcao < 1 || opcao > 5) {
      System.out.println("Opção inválida");
      // text menu
      menuOpcoesCama();
      opcao = scanner.nextInt();
    }
    while (opcao < 6) {
      switch (opcao) {
        case 1:
          // Adicionar cama
          System.out.println("Digite o ID da cama: ");
          int id = scanner.nextInt();
          System.out.println("Digite o código da cama: ");
          int codigoCama = scanner.nextInt();
          System.out.println("Digite se é beliche: ");
          boolean ehBeliche = scanner.nextBoolean();
          System.out.println("Digite a posição da cama: ");
          String posicao = scanner.next();
          System.out.println("Digite a descrição da cama: ");
          String descricao = scanner.next();
          Cama cama = new Cama(id, codigoCama, ehBeliche, posicao, descricao);
          Cama.adicionarCama(cama);
          break;
        case 2:
          // Listar camas
          Cama.listarCamas();
          break;
        case 3:
          // Remover cama
          System.out.println("Digite o ID da cama: ");
          int idRemover = scanner.nextInt();
          for (Cama camaRemover : camasLista) {
            if (camaRemover.getId() == idRemover) {
              Cama.removerCama(camaRemover);
            }
          }
          break;
        case 4:
          // Editar cama
          System.out.println("Digite o ID da cama: ");
          int idEditar = scanner.nextInt();
          System.out.println("Digite o código da cama: ");
          int codigoCamaEditar = scanner.nextInt();
          System.out.println("Digite se é beliche: ");
          boolean ehBelicheEditar = scanner.nextBoolean();
          System.out.println("Digite a posição da cama: ");
          String posicaoEditar = scanner.next();
          System.out.println("Digite a descrição da cama: ");
          String descricaoEditar = scanner.next();
          Cama.editarCama(idEditar, codigoCamaEditar, ehBelicheEditar, posicaoEditar, descricaoEditar);
          break;
        default:
          System.out.println("Opção inválida");
          break;
      }
      // close scanner
      scanner.close();
    }
  }

  // getters
  public int getId() {
    return id;
  }

  public int getCodigoCama() {
    return codigoCama;
  }

  public boolean isEhBeliche() {
    return ehBeliche;
  }

  public String getPosicao() {
    return posicao;
  }

  public String getDescricao() {
    return descricao;
  }

  // setters

  public void setId(int id) {
    this.id = id;
  }

  public void setCodigoCama(int codigoCama) {
    this.codigoCama = codigoCama;
  }

  public void setEhBeliche(boolean ehBeliche) {
    this.ehBeliche = ehBeliche;
  }

  public void setPosicao(String posicao) {
    this.posicao = posicao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
