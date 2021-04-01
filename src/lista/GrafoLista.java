package lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrafoLista {

    public List<Vertice> grafoLista = new ArrayList<>();

    public void criaGrafoVazio() {
        grafoLista = new ArrayList<>();
    }

    public void insereVertice(String key) {
        boolean containsKey = false;

        for (int i = 0; i < grafoLista.size(); i++) {
            if (grafoLista.get(0).chave.equals(key)) {
                containsKey = true;
            }
        }

        if (!containsKey)
            grafoLista.add(new Vertice(key));
    }


    //insere uma aresta entre dois vertices (a -> b)
    public void insereAresta(String origem, String destino) {
        //verifica se a aresta NAO existe
        if (existeAresta(origem, destino) == -1) {
            for (int i = 0; i < grafoLista.size(); i++) {
                if (grafoLista.get(i).chave.equals(origem)) {
                    int finalDaLista = grafoLista.get(i).adjacentes.size();
                    grafoLista.get(i).adjacentes.add(finalDaLista, new Vertice(destino));
                    return;
                }
            }
        }
    }

    public void removeAresta(String origem, String destino) {
        for (int i = 0; i < grafoLista.size(); i++) {
            if (grafoLista.get(i).chave.equals(origem)) {
                for (int j = 0; j < grafoLista.get(i).adjacentes.size(); j++) {
                    if (grafoLista.get(i).adjacentes.get(j).chave.equals(destino)) {
                        grafoLista.get(i).adjacentes.remove(j);
                    }
                }
            }
        }
    }

    public int existeAresta(String origem, String destino) {

        int index = -1;//retorna -1 se nao encontrar aresta

        for (int i = 0; i < grafoLista.size(); i++) {
            if (grafoLista.get(i).chave.equals(origem)) {
                for (int j = 0; j < grafoLista.get(i).adjacentes.size(); j++) {
                    if (grafoLista.get(i).adjacentes.get(j).chave.equals(destino)) {
                        return j;//retorna o indice que encontrou
                    }
                }
            }
        }

        return index;
    }

    public void imprimeGrafo() {
        for (int i = 0; i < grafoLista.size(); i++) {
            System.out.print(grafoLista.get(i).chave + "->");

            for (int j = 0; j < grafoLista.get(i).adjacentes.size(); j++) {
                System.out.print(grafoLista.get(i).adjacentes.get(j).chave);
                if (j < grafoLista.get(i).adjacentes.size() - 1) {
                    System.out.print("->");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void listarVizinhos(String V) {
        for (int i = 0; i < grafoLista.size(); i++) {
            if (grafoLista.get(i).chave.equals(V)) {//imprime somente os vizinhos de V
                System.out.print(grafoLista.get(i).chave + "->");

                for (int j = 0; j < grafoLista.get(i).adjacentes.size(); j++) {
                    System.out.print(grafoLista.get(i).adjacentes.get(j).chave);
                    if (j < grafoLista.get(i).adjacentes.size() - 1) {
                        System.out.print("->");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public int grauVertice(String V) {
        for (int i = 0; i < grafoLista.size(); i++) {
            if (grafoLista.get(i).chave.equals(V)) {//imprime somente os vizinhos de V
                return grafoLista.get(i).adjacentes.size();
            }
        }
        return 0;
    }


    public void criarGrafoCompleto(int size) {
        criaGrafoVazio();

        //inicializa vertices automaticamente
        for (int i = 0; i < size; i++) {
            grafoLista.add(new Vertice(i + ""));
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i != j){//evita self loops
                    grafoLista.get(i).adjacentes.add(new Vertice(j + ""));
                }
            }
        }

        imprimeGrafo();
    }

    public void criarGrafoCiclo(int size) {
        criaGrafoVazio();

        //inicializa vertices automaticamente
        for (int i = 0; i < size; i++) {
            grafoLista.add(new Vertice(i + ""));
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i != j){//evita self loops
                    grafoLista.get(i).adjacentes.add(new Vertice(j + ""));
                }

                if(j == size -1){//adiciona o ultimo no como referencia pro primeiro
                    grafoLista.get(i).adjacentes.add(grafoLista.get(i));
                }
            }
        }

        imprimeGrafo();
    }

    public void criarGrafoCaminho(int size) {
        criaGrafoVazio();

        //inicializa vertices automaticamente
        for (int i = 0; i < size; i++) {
            grafoLista.add(new Vertice(i + ""));
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i != j){//evita self loops
                    grafoLista.get(i).adjacentes.add(new Vertice(j + ""));
                }
            }
        }

        imprimeGrafo();
    }

    public void criarGrafoAleatorio(int size) {
        criaGrafoVazio();
        Random random = new Random();

        //inicializa vertices automaticamente
        for (int i = 0; i < size; i++) {
            grafoLista.add(new Vertice(random.nextInt(size) + ""));
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i != j){//evita self loops
                    grafoLista.get(i).adjacentes.add(new Vertice(random.nextInt(size) + "" + ""));
                }
            }
        }

        imprimeGrafo();
    }

    public void generateList() {
        Vertice a = new Vertice("A");
        Vertice b = new Vertice("B");
        Vertice c = new Vertice("C");
        Vertice d = new Vertice("D");
        Vertice e = new Vertice("E");
        Vertice f = new Vertice("F");
        Vertice g = new Vertice("G");
        Vertice h = new Vertice("H");
        Vertice i = new Vertice("I");
        Vertice j = new Vertice("J");

        grafoLista.add(a);
        grafoLista.add(b);
        grafoLista.add(c);
        grafoLista.add(d);
        grafoLista.add(e);
        grafoLista.add(f);
        grafoLista.add(g);
        grafoLista.add(h);
        grafoLista.add(i);
        grafoLista.add(j);
    }

}

