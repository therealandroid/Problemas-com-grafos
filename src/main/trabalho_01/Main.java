package main.trabalho_01;

import main.trabalho_01.lista.GrafoLista;
import main.trabalho_01.matriz.GrafoMatriz;

import java.util.Scanner;
/**
 * @author Diogo Jayme
 */
public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        main.showMainMenu();
    }

    void showMainMenu() {
        int menu = menuPrincipal();

        while (menu != 0) {
            if (menu == 1) {
                operacoesEmMatrizes();
            } else if (menu == 2) {
                operacoesEmListas();
            } else if (menu == 3) {
                executaTestes();
            } else {
                System.out.println("Opcao invalida, escolha outra opcao no menu:");
            }

            menu = menuPrincipal();
        }
    }

    void operacoesEmMatrizes() {
        int opMatriz = menuOperacoes("MATRIZ");

        int x, y;
        GrafoMatriz grafoMatriz = null;
        Scanner scanner = new Scanner(System.in);

        while (opMatriz != 0) {

            switch (opMatriz) {
                case 1:
                    System.out.println("Digite o tamanho do grafo, ex: 10");
                    int size = scanner.nextInt();
                    grafoMatriz = new GrafoMatriz(size);
                    grafoMatriz.criaGrafoVazio();
                    System.out.println("Grafo vazio criado!");
                    break;
                case 2:
                    if (grafoMatriz == null) {
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Inserir aresta entre vertices: (x, y)");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    grafoMatriz.insereAresta(x, y);
                    System.out.println("main.trabalho_01.lista.Aresta inserida:" + x + "-" + y);
                    break;
                case 3:
                    if (grafoMatriz == null) {
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Digite as arestas (x,y):");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    grafoMatriz.removeAresta(x, y);
                    System.out.println("main.trabalho_01.lista.Aresta removida:" + x + "-" + y);
                    break;
                case 4:
                    if (grafoMatriz == null) {
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Digite as arestas (x,y):");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    boolean existe = grafoMatriz.existeAresta(x, y);

                    if (existe) {
                        System.out.println("\nmain.trabalho_01.lista.Aresta : " + x + "-" + y + " existe");
                    } else {
                        System.out.println("\nmain.trabalho_01.lista.Aresta : " + x + "-" + y + " nao encontrada");
                    }

                    break;
                case 5:
                    if (grafoMatriz == null) {
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Imprimindo grafo:");
                    grafoMatriz.imprimeGrafo();
                    break;
                case 6:
                    if (grafoMatriz == null) {
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Imprimindo vizinhos:");
                    System.out.println("Digite o vertice:");
                    x = scanner.nextInt();
                    grafoMatriz.imprimeVizinhos(x);
                    break;
                case 7:
                    if (grafoMatriz == null) {
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Graus do vertice:");
                    System.out.println("Digite o vertice:");
                    x = scanner.nextInt();
                    grafoMatriz.grau(x);
                    break;
                case 8:
                    System.out.println("Digite o tamanho do grafo:");
                    x = scanner.nextInt();
                    System.out.println("Gerando grafo COMPLETO:" + x + "-" + x);
                    GrafoMatriz COMPLETO = new GrafoMatriz(x);
                    COMPLETO.criaGrafoCompleto();
                    COMPLETO.imprimeGrafo();
                    break;
                case 9:
                    System.out.println("Digite o tamanho do grafo:");
                    x = scanner.nextInt();
                    System.out.println("Gerando grafo CICLO:" + x + "-" + x);
                    GrafoMatriz CICLO = new GrafoMatriz(x);
                    CICLO.criaGrafoCiclo();
                    CICLO.imprimeGrafo();
                    break;
                case 10:
                    System.out.println("Digite o tamanho do grafo:");
                    x = scanner.nextInt();
                    System.out.println("Gerando grafo CAMINHO:" + x + "-" + x);
                    GrafoMatriz CAMINHO = new GrafoMatriz(x);
                    CAMINHO.criaGrafoCaminho(x);
                    CAMINHO.imprimeGrafo();
                    break;
                case 11:
                    System.out.println("Digite o tamanho do grafo:");
                    x = scanner.nextInt();
                    System.out.println("Gerando grafo ALEATORIO:" + x + "-" + x);
                    GrafoMatriz ALEATORIO = new GrafoMatriz(x);
                    ALEATORIO.criaGrafoAleatorio();
                    ALEATORIO.imprimeGrafo();
                    break;
            }

            opMatriz = menuOperacoes("MATRIZ");
        }
    }

    void operacoesEmListas() {
        int opListas = menuOperacoes("LISTAS");
        GrafoLista grafoLista = new GrafoLista();
        Scanner scanner = new Scanner(System.in);

        while (opListas != 0) {
            switch (opListas) {
                case 1:
                    System.out.println("Digite o tamanho do grafo: ex 10");
                    int tamanho = scanner.nextInt();
                    grafoLista.criaGrafoVazio();

                    System.out.println("Entre com os valores dos vertices ex (A B C D E F G) ou (1 2 3 4 5 6 7) ");

                    for (int i = 0; i < tamanho; i++) {
                        String key = scanner.next();
                        grafoLista.insereVertice(key);
                    }

                    System.out.println("Grafo main.trabalho_01.lista criado!");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Inserir aresta (ex: A -> B)");

                    if (grafoLista.grafoLista.size() <= 1) {
                        System.out.println("Por favor insira pelo menos dois vertices (opcao 1)");
                    } else {
                        System.out.println("Vertice origem:");
                        String v1Name = scanner.next();
                        System.out.println("Vertice destino:");
                        String v2Name = scanner.next();

                        grafoLista.insereAresta(v1Name, v2Name);
                        System.out.println("Aresta inserida entre '" + v1Name + " e " + v2Name + "'");
                    }

                    break;
                case 3:
                    System.out.println("Remove aresta");
                    System.out.println("Vertice origem:");
                    String v1 = scanner.next();
                    System.out.println("Vertice destino:");
                    String v2 = scanner.next();
                    grafoLista.removeAresta(v1, v2);
                    System.out.println("Arestas removidas");
                    break;
                case 4:
                    System.out.println("Verifica se existe aresta:");
                    System.out.println("Vertice origem:");
                    String v1Name = scanner.next();
                    System.out.println("Vertice destino:");
                    String v2Name = scanner.next();
                    int index = grafoLista.existeAresta(v1Name, v2Name);

                    System.out.println(index != -1 ? "Existe aresta" : "Nao existe aresta");
                    break;
                case 5:
                    grafoLista.imprimeGrafo();
                    break;
                case 6:
                    System.out.println("Lisar os vizinhos do vertice:");
                    String vertice = scanner.next();
                    grafoLista.listarVizinhos(vertice);
                    break;
                case 7:
                    System.out.println("Grau do vertice:");
                    String gVertice = scanner.next();
                    grafoLista.grauVertice(gVertice);
                    break;
                case 8:
                    System.out.println("Gerar grafo completo:");
                    System.out.println("Digite o tamanho:");
                    int size = scanner.nextInt();
                    GrafoLista L_COMPLETO = new GrafoLista();
                    L_COMPLETO.criarGrafoCompleto(size);
                    break;
                case 9:
                    System.out.println("Gerar grafo ciclo:");
                    System.out.println("Digite o tamanho:");
                    int k = scanner.nextInt();
                    GrafoLista L_CICLO = new GrafoLista();
                    L_CICLO.criarGrafoCiclo(k);
                    break;
                case 10:
                    System.out.println("Gerar grafo caminho:");
                    System.out.println("Digite o tamanho:");
                    int x = scanner.nextInt();
                    GrafoLista L_CAMINHO = new GrafoLista();
                    L_CAMINHO.criarGrafoCaminho(x);
                    break;
                case 11:
                    System.out.println("Gerar grafo aleatorio:");
                    System.out.println("Digite o tamanho:");
                    int y = scanner.nextInt();
                    GrafoLista L_ALEATORIO = new GrafoLista();
                    L_ALEATORIO.criarGrafoAleatorio(y);
                    break;
            }

            opListas = menuOperacoes("LISTAS");
        }
    }

    int menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--==Operacoes em grafos==--");
        System.out.println("0 - sair (0):");
        System.out.println("1 - Operacao em MATRIZ de adjacencia (1):");
        System.out.println("2 - Operacao em LISTA de adjacencia (2):");
        System.out.println("3 - Executar testes:");
        return scanner.nextInt();
    }

    int menuOperacoes(String menuType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("--== Operacoes (" + menuType + ")==--");
        System.out.println("1 - Criar um grafo vazio");
        System.out.println("2 - Inserir aresta");
        System.out.println("3 - Remover aresta");
        System.out.println("4 - Verificar se existe aresta");
        System.out.println("5 - Imprimir grafo");
        System.out.println("6 - Listar vizinhos de um determinado vertice");
        System.out.println("7 - Encontrar o grau de um determinado vertice");
        System.out.println("8 - Criar um grafo completo");
        System.out.println("9 - Criar um grafo ciclo");
        System.out.println("10 - Criar um grafo caminho");
        System.out.println("11 - Criar um grafo aleatorio");
        System.out.println("0 - voltar ao menu anterior");
        System.out.println();
        return scanner.nextInt();
    }

    /**
     * Executa os testes referentes a questao 4
     */
    void executaTestes() {
        //a) b)

        //imprime o numero de arestas de cada grafo
        GrafoMatriz K_10 = new GrafoMatriz(10);
        K_10.criaGrafoCompleto();
        GrafoMatriz K_100 = new GrafoMatriz(100);
        K_100.criaGrafoCompleto();
        GrafoMatriz K_1000 = new GrafoMatriz(1000);
        K_1000.criaGrafoCompleto();
        System.out.println("Grafos completos criados com sucesso!");
        System.out.println("Numero de arestas do grafo K_10 = " + K_10.numeroArestasDoGrafoCompleto());
        System.out.println("Numero de arestas do grafo K_100 = " + K_100.numeroArestasDoGrafoCompleto());
        System.out.println("Numero de arestas do grafo K_100 = " + K_1000.numeroArestasDoGrafoCompleto());
        System.out.println();

        //inicio (c, d)
        System.out.println("--Lista de adjacencia--");

        System.out.println("Grafo Caminho");
        GrafoLista L_CAMINHO = new GrafoLista();
        L_CAMINHO.generateList();//cria uma main.trabalho_01.lista com 10 vertices
        L_CAMINHO.insereAresta("A", "B");
        L_CAMINHO.insereAresta("A", "C");
        L_CAMINHO.insereAresta("A", "D");
        L_CAMINHO.insereAresta("A", "E");
        L_CAMINHO.insereAresta("A", "F");
        L_CAMINHO.insereAresta("A", "G");
        L_CAMINHO.insereAresta("A", "H");
        L_CAMINHO.insereAresta("A", "I");
        L_CAMINHO.imprimeGrafo();

        System.out.println("Grafo ciclo");
        GrafoLista L_CICLO = new GrafoLista();
        L_CICLO.generateList();//cria uma main.trabalho_01.lista com 10 vertices
        L_CICLO.insereAresta("A", "B");
        L_CICLO.insereAresta("B", "C");
        L_CICLO.insereAresta("C", "D");
        L_CICLO.insereAresta("D", "E");
        L_CICLO.insereAresta("E", "F");
        L_CICLO.insereAresta("F", "G");
        L_CICLO.insereAresta("G", "H");
        L_CICLO.insereAresta("H", "I");
        L_CICLO.insereAresta("I", "J");
        L_CICLO.insereAresta("J", "A");
        L_CICLO.imprimeGrafo();

        //fim (c, d)

        //cria um grafo aleatorio G 10
        GrafoMatriz G_RANDOM = new GrafoMatriz(10);
        G_RANDOM.criaGrafoAleatorio();
        System.out.println("Grafo G_10 aleatorio criado com sucesso!");
        //Imprime grafo aleatorio
        G_RANDOM.imprimeGrafo();
        System.out.println();
        //Imprime o grau maximo do grafo G_10 aleatorio
        int grauMaximo = G_RANDOM.grauMax();
        int verticeComMaiorGrau = G_RANDOM.verticeComMaiorGrau();
        System.out.println("O grafo aleatorio possui grau maximo:" + grauMaximo);
        System.out.println("O vertice de maior grau e :" + verticeComMaiorGrau);
        System.out.println();

        //Imprime o grau minmo do grafo G_10 aleatorio
        System.out.println();
        int grauMinimo = G_RANDOM.grauMin();
        int verticeComMenorGrau = G_RANDOM.verticeComMenorGrau();
        System.out.println("O grafo aleatorio possui grau minimo:" + grauMinimo);
        System.out.println("O vertice de menor grau e :" + verticeComMenorGrau);
        System.out.println();
    }

}





