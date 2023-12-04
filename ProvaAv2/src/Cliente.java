import java.util.ArrayList;
//regex
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// scanner
import java.util.Scanner;

public class Cliente {

  // id, nome, endereço, postalCode, pais, CPF, Passaporte, email, dataNascimento.
  private int id;
  private String nome;
  private String endereco;
  private String postalCode;
  private String pais;
  private String CPF;
  private String Passaporte;
  private String email;
  private String dataNascimento;
  public static ArrayList<Cliente> clientesLista = new ArrayList<Cliente>();

  // Criar metodo para adicionar cliente
  public static void addCliente(Cliente cliente) {
    clientesLista.add(cliente);
  }

  // Criar metodo para remover cliente
  public static void removeCliente(Cliente cliente) {
    clientesLista.remove(cliente);
  }

  // Criar metodo para listar clientes
  public static void listarClientes() {
    // a lista está vazia?
    if (clientesLista.isEmpty()) {
      System.out.println("Não há clientes cadastrados");
    } else {
      System.out.println("Lista de Clientes:");
      // text separator
      System.out.println("--------------------------------------------------");
      for (Cliente cliente : clientesLista) {
        System.out.println(cliente);
      }
    }

  }

  // Criar metodo para buscar e Editar cliente
  public static void editarCliente(int id, String nome, String endereco, String postalCode, String pais, String CPF,
      String Passaporte, String email, String dataNascimento) {
    for (Cliente cliente : clientesLista) {
      if (cliente.getId() == id) {
        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        cliente.setPostalCode(postalCode);
        cliente.setPais(pais);
        cliente.setCPF(CPF);
        cliente.setPassaporte(Passaporte);
        cliente.setEmail(email);
        cliente.setDataNascimento(dataNascimento);
      }
    }
  }

  // Método Validar CPF
  public static boolean validarCPF(String CPF) {
    // Regex para validar CPF
    String regex = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(CPF);
    if (matcher.matches()) {
      return true;
    } else {
      return false;
    }
  }

  // Método Validar Data
  public static boolean validarData(String data) {
    // Regex para validar data
    String regex = "^(\\d{2}\\/\\d{2}\\/\\d{4})$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(data);
    if (matcher.matches()) {
      return true;
    } else {
      return false;
    }
  }

  // Método Validar Email
  public static boolean validarEmail(String email) {
    // Regex para validar email
    String regex = "^(.+)@(.+)$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    if (matcher.matches()) {
      return true;
    } else {
      return false;
    }
  }

  // metodo para exibir opções do cliente
  public static void clienteSubMenu() {
    Scanner scanner = new Scanner(System.in);
    // chama texto do menu de sub opções
    subMenuCliente();
    int opcao = scanner.nextInt();
    while (opcao < 1 || opcao > 5) {
      System.out.println("Opção inválida");
      // text menu
      subMenuCliente();
      opcao = scanner.nextInt();
    }
    while (opcao < 5) {
      // if
      // inicializar TODAS as variaveis aqui
      int id = 0;
      String nome = "";
      String endereco = "";
      String postalCode = "";
      String pais = "";
      String CPF = "";
      String Passaporte = "";
      String email = "";
      String dataNascimento = "";

      if (opcao == 1) {
        // Adicionar cliente
        System.out.println("Adicionar Cliente");
        // text separator
        System.out.println("--------------------------------------------------");
        // pega id pelo tamanho da lista
        id = clientesLista.size() + 1;
        System.out.println("Digite o nome do cliente:");
        nome = scanner.next();
        System.out.println("Digite o endereço do cliente:");
        endereco = scanner.next();
        System.out.println("Digite o CEP do cliente:");
        postalCode = scanner.next();
        System.out.println("Digite o país do cliente:");
        pais = scanner.next();
        System.out.println("Digite o CPF do cliente:");
        CPF = scanner.next();
        System.out.println("Digite o Passaporte do cliente:");
        Passaporte = scanner.next();
        System.out.println("Digite o email do cliente:");
        email = scanner.next();
        System.out.println("Digite a data de nascimento do cliente:");
        dataNascimento = scanner.next();
        // text separator
        System.out.println("--------------------------------------------------");
        // criar objeto cliente
        Cliente cliente = new Cliente(id, nome, endereco, postalCode, pais, CPF, Passaporte, email, dataNascimento);
        // adicionar cliente
        Cliente.addCliente(cliente);
        // text separator
        System.out.println("--------------------------------------------------");
        System.out.println("Cliente adicionado com sucesso!");
        // text separator
        System.out.println("--------------------------------------------------");
        // text menu
        subMenuCliente();
      } else if (opcao == 2) {
        // Editar cliente
        System.out.println("Editar Cliente");
        // text separator
        System.out.println("--------------------------------------------------");
        System.out.println("Digite o ID do cliente:");
        id = scanner.nextInt();
        System.out.println("Digite o nome do cliente:");
        nome = scanner.next();
        System.out.println("Digite o endereço do cliente:");
        endereco = scanner.next();
        System.out.println("Digite o CEP do cliente:");
        postalCode = scanner.next();
        System.out.println("Digite o país do cliente:");
        pais = scanner.next();
        System.out.println("Digite o CPF do cliente:");
        CPF = scanner.next();
        System.out.println("Digite o Passaporte do cliente:");
        Passaporte = scanner.next();
        System.out.println("Digite o email do cliente:");
        email = scanner.next();
      }
      scanner.close();
    }
  }

  // sub menu cliente function
  public static void subMenuCliente() {
    System.out.println("Digite a opção desejada: ");
    System.out.println("1 - Cadastrar cliente");
    System.out.println("2 - Editar cliente");
    System.out.println("3 - Remover cliente");
    System.out.println("4 - Listar clientes");
    System.out.println("5 - Voltar ao menu principal");
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public String getPassaporte() {
    return Passaporte;
  }

  public void setPassaporte(String Passaporte) {
    this.Passaporte = Passaporte;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  // Constructor
  public Cliente(int id, String nome, String endereco, String postalCode, String pais, String CPF, String Passaporte,
      String email, String dataNascimento) {
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
    this.postalCode = postalCode;
    this.pais = pais;
    this.CPF = CPF;
    this.Passaporte = Passaporte;
    this.email = email;
    this.dataNascimento = dataNascimento;
  }
}