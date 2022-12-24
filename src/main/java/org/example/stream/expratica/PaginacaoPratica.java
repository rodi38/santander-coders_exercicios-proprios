package org.example.stream.expratica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PaginacaoPratica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> lista = new ArrayList<>(List.of("Ana", "Beatriz", "Bruno", "Carlos", "Davi",
                "Eric", "Felipe", "Fernanda", "Fernanda", "Gabriel", "Guilherme", "Gustavo",
                "Henrique", "Isabel", "Isabella", "Joao", "Karina", "Juliana", "Juliano",
                "Karina", "Leonardo", "Larissa", "Luciana", "Luciana", "Lucas", "Luiza",
                "Luiza", "Luiza", "Manuela", "Manuela", "Marcelo", "Maria", "Maria", "Maria",
                "Matheus", "Mariana", "Paulo", "Pedro", "Rafael", "Rafael", "Rafaela", "Renata",
                "Roberta", "Roberta", "Rodrigo", "Samuel", "Sofia", "Sofia", "Thais", "Thiago",
                "Victor", "Victor", "Vinicius", "Wolfsberg"));


        System.out.println("-----------------------------------------------");
        System.out.println("\n PAGINA 01 \n");
        System.out.println("-----------------------------------------------");

        lista.stream().sorted().limit(10).forEach(e -> {
            System.out.println(e.toUpperCase());
        });
        System.out.println("-----------------------------------------------");


        int opcao = -1;
        int skip = 10;

        while (true){
            System.out.println("0 - Pagina anterior");
            System.out.println("1 - Proxima pagina");
            System.out.println("2 - Desligar");
            try {
                int next = sc.nextInt();
                sc.nextLine();
                if (next < 0 || next > 2 ){
                    System.out.println("Opção incorreta.");
                    continue;
                }
                opcao = next;
                if (opcao == 1 ){
                    skip += 10;
                    System.out.println("-----------------------------------------------");
                    System.out.println("\nProxima pagina\n");
                    System.out.println("-----------------------------------------------");

                    if (skip > lista.size()){
                        System.out.println("Não há proximas paginas.");
                        skip -= 10;
                        continue;
                    }
                    lista.stream().sorted().skip(skip).limit(10).forEach(e -> {
                        System.out.println(e.toUpperCase());
                    });
                    System.out.println("-----------------------------------------------");


                    continue;
                }
                if (opcao == 0){
                    if (skip == 10){
                        System.out.println("-----------------------------------------------");

                        System.out.println("\nNão há paginas anteriores.\n");
                        System.out.println("-----------------------------------------------");

                        continue;
                    }
                    System.out.println("-----------------------------------------------");
                    System.out.println("\nPagina anterior\n");
                    System.out.println("-----------------------------------------------");

                    skip -= 10;
                    lista.stream().sorted().skip(skip).limit(10).forEach(e -> {
                        System.out.println(e.toUpperCase());
                    });
                    System.out.println("-----------------------------------------------");
                    continue;
                }
                System.out.println("Saindo...");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas um numero.");
            }
        }

    }

}