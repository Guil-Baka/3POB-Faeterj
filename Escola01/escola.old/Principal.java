package escola.old;

import java.util.Scanner;

public class Principal {

  public static void main(String[] args) {
    String nome;
    String sigla;
    int periodo;

    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o nome da disciplina: ");
    nome = sc.nextLine();

    System.out.println("Digite a sigla da disciplina: ");
    sigla = sc.nextLine();

    System.out.println("Digite o periodo da disciplina: ");
    periodo = sc.nextInt();

    Disciplina disciplina = new Disciplina(nome, sigla, periodo);
    System.out.println(disciplina.toString());

    sc.close();
  }
}
