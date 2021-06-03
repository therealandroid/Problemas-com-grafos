package main.trabalho_04_2;

import java.util.ArrayList;

public class Graph_04 {

    public Vertice[] vertices;
    public Aresta[] arestas;

    public Graph_04(Aresta[] arestas, Vertice[] vertices) {
        this.vertices = vertices;
        this.arestas = arestas;

        //Adicione todas as arestas aos nós. Cada aresta é adicionada a 2 nós (origem e destino) pois o grafo
        //nao e direcionado
        populaArestas();
    }

    public void populaArestas() {
        for (Aresta aresta : arestas) {
            vertices[aresta.noOrigem].arestas.add(aresta);
            vertices[aresta.noDestino].arestas.add(aresta);
        }
    }

    public int executaDijkstra() {
        //Vertice inicial recebe distância 0
        vertices[0].distancia = 0;
        //proximo vertice = inicial
        int proximoVertice = 0;

        // Itera sobre todos os vertices
        for (int i = 0; i < vertices.length; i++) {

            //pega todas as arestas adjacentes ao vertice atual (proximoVertice)
            ArrayList<Aresta> arestasAdjacentes = vertices[proximoVertice].arestas;

            //Para cada aresta adjacente ao vertice atual faça
            for (Aresta aresta : arestasAdjacentes) {
                // encontra o vertice vizinho de uma aresta entre dois vertices (u e d)
                int vizinho = aresta.vizinhoDe(proximoVertice);

                // Verifica se o vizinho ainda não foi visitado
                if (!vertices[vizinho].visitado) {

                    //calcula a nova distância até o proximo vertice adjacente
                    int novaDistancia = this.vertices[proximoVertice].distancia + aresta.peso;

                    // relaxa o vertice vizinho se a distancia dele for maior que a soma da
                    // distância do vertice origem + o peso da aresta
                    if (novaDistancia < vertices[vizinho].distancia) {
                        vertices[vizinho].distancia = novaDistancia;
                    }
                }

            }

            // Seta o vertice corrente como visitado uma vez que todos os nós vizinhos já foram verificados
            vertices[proximoVertice].visitado = true;

            // Atualiza o proximo vertice para ser relaxado na próxima iteração.
            // O próximo nó a visitar deve ser aquele com a distância mais curta.
            proximoVertice = extraiMinimo();
        }

        //Relaxamento finalizado
        //retorna o custo mínimo do vertice final até o vertice inicial
        return vertices[vertices.length - 1].distancia;
    }

    /*
     * Varre os nós não visitados e calcula qual deles tem a distância mais curta da fonte.
     *
     * @return O índice do nó com a menor distância
     */
    private int extraiMinimo() {
        int menor = 0;
        int distanciaMenor = Integer.MAX_VALUE;

        for (int i = 0; i < this.vertices.length; i++) {
            int distanciaAtual = this.vertices[i].distancia;

            if (!this.vertices[i].visitado && distanciaAtual < distanciaMenor) {
                distanciaMenor = distanciaAtual;
                menor = i;
            }

        }

        return menor;
    }

}