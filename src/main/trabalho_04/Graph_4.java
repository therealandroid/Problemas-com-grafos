package main.trabalho_04;

import java.util.ArrayList;
import java.util.List;

public class Graph_4 {

    public List<Vertice> verticeList = new ArrayList<>();

    public List<Vertice> vertices() {
        return verticeList;
    }

    public List<Vertice> vizinhos(Vertice vertice) {
        List<Vertice> vizinhos = new ArrayList<>();

        for (Vertice value : verticeList) {
            if (vertice.id == value.id) {
                vizinhos.add(vertice);
            }
        }

        return vizinhos;
    }

    public void imprimeVizinhos(Vertice vertice) {
        for (Vertice value : verticeList) {
            if (vertice.id == value.id) {
                System.out.print("Pai[" + vertice.id + "]=>");

                for (int j = 0; j < value.vizinhos.size(); j++) {
                    String filho = value.vizinhos.get(j).id + "[" + vertice.quantidadeSaltos(value.vizinhos.get(j)) + "]";

                    if (j == value.vizinhos.size() - 1) {
                        System.out.print(filho.concat("=>FIM"));
                    } else {
                        System.out.print(filho.concat("=>"));
                    }
                }
                System.out.println();
            }
        }
    }

    public void imprimeGrafo() {
        for (Vertice vertice : verticeList) {
            for (int j = 0; j < vertice.vizinhos.size(); j++) {
                int origem = vertice.id;//nome do vertice origem
                int destino = vertice.vizinhos.get(j).id;//nome do vertice destino
                int distancia = vertice.vizinhos.get(j).quantidadeSaltos(vertice);
                String output = String.format("%s-%s[%d]", origem, destino, distancia);

                if (j == vertice.vizinhos.size() - 1) {
                    System.out.print(output);
                } else {
                    System.out.print(output + ", ");
                }

            }
            System.out.println();
        }
    }

    public Vertice encontrarVertice(int id) {
        for (Vertice vertice : verticeList) {

            if (id == vertice.id) {
                return vertice;
            }
        }
        return null;
    }
}
