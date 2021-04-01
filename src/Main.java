import java.util.Scanner;

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
                menuOperacoes("LISTA");
            } else if (menu == 3) {
                executaTestes();
            } else {
                System.out.println("Opcao invalida, escolha outra opcao no menu:");
            }

            menu = menuPrincipal();
        }
    }

    void operacoesEmMatrizes(){
        int opMatriz = menuOperacoes("MATRIZ");

        int x, y;
        GrafoMatriz grafoMatriz = null;
        Scanner scanner = new Scanner(System.in);

        while(opMatriz != 0){

            switch (opMatriz){
                case 1:
                    System.out.println("Digite o tamanho do grafo, ex: 10");
                    int size = scanner.nextInt();
                    grafoMatriz = new GrafoMatriz(size);
                    grafoMatriz.criaGrafoVazio();
                    System.out.println("Grafo vazio criado!");
                    break;
                case 2:
                    if(grafoMatriz == null){
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Inserir aresta entre vertices: (x, y)");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    grafoMatriz.insereAresta(x, y);
                    System.out.println("Aresta inserida:" + x +"-"+ y);
                    break;
                case 3:
                    if(grafoMatriz == null){
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Digite as arestas (x,y):");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    grafoMatriz.removeAresta(x, y);
                    System.out.println("Aresta removida:" + x +"-"+ y);
                    break;
                case 4:
                    if(grafoMatriz == null){
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Digite as arestas (x,y):");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    boolean existe = grafoMatriz.existeAresta(x, y);

                    if(existe){
                        System.out.println("\nAresta : " + x +"-"+ y + " existe");
                    }else{
                        System.out.println("\nAresta : " + x +"-"+ y + " nao encontrada");
                    }

                    break;
                case 5:
                    if(grafoMatriz == null){
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Imprimindo grafo:");
                    grafoMatriz.imprimeGrafo();
                    break;
                case 6:
                    if(grafoMatriz == null){
                        System.out.println("Primeiro inicialize o grafo na opcao 1.");
                        return;
                    }
                    System.out.println("Imprimindo vizinhos:");
                    System.out.println("Digite o vertice:");
                    x = scanner.nextInt();
                    grafoMatriz.imprimeVizinhos(x);
                    break;
                case 7:
                    if(grafoMatriz == null){
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
        //a)

        //imprime o numero de arestas de cada grafo
        GrafoMatriz K_10 = new GrafoMatriz(10);
        K_10.criaGrafoCompleto();
        GrafoMatriz K_100 = new GrafoMatriz(100);
        K_100.criaGrafoCompleto();
        GrafoMatriz K_1000 = new GrafoMatriz(1000);
        K_1000.criaGrafoCompleto();

        //(b)
        System.out.println("Grafos completos criados com sucesso!");

        //TODO imprimir as arestas
        //inicio (c, d)
        GrafoLista C_10 = new GrafoLista();
        GrafoLista P_10 = new GrafoLista();

        GrafoLista.Vertice a = C_10.addVertice("a");
        GrafoLista.Vertice b = C_10.addVertice("b");
        GrafoLista.Vertice c = C_10.addVertice("c");
        GrafoLista.Vertice d = C_10.addVertice("d");
        GrafoLista.Vertice e = C_10.addVertice("e");
        GrafoLista.Vertice f = C_10.addVertice("f");
        GrafoLista.Vertice g = C_10.addVertice("g");
        GrafoLista.Vertice h = C_10.addVertice("h");
        GrafoLista.Vertice i = C_10.addVertice("i");
        GrafoLista.Vertice j = C_10.addVertice("j");

        C_10.addAresta(a, b);
        C_10.addAresta(c, d);
        C_10.addAresta(d, e);
        C_10.addAresta(f, g);
        C_10.addAresta(h, i);
        C_10.addAresta(i, j);
        C_10.addAresta(j, a);

        C_10.addAresta(a, d);
        C_10.addAresta(c, h);
        C_10.addAresta(c, i);

        //Cria um grafo caminho
        GrafoLista.Vertice xx = P_10.addVertice("a");
        GrafoLista.Vertice bb = P_10.addVertice("b");
        GrafoLista.Vertice ee = P_10.addVertice("e");
        GrafoLista.Vertice ff = P_10.addVertice("f");
        GrafoLista.Vertice gg = P_10.addVertice("g");
        GrafoLista.Vertice ii = P_10.addVertice("i");
        GrafoLista.Vertice jj = P_10.addVertice("j");

        P_10.addAresta(xx, bb);
        P_10.addAresta(bb, ee);
        P_10.addAresta(ee, ff);
        P_10.addAresta(gg, ii);
        P_10.addAresta(ii, jj);

        System.out.println("Grafo caminho (vizinhanca):");
        C_10.imprimeVizinhos();
        System.out.println("Grafo ciclo (vizinhanca):");
        P_10.imprimeVizinhos();
         System.out.println();
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



