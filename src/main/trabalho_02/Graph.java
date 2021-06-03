package main.trabalho_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * @author Diogo Jayme
 */
// Essa classe representa uma lista de adjacencia
class Graph {

    //Definindo as cores para ficar mais facil visualizar no algoritmo de busca
    private static final int BRANCO = 0;//Não visitado
    private static final int CINZA = 1;//Visitado outros vertices
    private static final int PRETO = 2;//Visitado

    private int V;// No. de vertices

    private ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        V = v+1;//evita que a lista quebre caso não utilize a posição 0 da lista
        // (neste caso a posição 0 fica obsoleta uma vez que não precisamos dela já que
        // utilizamos como indice a partir do número 1  (cidades tem valor de 1 a C)

        //apenas inicialização das lista de adjacencia
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Adiciona uma aresta entre dois vertices
    // representa as estradas entre as cidades do exercicio
    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    //BFS - Algorítimo de busca em largura.
    //Recebe como parametro a cidade onde juca está e o máximo de pedagios que ele pode pagar
    public int[] BuscaLargura(int s, int P) {
        int cor[] = new int[V];//corindicativo de atingibilidadees
        int d[] = new int[V];///indica a distância desde a origem d(s,u) - em aresta
        int S[] = new int[V];//conjunto das cidades visitadas que ele pode ir
        int C = 0;//contador para adicionar as cidades que ele pode visitar na ordem do array ->

        for (int i = 0; i < V; i++) {
            cor[i] = BRANCO;//inicia todos vertices com cor branca
            d[i] = Integer.MAX_VALUE;//inicia todas as distâncias com infinito
        }

        cor[s] = CINZA;
        d[s] = 0;

        //Inicializa fila
        LinkedList<Integer> Q = new LinkedList<>();//inicia a fila
        Q.add(s);//adiciona o valor a fila

        while (!Q.isEmpty()) {//enquanto a fila n estiver vazia
            int u = Q.poll();//pega o vertice da fila

            //para cada vertice (v), com v pertencente as arestas de V e v != s (vertice onde está juca)
            for (int i = 0; i < adj.get(u).size(); i++) {//para cada vertice que seja adjacente a u
                //se existe vertice adjacente
                int k = adj.get(u).get(i);

                //verifica se ainda não foi visitado e atualiza os valores
                if (cor[k] == BRANCO) {
                    cor[k] = CINZA;
                    d[k] = d[u] + 1;
                    Q.add(k);
                }
            }

            cor[u] = PRETO;//coloca vertice(cidade) como visitada

            //executa a lógica do algorítimo (explicado no readme)
            if (d[u] <= P && cor[u] == PRETO && u != s) {
                S[C] = u;
                Arrays.sort(S);
                C++;
            }
        }

        return S;
    }

}