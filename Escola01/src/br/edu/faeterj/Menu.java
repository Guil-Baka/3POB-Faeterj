package br.edu.faeterj;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
//import java file library;
import java.io.File;
import java.io.FileWriter;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Menu {
  private ArrayList<Aluno> alunos = new ArrayList();
  private int opcao = 0;
  private int writeFailCounter = 0;

  public void Processamento() {
    String nome = "";
    String cpf;
    Date dtNasc;
    String dtAux;
    String matricula;
    String endereco;
    String cep;
    Scanner sc = new Scanner(System.in);

    // verify if aluno file exists if not create it
    File file = new File("alunos.txt");
    if (!file.exists()) {
      // create file check if it was created
      try {
        file.createNewFile();
      } catch (Exception e) {
        System.out
            .println(
                "[Falha crítica] Erro ao criar arquivo de armazenamento de alunos. Não é possível continuar.	\n");
        // exit program
        sc.close();
        System.exit(0);
      }
    }

    while (opcao < 2) {
      System.out.println("Digite seu primeiro nome ");
      nome = sc.next();
      // ask for name again if it is not valid (only letters and spaces)
      while (!Pattern.matches("[a-zA-Z]+", nome)) {
        System.out.println("Nome inválido. Digite seu primeiro nome ");
        nome = sc.next();
      }
      System.out.println("Digite seu CPF (somente os numeros): ");
      cpf = sc.next();
      // ask for cpf again if it is not valid (only numbers following this pattern
      // xxx.xxx.xxx-xx )
      while (!Pattern.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$", cpf)) {
        System.out.println("Digite seu CPF (somente os numeros): ");
        cpf = sc.next();
      }
      dtAux = sc.next();
      // dtNasc = sc.next();
      System.out.println("sua data de nascimento é: " + dtAux);
      // dtNasc = LocalDateTime.parse();
      System.out.println("Digite sua matricula: ");
      matricula = sc.next();
      System.out.println("Digite seu Endereço: ");
      endereco = sc.next();
      System.out.println("valor de endereco: " + endereco);
      System.out.println("Digite seu CEP (somente os numeros): ");
      cep = sc.next();
      System.out.println("valor de cep: " + cep);

      Aluno aluno = new Aluno(nome, cpf, matricula, dtAux, endereco, cep);

      alunos.add(aluno);

      // write aluno to file
      try {
        FileWriter writer = new FileWriter("alunos.txt", true);
        writer.write("\n" + aluno.getNome() + ";" + aluno.getCpf()
            + ";" + aluno.getMatricula() + ";" + aluno.getDtNasc()
            + ";" + aluno.getEndereco() + ";" + aluno.getCep() + ";");
        writer.flush();
        writer.close();
      } catch (Exception e) {
        if (writeFailCounter >= 2) {
          System.out
              .println("[Falha crítica] Erro ao gravar aluno no arquivo. Não é possível continuar.	\n");
          // exit program
          sc.close();
          System.exit(0);
        }
        System.out
            .println("[Falha] Erro ao gravar aluno no arquivo. Tente novamente.	\n");
      }

      System.out.println("Existem mais alunos a incluir 1=Sim / 2=Não ");
      opcao = sc.nextInt();
      System.out.println("opção é: " + opcao);
      // if (opcao == "S") break;

      sc.close();
    }
  }

}
