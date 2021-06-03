package main.trabalho_04;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {

    public Vertice(int id) {
        this.id = id;
    }

    int id;
    int distancia;
    boolean visitado;
    Vertice pai;
    List<Vertice> vizinhos = new ArrayList<>();
    List<Aresta> arestas = new ArrayList<>();

    //calcula a quantidade de saltos entre um caminho
    int quantidadeSaltos(Vertice destino) {
        for (Aresta aresta : arestas) {
            //encontra o peso da aresta entre dois vertices
            if (aresta.origem.id == this.id && aresta.destino.id == destino.id) {
                return aresta.peso;
            }
        }
        return 0;
    }

    //anexa no vertice atual o vertice de destino
    void addAresta(Vertice destino, int distancia) {
        vizinhos.add(destino);//adiciona o vertice vizinho a lista de vizinhos
        destino.vizinhos.add(this);//Adiciona o atual como vizinho de vizinho pois tb é adjacente.

        Aresta aresta = new Aresta(this, destino, distancia);
        Aresta arestaReversa = new Aresta(destino, this, distancia);
        arestas.add(aresta);
        arestas.add(arestaReversa);
    }

    @Override
    public int compareTo(Vertice vertice) {
        if (this.distancia < vertice.distancia) return -1;
        else if (this.distancia == vertice.distancia) return 0;

        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vertice){
            Vertice vRef = (Vertice) obj;
            return this.id == vRef.id;
        }

        return false;
    }

    @Override
    public String toString() {
        String s = " ";
        s+= this.id;
        return s;
    }

}
