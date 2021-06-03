package main.trabalho_04;

import java.util.Scanner;

public class DijkstraAdjacencyMatrix {

    static class Graph {
        int vertices;
        int matrix[][];

        public Graph(int vertex) {
            this.vertices = vertex;
            matrix = new int[vertex][vertex];
        }

        public void addEdge(int source, int destination, int weight) {
            matrix[source][destination] = weight;
            matrix[destination][source] = weight;
        }

        //get the vertex with minimum distance which is not included in SPT
        int getMinimumVertex(boolean[] mst, int[] key) {
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;

            for (int i = 0; i < vertices; i++) {
                if (!mst[i] && minKey > key[i]) {
                    minKey = key[i];
                    vertex = i;
                }
            }

            return vertex;
        }

        public void dijkstra_GetMinDistances(int sourceVertex) {
            boolean[] spt = new boolean[vertices];
            int[] distance = new int[vertices];
            int INFINITY = Integer.MAX_VALUE;

            //Initialize all the distance to infinity
            for (int i = 0; i < vertices; i++) {
                distance[i] = INFINITY;
            }

            //start from the vertex 0
            distance[sourceVertex] = 0;

            //create SPT
            for (int i = 0; i < vertices; i++) {

                //get the vertex with the minimum distance
                int vertex_U = getMinimumVertex(spt, distance);

                //include this vertex in SPT
                spt[vertex_U] = true;

                //iterate through all the adjacent vertices of above vertex and update the keys
                for (int vertex_V = 0; vertex_V < vertices; vertex_V++) {
                    //check of the edge between vertex_U and vertex_V
                    if (matrix[vertex_U][vertex_V] > 0) {
                        //check if this vertex 'vertex_V' already in spt and
                        // if distance[vertex_V]!=Infinity

                        if (spt[vertex_V] == false && matrix[vertex_U][vertex_V] != INFINITY) {
                            //check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance

                            int newKey = matrix[vertex_U][vertex_V] + distance[vertex_U];

                            if (newKey < distance[vertex_V])
                                distance[vertex_V] = newKey;
                        }
                    }
                }
            }
            //print shortest path tree
            printDijkstra(sourceVertex, distance);
        }

        public void printDijkstra(int sourceVertex, int[] key) {
            System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");

            System.out.println(key[key.length-1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();


        Graph graph = new Graph(N + 2);
        int sourceVertex = 0;

        //insere as arestas (PONTES)
        for (int i = 0; i < M; i++) {
            int S = scanner.nextInt();
            int T = scanner.nextInt();
            int B = scanner.nextInt();

            graph.addEdge(S, T, B);
        }

        graph.dijkstra_GetMinDistances(sourceVertex);
    }
}