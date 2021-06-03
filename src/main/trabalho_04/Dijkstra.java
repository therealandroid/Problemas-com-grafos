package main.trabalho_04;

import java.util.*;

public class Dijkstra {

    final int INFINITY = 9999;
    //cria fila
    private HashMap<Integer, Vertice> Q = new HashMap<>();

    //armazena os vertices que ja foram relaxados
    private HashMap<Integer, Vertice> S = new HashMap<>();

    public void executa(Graph_4 grafo) {

        Vertice origem = grafo.vertices().get(0);

        //inicializa as distancias infinitas para todos os vertices
        for (int i = 0; i < grafo.vertices().size(); i++) {
            grafo.vertices().get(i).distancia = INFINITY;

            for (int j = 0; j < grafo.vertices().get(i).vizinhos.size(); j++) {
                grafo.vertices().get(i).vizinhos.get(j).distancia = INFINITY;
            }
        }

        origem.distancia = 0;  //o vertice inicial recebe distancia 0

        //inicializa a lista de vertices que ainda não foram relaxados
        for (int i = 0; i < grafo.vertices().size(); i++) {
            //adiciona o vertice na lista de não visitados
            Q.put(grafo.vertices().get(i).id, grafo.vertices().get(i));
        }

        System.out.println();

        //Add o primeiro vertice no caminho
        S.put(origem.id, origem);

        while (!Q.isEmpty()) {
            Vertice u = extrairMinimo();
            u.visitado = true;

            //para cada vertice adjacente a u faça
            for (int i = 0; i < u.vizinhos.size(); i++) {
                Vertice d = u.vizinhos.get(i);
                //adiciona na lista de visitados

                //calcula a distancia do vertice atual para o vertice vizinho
                int peso = 0;

                //encontra o peso da aresta entre dois vertices (u e d)
                for (int j = 0; j < u.arestas.size(); j++) {
                    if (u.arestas.get(j).origem.id == u.id && u.arestas.get(j).destino.id == d.id) {
                        peso = u.arestas.get(j).peso;
                        break;
                    }
                }

                //relaxa o vertice vizinho se a distancia dele for maior que a soma da
                // distância do vertice origem + o peso da aresta
                int distancia = u.distancia + peso;

                if(d.distancia > distancia){
                    d.distancia = distancia;
                    d.visitado = true;
                    d.pai = u;
                    S.put(d.id, d);
                }
            }

            System.out.println();
        }

        System.out.println("Shortest path");

        Vertice vertice = grafo.vertices().get(grafo.vertices().size() - 1);
        int peso = S.get(vertice.id).distancia;
        System.out.println(peso);
    }


    //Utilizando uma estrutura do tipo hashmap para facilitar na remoção dos vertices pelo ID e não pela posição
    //Se fosse com uma estrutura lista, poderia acontecer de remover um indice 3 em uma lista de tamanho 1 ocasionando
    //um crash
    public Vertice extrairMinimo() {
        Vertice menor = Q.entrySet().iterator().next().getValue();

        for (Map.Entry<Integer, Vertice> entry : Q.entrySet()) {
            Vertice prox = entry.getValue();

            if (prox.distancia < menor.distancia) {
                menor = prox;
            }
        }

        Q.remove(menor.id);
        return menor;
    }


}