### Executar o projeto

- O projeto foi feito em JAVA:

1 - instalar Intellij ou eclipse, Netbeans (Recomendo Intellij):
2 - Crie um novo projeto em JAVA e copia o que esta dentro de "/src" para o src do seu projeto em JAVA
(resolver os importes se for necessario)

### Estrutura do projeto - Existem 2 pacotes:

main.trabalho_01.lista
    (GrafoLista.class) - Classe que possui todas as operacoes em uma estrutura de main.trabalho_01.lista de adjacencia (Grafo nao direcionado)
    (Vertice.class) - Usado dentro de GrafoLista.class
main.trabalho_01.matriz
    (GrafoMatriz.class) -Classe que possui todas as operacoes em uma estrutura de main.trabalho_01.matriz de adjacencia (Grafo nao direcionado)

main.trabalho_01.Main.class -> Classe que executa o menu de opcoes.
Os testes sao encontrados na mesma classe main, repare que os mesmos nao sao testes unitarios.

### Da execucao do projeto:

Existem dois menus:

O primeiro menu:
Possui 4 opcoes (0,1,2,3), voce escolhe quais operacoes quer realizar (MATRIZ OU LISTA) e a terceira opcao para executar os testes
e para sair do menu a opcao (0)

Caso escolha main.trabalho_01.matriz ou main.trabalho_01.lista (op 1 ou 2) outro menu sera apresentado com TODAS as opcoes de operacoes possiveis para cada tipo de grafo.


