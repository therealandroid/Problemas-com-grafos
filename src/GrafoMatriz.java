/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 * @author Diogo Jayme
 */
public class GrafoMatriz {

    private int numVertices;
    private int[][] mat;

    public GrafoMatriz(int numVertices) {
        this.numVertices = numVertices;
        mat = new int[numVertices][numVertices];
    }

    public void criaGrafoVazio() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                mat[i][j] = 0;
            }
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    //Total number of edges in a complete graph of N vertices = ( n * ( n – 1 ) ) / 2
    public int numeroArestasDoGrafoCompleto() {
        return (numVertices * (numVertices - 1)) / 2;
    }

    public void imprimeGrafo() {
        //For apenas para enumerar as colunas
        for (int i = 0; i < mat.length; i++) {
            if (i == 0) {
                System.out.print("  ");
            }
            System.out.print(i + " ");
        }

        System.out.println();

        //Inicia a impressao do grafo
        for (int i = 0; i < numVertices; i++) {
            System.out.print((i) + " ");//Essa Linha apenas enumera as linhas
            for (int j = 0; j < numVertices; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void insereAresta(int i, int j) {
        if (!existeAresta(i, j)) {
            mat[i][j] = 1;
        }
    }

    public boolean existeAresta(int i, int j) {
        if (mat[i][j] == 0)
            return false;
        else
            return true;
    }

    public void removeAresta(int i, int j) {
        if (existeAresta(i, j)) {
            mat[i][j] = 0;
        }
    }

    public int[] imprimeVizinhos(int vertice) {
        int[] vizinhos = new int[mat.length];
        int j = 0;

        //itera sobre a coluna da matriz no vertice
        for (int i = 0; i < mat.length; i++) {
            if (mat[vertice][i] == 1) {
                vizinhos[j++] = i;
            }
        }


        for (int i = 0; i < vizinhos.length;i++) {
            if(i == 0){
                System.out.print("V[" + vertice + "] ->");
            }

            if (vizinhos[i] != 0) { //nao imprime as posicoes do array que nao tem vizinhos
                System.out.print(vizinhos[i]);

                if(i < vizinhos.length - 1){
                    System.out.print(" -> ");
                }
            }
        }

        System.out.println();
        return vizinhos;
    }

    //Grau de um no/vertice e definido pela soma da linha da matriz, ou seja, pela quantidade de vertices que incidem nesse mesmo vertice [V]. Referencia: guj.com.br/t/duvida-logica/37119
    public int grau(int v) {
        int d = 0;

        //pega a linha da matriz na posicao do vertice buscado [V]
        for (int j = 0; j < mat[v].length; j++) {
            if (mat[v][j] != 0) {//Verifica todas as incidencias na linha da matriz [V] que sao diferentes de zero e soma para descobrir o grau
                d++;
            }
        }
        return d;
    }

    //Calcula o vertice com maior grau
    public int verticeComMaiorGrau() {
        int maior = 0;

        for (int i = 0; i < mat.length; i++) {
            int grauMaximo = grau(i);

            if (grauMaximo > maior) {
                maior = grauMaximo;
            }
        }

        return maior;
    }

    //calcula o vertice com menor grau
    public int verticeComMenorGrau() {
        int menor = 0;

        for (int i = 0; i < mat.length; i++) {
            int grauMaximo = grau(i);
            if (grauMaximo < menor) {
                menor = grauMaximo;
            }
        }

        return menor;
    }

    //Retorna o grau maximo do Grafo
    public int grauMax() {
        int d = 0;

        //pega a linha da matriz na posicao do vertice buscado [V]
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != 0) {//Verifica todas as incidencias na linha da matriz [V] que sao diferentes de zero e soma o total para descobrir o grau
                    d++;
                }
            }
        }

        return d;
    }

    //Retorna o grau minimo do Grafo
    //O Grau minimo de um grafo e determinado se caso o mesmo n tenha muitas incidencias
    public int grauMin() {
        int d = 0;

        //pega a linha da matriz na posicao do vertice buscado [V]
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] == 0) {//Verifica todas as incidencias na linha da matriz [V] que sao diferentes de zero e soma para descobrir o grau
                    d++;
                }
            }
        }

        return d;
    }

    //I Um grafo e completo se todos os v´ertices tiverem aresta
    //ligando a todos os outros v´ertices
    public void criaGrafoCompleto() {

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                //ignore self loops
                if (i != j) {
                    mat[i][j] = 1;
                }
            }
        }

    }

    //Grafo ciclo e um grafo onde os caminhos (v0,v1,v2,vk) formam um ciclo se v0 = vk
    public void criaGrafoCiclo() {
        if (numVertices < 3) {
            System.out.println("O grafo ciclo precisa ter um tamanho minimo de 3");
        }

        //cria um caminho circular em um grafo simples de tamanho N
        //foi o unico jeito que consegui criar um ciclo em um grafo de tamanho variavel
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {//ignore self loops
                    if (i == 0) {//preenche a primeira linha com 1
                        mat[i][j] = 1;
                    } else if (j == 0 || j == (mat.length - 1)) {//preenche a primeira coluna e ultima coluna com 1
                        mat[i][j] = 1;
                    } else if (i == mat.length - 1) {//preenche a ultima linha com 1
                        mat[i][j] = 1;
                    } else {
                        mat[i][j] = 0;//preenche o restante dos vertices sem caminho
                    }
                } else {
                    mat[i][j] = 0;//preenche o restante dos vertices sem caminho
                }
            }
        }
    }

    public void criaGrafoCaminho(int V) {

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i % 2 == 0) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = 0;
                }
            }
        }
    }

    public void criaGrafoAleatorio() {
        Random random = new Random();

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {//ignore self loops
                    mat[i][j] = random.nextInt(2);
                }
            }
        }
    }

}
