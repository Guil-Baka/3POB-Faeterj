import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Reserva {
  // attributes
  private int id;
  private int idCliente;
  private int idQuarto;
  private int idCama;
  private String dataEntrada;
  private String dataSaida;
  private String status;
  public static ArrayList<Reserva> reservasLista = new ArrayList<Reserva>();

  // constructor
  public Reserva(int id, int idCliente, int idQuarto, int idCama, String dataEntrada, String dataSaida, String status) {
    this.id = id;
    this.idCliente = idCliente;
    this.idQuarto = idQuarto;
    this.idCama = idCama;
    this.dataEntrada = dataEntrada;
    this.dataSaida = dataSaida;
    this.status = status;
  }

  // methods

  // pega data atual do sistema
  public static String dataAtual() {
    Date data = new Date();
    String dataAtual = data.toString();
    return dataAtual;
  }

  // compara duas datas usando o numero de dias como retorno
  public static int comparaDatas(String data1, String data2) {
    int dias = 0;
    try {
      // Define formato da data
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      // Converte as datas para Date
      Date dataInicio = sdf.parse(data1);
      Date dataFim = sdf.parse(data2);
      // Calcula a diferença em dias entre as duas datas
      dias = (int) ((dataFim.getTime() - dataInicio.getTime()) / (1000 * 60 * 60 * 24));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return dias;
  }

  public static void adicionarReserva(Reserva reserva) {
    reservasLista.add(reserva);
  }

  public static void listarReservas() {
    for (Reserva reserva : reservasLista) {
      // printar variaveis do quarto
      // text separator
      System.out.println("--------------------------------------------------");
      System.out.println("ID: " + reserva.getId());
      System.out.println("ID do Cliente: " + reserva.getIdCliente());
      // exibe o nome do cliente relacionado ao id
      for (Cliente cliente : Cliente.clientesLista) {
        if (cliente.getId() == reserva.getIdCliente()) {
          System.out.println("Nome do Cliente: " + cliente.getNome());
        }
      }
      System.out.println("ID do Quarto: " + reserva.getIdQuarto());
      System.out.println("Data de Entrada: " + reserva.getDataEntrada());
      System.out.println("Data de Saída: " + reserva.getDataSaida());
      System.out.println("Status: " + reserva.getStatus());
      // text separator
      System.out.println("--------------------------------------------------");

    }
  }

  public static void removerReserva(Reserva reserva) {
    reservasLista.remove(reserva);
  }

  public static void editarReserva(int id, int idCliente, int idQuarto, String dataEntrada, String dataSaida,
      String dataReserva, String status) {
    for (Reserva reserva : reservasLista) {
      if (reserva.getId() == id) {
        reserva.setIdCliente(idCliente);
        reserva.setIdQuarto(idQuarto);
        reserva.setDataEntrada(dataEntrada);
        reserva.setDataSaida(dataSaida);
        reserva.setStatus(status);
      }
    }
  }

  // menu opções reserva
  public static void reservaSubMenu() {
    Scanner scanner = new Scanner(System.in);
    // chama texto do menu de sub opções
    menuOpcoesReserva();

    int opcao = scanner.nextInt();
    while (opcao < 1 || opcao > 5) {
      System.out.println("Opção inválida");
      // text menu
      menuOpcoesReserva();
      opcao = scanner.nextInt();
    }
    while (opcao < 6) {
      // if
      if (opcao == 1) {
        // Adicionar reserva
        System.out.println("Adicionar Reserva");
        // text separator
        System.out.println("--------------------------------------------------");
        // id da reserva pelo tamanho da lista
        int id = reservasLista.size() + 1;
        System.out.println("Digite o ID do cliente:");
        int idCliente = scanner.nextInt();
        // é quarto ou cama?
        System.out.println("Quarto(Q) ou Cama(C)?");
        String quartoOuCama = scanner.next();
        // se for quarto
        int idQuarto = -1;
        int idCama = -1;
        if (quartoOuCama.equals("Q")) {
          System.out.println("Digite o ID do quarto:");
          idQuarto = scanner.nextInt();
        } else if (quartoOuCama.equals("C")) {
          System.out.println("Digite o ID da cama:");
          idCama = scanner.nextInt();
        }
        // laço de repetição, enquanto a data de entrada for maior que a data de saida,
        // pede para digitar novamente
        String dataEntrada = "";
        String dataSaida = "";
        while (comparaDatas(dataEntrada, dataSaida) < 1) {
          System.out.println("Digite a data de entrada:");
          dataEntrada = scanner.next();
          System.out.println("Digite a data de saída:");
          dataSaida = scanner.next();
          if (comparaDatas(dataEntrada, dataSaida) < 1) {
            System.out.println("Data de entrada não pode ser maior que a data de saída");
          }
        }
        System.out.println("Digite o status da reserva:");
        String status = scanner.next();
        // text separator
        System.out.println("--------------------------------------------------");
        // criar objeto reserva
        Reserva reserva = new Reserva(id, idCliente, idQuarto, idCama, dataEntrada, dataSaida, status);
        // adicionar reserva
        Reserva.adicionarReserva(reserva);
        // text separator
        System.out.println("--------------------------------------------------");
        System.out.println("Reserva adicionada com sucesso!");
        // text separator
        System.out.println("--------------------------------------------------");
        // text menu
        menuOpcoesReserva();
      } else if (opcao == 2) {
        // Listar reservas
        System.out.println("Listar Reservas");
        // text separator
        System.out.println("--------------------------------------------------");
        // listar reservas
        Reserva.listarReservas();
        // text separator
        System.out.println("--------------------------------------------------");
        // text menu
        menuOpcoesReserva();
      } else if (opcao == 3) {
        // Remover reserva
        System.out.println("Remover Reserva");
        // text separator
        System.out.println("--------------------------------------------------");
        // listar reservas
        Reserva.listarReservas();
        // text separator
        System.out.println("--------------------------------------------------");
        // remover reserva
        System.out.println("Digite o ID da reserva que deseja remover:");
        int id = scanner.nextInt();
        for (Reserva reserva : reservasLista) {
          if (reserva.getId() == id) {
            Reserva.removerReserva(reserva);
          }
          // close scanner
          scanner.close();
        }
      }
    }
  }

  // menu opções texto function
  public static void menuOpcoesReserva() {
    System.out.println("Digite a opção desejada: ");
    System.out.println("1 - Adicionar Reserva");
    System.out.println("2 - Listar Reservas");
    System.out.println("3 - Remover Reserva");
    System.out.println("4 - Editar Reserva");
    System.out.println("5 - Sair");
  }

  // getters
  public int getId() {
    return id;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public int getIdQuarto() {
    return idQuarto;
  }

  public int getIdCama() {
    return idCama;
  }

  public String getDataEntrada() {
    return dataEntrada;
  }

  public String getDataSaida() {
    return dataSaida;
  }

  public String getStatus() {
    return status;
  }

  // setters
  public void setId(int id) {
    this.id = id;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public void setIdQuarto(int idQuarto) {
    this.idQuarto = idQuarto;
  }

  public void setIdCama(int idCama) {
    this.idCama = idCama;
  }

  public void setDataEntrada(String dataEntrada) {
    this.dataEntrada = dataEntrada;
  }

  public void setDataSaida(String dataSaida) {
    this.dataSaida = dataSaida;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
