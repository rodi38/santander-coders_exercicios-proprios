package org.example.stream.expratica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PaginacaoPratica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> lista = new ArrayList<>(List.of("Abigail Williams", "Adam Johnson", "Adriana Moreno",
                "Aiden Thompson", "Alana Anderson", "Alexander Rodriguez", "Alexandria Davis",
                "Alexis Scott", "Alison Brown", "Amelia Thompson", "Andrew Johnson", "Angela Davis",
                "Anna Smith", "Anthony Anderson", "Ariana Rodriguez", "Ashley Williams", "Benjamin Anderson",
                "Bethany Johnson", "Brandon Thompson", "Brenda Davis", "Brianna Rodriguez", "Brooke Williams",
                "Bryan Johnson", "Caitlin Anderson", "Caleb Thompson", "Cameron Rodriguez", "Carl Davis",
                "Caroline Smith", "Carolyn Brown", "Cassandra Rodriguez", "Catherine Davis", "Chad Thompson",
                "Charles Anderson", "Charlotte Smith", "Chloe Williams", "Christian Rodriguez", "Christina Davis",
                "Christopher Anderson", "Clara Smith", "Courtney Brown", "Daniel Anderson", "Danielle Rodriguez",
                "David Johnson", "Deborah Williams", "Demi Thompson", "Dennis Davis", "Derek Anderson", "Diana Smith",
                "Dominic Rodriguez", "Don Davis", "Dylan Thompson", "Elizabeth Anderson", "Emily Williams", "Eric Johnson",
                "Ethan Thompson", "Evan Rodriguez", "Faith Davis", "Fiona Smith", "Gabriel Anderson", "Gage Thompson",
                "Gary Davis", "Genesis Rodriguez", "Georgia Smith", "Grace Williams", "Hailey Anderson", "Haley Johnson",
                "Hannah Thompson", "Harley Davis", "Hayden Rodriguez", "Heather Williams", "Henry Johnson", "Holly Anderson",
                "Hunter Thompson", "Ian Rodriguez", "Isabella Davis", "Jack Anderson", "Jackson Thompson", "Jacob Rodriguez",
                "Jacqueline Davis", "Jake Williams", "James Johnson", "Jamie Anderson", "Janice Thompson", "Jared Rodriguez",
                "Jason Davis", "Jayden Williams", "Jennifer Anderson", "Jesse Johnson", "Jessica Thompson", "Jodie Davis",
                "Joel Rodriguez", "John Anderson", "Johnny Williams", "Jordan Thompson", "Joseph Rodriguez", "Joshua Davis",
                "Julia Anderson", "Justin Thompson", "Kaitlyn Rodriguez", "Kara Davis", "Karen Smith", "Katherine Anderson",
                "Katie Williams", "Kayla Johnson", "Kelsey Thompson", "Kenneth Davis", "Kevin Rodriguez", "Kimberly Williams",
                "Kira Anderson", "Kyle Thompson", "Kylie Rodriguez", "Laura Davis", "Lauren Anderson", "Leah Thompson", "Leo Rodriguez",
                "Levi Davis", "Liam Anderson", "Lily Thompson", "Logan Rodriguez", "Lucas Davis", "Lucy Anderson", "Madison Thompson",
                "Makayla Rodriguez", "Maleah Davis", "Maria Anderson", "Mariah Thompson", "Mark Rodriguez", "Mason Davis",
                "Matt Anderson", "Megan Thompson", "Melissa Rodriguez", "Michael Davis", "Michelle Anderson",
                "Miguel Thompson", "Mike Rodriguez", "Miranda Davis", "Misty Anderson", "Molly Thompson",
                "Morgan Rodriguez", "Natalie Davis", "Nathan Anderson", "Nathaniel Thompson", "Neil Rodriguez",
                "Nicholas Davis", "Nicole Anderson", "Nina Thompson", "Noah Rodriguez", "Nolan Davis",
                "Olivia Anderson", "Owen Thompson", "Paige Rodriguez", "Pamela Davis", "Patricia Anderson"));


        System.out.println(lista.size());
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