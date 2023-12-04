import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Produto {

  private String nome;
  private double preco;
  private int estoque;
  private double peso;
  private int idProduto;

  // construtor
  public Produto(String nome, double preco, int estoque, double peso, int idProduto) {
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;
    this.peso = peso;
    this.idProduto = idProduto;
  }

  // getters
  public String getNome() {
    return this.nome;
  }

  public double getPreco() {
    return this.preco;
  }

  public int getEstoque() {
    return this.estoque;
  }

  public double getPeso() {
    return this.peso;
  }

  public int getIdProduto() {
    return this.idProduto;
  }
  // setters

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public void setIdProduto(int idProduto) {
    this.idProduto = idProduto;
  }

  // métodos

  // criar txt de listagem de produtos
  public static void verificaCriaArquivoProduto() {
    File productFile = new File("productFile.txt");
    if (!productFile.exists()) {
      try {
        productFile.createNewFile();
      } catch (Exception e) {
        System.out.println("Erro ao criar arquivo");
      }
    }
  }

  // inserir produto no arquivo
  public static void inserirProduto(String nome, double preco, int estoque, double peso, int idProduto,
      File productFile) {
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(productFile, true));
      bw.write(nome + ";" + preco + ";" + estoque + ";" + peso + ";" + idProduto);
      bw.newLine();
      bw.close();
    } catch (Exception e) {
      System.out.println("Erro ao inserir produto");
    }
  }

  private static String convertIdToString(int idProduto) {
    String produto = Integer.toString(idProduto);
    return produto;
  }
}
