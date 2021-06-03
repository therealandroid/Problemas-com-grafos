package main.trabalho_04_2;

public class Aresta {

    int noOrigem;
    int noDestino;
    int peso;

    public Aresta(int noOrigem, int noDestino, int peso) {
        this.noOrigem = noOrigem;
        this.noDestino = noDestino;
        this.peso = peso;
    }

    public int vizinhoDe(int noOrigem) {
        if (this.noOrigem == noOrigem) {
            return this.noDestino;
        } else {
            return this.noOrigem;
        }
    }

}