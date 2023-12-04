
//import arraylist
import java.util.ArrayList;
//import scanner  
import java.util.Scanner;

public class Quarto {
  private int id;
  private String nomeQuarto;
  private int quantCamas;
  private boolean temBanheiro;
  private String descricao;
  public static ArrayList<Quarto> quartosLista = new ArrayList<Quarto>();

  // Constructor
  public Quarto(int id, String nomeQuarto, int quantCamas, boolean temBanheiro, String descricao) {
    this.id = id;
    this.nomeQuarto = nomeQuarto;
    this.quantCamas = quantCamas;
    this.temBanheiro = temBanheiro;
    this.descricao = descricao;
  }

  // Metodos
  public static void adicionarQuarto(Quarto quarto) {
    quartosLista.add(quarto);
  }

  public static void listarQuartos() {
    for (Quarto quarto : quartosLista) {
      // printar variaveis do quarto
      // text separator
      System.out.println("--------------------------------------------------");
      System.out.println("ID: " + quarto.getId());
      System.out.println("Nome do Quarto: " + quarto.getNomeQuarto());
      System.out.println("Quantidade de Camas: " + quarto.getQuantCamas());
      System.out.println("Tem Banheiro: " + quarto.isTemBanheiro());
      System.out.println("Descrição: " + quarto.getDescricao());
      // text separator
      System.out.println("--------------------------------------------------");

    }
  }

  public static void removerQuarto(Quarto quarto) {
    quartosLista.remove(quarto);
  }

  public static void editarQuarto(int id, String nomeQuarto, int quantCamas, boolean temBanheiro, String descricao) {
    for (Quarto quarto : quartosLista) {
      if (quarto.getId() == id) {
        quarto.setNomeQuarto(nomeQuarto);
        quarto.setQuantCamas(quantCamas);
        quarto.setTemBanheiro(temBanheiro);
        quarto.setDescricao(descricao);
      }
    }
  }

  // metodo para exibir opções do quarto
  public static void quartoSubMenu() {
    Scanner scanner = new Scanner(System.in);
    // chama texto do menu de sub opções
    subMenuQuarto();
    int opcao = scanner.nextInt();
    while (opcao < 1 || opcao > 5) {
      System.out.println("Opção inválida");
      // text menu
      subMenuQuarto();
      opcao = scanner.nextInt();
    }
    while (opcao < 6) {
      switch (opcao) {
        case 1:
          // Adicionar quarto
          System.out.println("Adicionar Quarto");
          // text separator
          System.out.println("--------------------------------------------------");
          System.out.println("Digite o ID do quarto:");
          int id = scanner.nextInt();
          System.out.println("Digite o nome do quarto:");
          String nomeQuarto = scanner.next();
          System.out.println("Digite a quantidade de camas:");
          int quantCamas = scanner.nextInt();
          System.out.println("Tem banheiro? (true/false)");
          boolean temBanheiro = scanner.nextBoolean();
          System.out.println("Digite a descrição do quarto:");
          String descricao = scanner.next();
          // text separator
          System.out.println("--------------------------------------------------");
          // criar objeto quarto
          Quarto quarto = new Quarto(id, nomeQuarto, quantCamas, temBanheiro, descricao);
          // adicionar quarto
          Quarto.adicionarQuarto(quarto);
          // text separator
          System.out.println("--------------------------------------------------");
          System.out.println("Quarto adicionado com sucesso!");
          // text separator
          System.out.println("--------------------------------------------------");
          // text menu
          subMenuQuarto();
          break;
        case 2:
          // Editar quarto
          System.out.println("Editar Quarto");
          // text separator
          System.out.println("--------------------------------------------------");
          System.out.println("Digite o ID do quarto que deseja editar:");
          int idEditar = scanner.nextInt();
          System.out.println("Digite o nome do quarto:");
          String nomeQuartoEditar = scanner.next();
          System.out.println("Digite a quantidade de camas:");
          int quantCamasEditar = scanner.nextInt();
          System.out.println("Tem banheiro? (true/false)");
          boolean temBanheiroEditar = scanner.nextBoolean();
          System.out.println("Digite a descrição do quarto:");
          String descricaoEditar = scanner.next();
          // text separator
          System.out.println("--------------------------------------------------");
          // editar quarto
          Quarto.editarQuarto(idEditar, nomeQuartoEditar, quantCamasEditar, temBanheiroEditar, descricaoEditar);
          // text separator
          System.out.println("--------------------------------------------------");
          System.out.println("Quarto editado com sucesso!");
          // text separator
          System.out.println("--------------------------------------------------");
          // text menu
          subMenuQuarto();
          break;
        case 3:
          // Remover quarto
          System.out.println("Remover Quarto");
          // text separator
          System.out.println("--------------------------------------------------");
          System.out.println("Digite o ID do quarto que deseja remover:");
          int idRemover = scanner.nextInt();
          // text separator
          System.out.println("--------------------------------------------------");
          // remover quarto
          Quarto.removerQuarto(quartosLista.get(idRemover - 1));
          // text separator
          System.out.println("--------------------------------------------------");
          System.out.println("Quarto removido com sucesso!");
          // text separator
          System.out.println("--------------------------------------------------");
          // text menu
          subMenuQuarto();
          break;
        case 4:
          // Listar quartos
          System.out.println("Listar Quartos");
          // text separator
          System.out.println("--------------------------------------------------");
          Quarto.listarQuartos();
          // text separator
          System.out.println("--------------------------------------------------");
          // text menu
          subMenuQuarto();
          break;
        case 5:
          // Voltar
          System.out.println("Voltar");
          // text separator
          System.out.println("--------------------------------------------------");
          // text menu
          break;
        default:
          System.out.println("Opção inválida");
          break;
      }
      // close scanner
      scanner.close();
    }
  }

  // sub menu quarto function
  public static void subMenuQuarto() {
    System.out.println("Digite a opção desejada: ");
    System.out.println("1 - Cadastrar quarto");
    System.out.println("2 - Editar quarto");
    System.out.println("3 - Remover quarto");
    System.out.println("4 - Listar quartos");
    System.out.println("5 - Voltar ao menu principal");
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNomeQuarto() {
    return nomeQuarto;
  }

  public void setNomeQuarto(String nomeQuarto) {
    this.nomeQuarto = nomeQuarto;
  }

  public int getQuantCamas() {
    return quantCamas;
  }

  public void setQuantCamas(int quantCamas) {
    this.quantCamas = quantCamas;
  }

  public boolean isTemBanheiro() {
    return temBanheiro;
  }

  public void setTemBanheiro(boolean temBanheiro) {
    this.temBanheiro = temBanheiro;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
