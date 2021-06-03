package main.trabalho_04_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int casosDeTeste = scanner.nextInt();

        //executa N casos de teste
        for (int k = 0; k < casosDeTeste; k++) {

            int N = scanner.nextInt();
            int M = scanner.nextInt();

            //Insere os vertices (PILARES)
            //Adiciona +2 pois é necessário representar o pilar inicial (0) e o acampamento (N+1)
            Vertice[] vertices = new Vertice[N + 2];

            for (int i = 0; i < N + 2; i++) {
                vertices[i] = new Vertice();
            }

            Aresta[] arestas = new Aresta[M];

            //insere o valor nas arestas
            for (int i = 0; i < M; i++) {
                int S = scanner.nextInt();
                int T = scanner.nextInt();
                int B = scanner.nextInt();

                arestas[i] = new Aresta(S, T, B);
            }

            Graph_04 graph04 = new Graph_04(arestas, vertices);

            //Executa o dijkstra e calcula o custo mínimo no final
            int custoMinimo = graph04.executaDijkstra();

            //imprime o resultado
            System.out.println(custoMinimo);
        }
    }


}
