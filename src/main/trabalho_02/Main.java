package main.trabalho_02;

import java.util.*;
/**
 * @author Diogo Jayme
 */
public class Main {

    public static void main(String[] args) {
        int testCases;
        Scanner scanner = new Scanner(System.in);
        //Você deve primeiramente entrar com o número de casos de teste
        testCases = scanner.nextInt();

        for (int j = 0; j < testCases; j++) {
            int C; //Número de cidades   5        - Identificação das cidades - 1 a C onde C >= 0 && C <= 50
            int E; //Número de estradas  4       - onde E >= 0 && <= 2500
            int L; //Cidade destino      2       - onde L >= 0 && <= C
            int P; //Número máximo de pedagios 1  - onde P >= 0 && <= C

            Main main = new Main();

//            System.out.println("Digite o numero de cidades");
            C = scanner.nextInt();
//            System.out.println("Digite o numero de estradas");
            E = scanner.nextInt();
//            System.out.println("Onde está a familia de Juquinha?");
            L = scanner.nextInt();
//            System.out.println("Quantos pedagios Juquinha pode pagar?");
            P = scanner.nextInt();

            main.encontrarCidade(C, E, L, P, j);
        }
    }

    private void encontrarCidade(int C, int E, int L, int P, int j) {
        if (C == 0 && E == 0 && L == 0 && P == 0) {
            return;
        }

        if (validaEntradas(C, E, L, P)) {
            Scanner scanner = new Scanner(System.in);
            Graph G = new Graph(C);

            //insere as estradas entre cidade x e y
            for (int i = 0; i < E; i++) {
                int x, y;
                //etapa que lê as entradas (estradas que ligam as cidades)
                x = scanner.nextInt();
                y = scanner.nextInt();

                if ((x >= 0 && x <= C) && (y >= 0 && y <= C)) {//faz a validação para o número correto de vertices e arestas (cidades e estradas)
                    G.addEdge(x, y);
                } else {
                    System.out.println("Digite uma cidade válida. >= s0 && <= " + C);
                }
            }

            //executa o algorítmo de busca em largura
            int[] v = G.BuscaLargura(L, P);
            //imprime o número do teste
            System.out.println("Teste " + (j + 1));

            //imprime a saída do teste j
            for (int k : v) {
                if (k != 0) {
                    System.out.print(" " + k);
                }
            }

            System.out.println();
        }
    }

    private boolean validaEntradas(int C, int E, int L, int P) {
        if (C >= 0 && C <= 50) {
            if (E >= 0 && E <= 2500) {
                if (L >= 0 && L <= C) {
                    if (P >= 0 && P <= C) {
                        return true;
                    } else {
//                        System.out.println("Total de pedagios inválido");
                    }
                } else {
//                    System.out.println("Cidade invalida!");
                }
            } else {
//                System.out.println("Número de estradas invalido!");
            }
        } else {
//            System.out.println("Número de cidades invalido!");
        }
        return false;
    }

}
