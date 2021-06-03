package main.trabalho_03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        //execução dos casos de teste
        for (int i = 0; i < T; i++) {
            int N, M;

            N = scan.nextInt();//número de vertices
            M = scan.nextInt();//número de arestas

            Graph grafo = new Graph(N, M);

            //para cada caso de teste inicie as arestas
            for (int j = 0; j < M; j++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                int z = scan.nextInt();

                grafo.addAresta(j, x, y, z);
            }

            System.out.println("Teste " + (i + 1));
            grafo.encontraCaminhoMinimo();//executa o algorítmo de caminho mínimo e imprime o caminho mínimo
        }
    }
}
