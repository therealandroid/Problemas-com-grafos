package main.trabalho_03;

import java.util.ArrayList;
import java.util.List;

class Graph {

    int totalVertices;
    int totalArestas;

    int index = 0;//serve apenas para manter o cursor na posição do array que representa as arestas (linhas)

    List<Integer> Q = new ArrayList<>();//arvore geradora

    int[][] arestas;//representa um array de arestas
    boolean[] vertices;//representa os vertices visitados

    public Graph(int N, int M) {
        totalVertices = N;
        totalArestas = M;
        vertices = new boolean[N + 1]; //Pula o indice 0 já que o programa não possui cidade 0 e evita que o programa quebre quando entrar com vertice > que o tamanho do array se pudesse começar com 0
        arestas = new int[M][3];//Uma matriz para representar a estrutura aresta
    }

    public void addAresta(int arrayPos, int origem, int destino, int peso){
        arestas[arrayPos][0] = origem; //atribui o indice do vertice inicial
        arestas[arrayPos][1] = destino; //atribui o indice do vertice final
        arestas[arrayPos][2] = peso; //atribui o comprimento da aresta
    }

    //Compara as arestas adjacentes a um determinado vertice e armazena em um array com as arestas para comparar
    private void comparaArestasAdjacentes(Object[] caminho, int[][] arestasAdjancentes) {

        for (Object o : caminho) {
            for (int j = 0; j < totalArestas; j++) {
                //Se o vertice origem da aresta for igual ao buscado e se o vertice de destino ainda não foi visitado
                //adiciona na lista de arestas adjacentes a aresta que não foi visitada
                if (arestas[j][0] == (int) o && !vertices[arestas[j][1]]) {
                    arestasAdjancentes[index][0] = arestas[j][0];
                    arestasAdjancentes[index][1] = arestas[j][1];
                    arestasAdjancentes[index][2] = arestas[j][2];
                    index++;
                    //Caso contrario escolhe o outro caminho
                } else if (arestas[j][1] == (int) o && !vertices[arestas[j][0]]) {
                    arestasAdjancentes[index][0] = arestas[j][0];
                    arestasAdjancentes[index][1] = arestas[j][1];
                    arestasAdjancentes[index][2] = arestas[j][2];
                    index++;
                }
            }
        }
    }

    //retorna um array contendo o caminho mínimo
    private int[] buscaCaminhoMinimo(int[][] arestas) {
        int[] aresta = new int[3];
        int peso = Integer.MAX_VALUE;//variavel auxiliar para guardar o menor peso dentre as arestas do caminho buscado

        //Percorre as arestas e verifica se ainda não foi visitada (peso = 0)
        for (int i = 0; i < arestas.length && arestas[i][2] != 0; i++) {
            if (arestas[i][2] < peso) { //entra na aresta de menor peso no caminho
                aresta[0] = arestas[i][0];
                aresta[1] = arestas[i][1];
                aresta[2] = arestas[i][2];
                peso = arestas[i][2];//salva o menor peso encontrado no caminho para comparar novamente com a proxima aresta
            }
        }

        return aresta;
    }

    //marca como visitado o vertice com o menor caminho
    private boolean marcaVerticeDoMenorCaminho(int[][] arestas) {
        int[] aresta = buscaCaminhoMinimo(arestas);

        //retorna "true" se o vertice inicial estiver marcado
        if (vertices[aresta[0]]) {
            vertices[aresta[1]] = true;
            return true;
        } else {
            return false;
        }
    }

    public void encontraCaminhoMinimo() {
        Q.add(1);//Representa a arvore de vertices que possuem caminho mínimo
        vertices[1] = true;//inicia o primiero como visitado

        //cria um array com 3 posições para armazenar a aresta (vertice origem, destino e peso)
        //utilizar uma estrutura do tipo List<Edge> seria mais eficiente (todo)
        int[][] arestas = new int[totalArestas * 10][3];

        for (int i = 0; i < (totalVertices - 1); i++) {
            comparaArestasAdjacentes(Q.toArray(), arestas);//cria um caminho
            int[] array = buscaCaminhoMinimo(arestas);//gera o array de caminho míninho dentre a matriz de adjacência

            imprimeMenorCaminho(array);//imprime o menor caminho
            int proximoVertice = buscaCaminhoMinimo(arestas)[1];//Salva o próximo vertice encontrado a partir da aresta de menor caminho.
            Q.add(proximoVertice);//adiciona na fila
            marcaVerticeDoMenorCaminho(arestas);//marca como visitado o vertice de menor caminho
            limpaArestasComparadas(arestas);
        }
    }

    //limpa o array de comparação para iniciar com o proximo caminho a partir do vertice encontrado anteriormente e
    //comparar com o caminho a partir do novo vertice
    private void limpaArestasComparadas(int[][] arestasAdjancentes) {
        for (int i = 0; i < arestasAdjancentes.length; i++) {
            arestasAdjancentes[i][0] = 0;
            arestasAdjancentes[i][1] = 0;
            arestasAdjancentes[i][2] = 0;
        }

        index = 0;
    }

    private void imprimeMenorCaminho(int[] arrayCaminhoMinimo) {
        //troca aresta[1] e aresta[0] de lugar deixando sempre aresta[0] < aresta[1]
        int aux;

        if (arrayCaminhoMinimo[0] > arrayCaminhoMinimo[1]) {
            aux = arrayCaminhoMinimo[0];
            arrayCaminhoMinimo[0] = arrayCaminhoMinimo[1];
            arrayCaminhoMinimo[1] = aux;
        }

        System.out.printf("%d %d\n", arrayCaminhoMinimo[0], arrayCaminhoMinimo[1]);
    }
}