
import java.util.List;
import java.util.ArrayList;

public class GrafoLista {

    List<Vertice> vertices;
    List<Aresta> arestas;

    public GrafoLista() {
        vertices = new ArrayList<Vertice>();
        arestas = new ArrayList<Aresta>();
    }

    public class Vertice {
        String nome;
        List<Aresta> adj;

        Vertice(String nome) {
            this.nome = nome;
            this.adj = new ArrayList<Aresta>();
        }

        void addAdj(Aresta e) {
            adj.add(e);
        }
    }

    public class Aresta {
        Vertice origem;
        Vertice destino;

        Aresta(Vertice origem, Vertice destino) {
            this.origem = origem;
            this.destino = destino;
        }
    }


    Vertice addVertice(String nome) {
        Vertice v = new Vertice(nome);
        vertices.add(v);
        return v;
    }

    Aresta addAresta(Vertice origem, Vertice destino) {
        Aresta e = new Aresta(origem, destino);
        origem.addAdj(e);
        arestas.add(e);
        return e;
    }

     void imprimeVizinhos(){
        String r = "";

        for (Vertice u : vertices) {//itera sobre o array de indices
            r += u.nome + " -> ";

            for (Aresta e : u.adj) {//imprime os nos vizinhos do vertice atual
                Vertice v = e.destino;
                r += v.nome + ", ";
            }

            r += "\n";
        }

         System.out.println(r);
    }

}