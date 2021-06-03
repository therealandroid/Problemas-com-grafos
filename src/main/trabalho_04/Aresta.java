package main.trabalho_04;

public class Aresta {

    public Aresta(Vertice origem, Vertice destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    Vertice origem;
    Vertice destino;
    int peso;
}
