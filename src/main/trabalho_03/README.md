### Instruções para rodar

1- Basta pegar os arquivos Graph.java e Main.java e coloca-los na pasta do seu projeto (src).

2- Em seguida basta rodar a classe Main.

3 - Você deve inserir primeiramente  o número dos casos de testes e em seguida seguir as orientações
para as entradas do exercício.


### Justificativa:

- Após gastar aproximadamente 1 semana tentando implementar o algorítmo de kruskal,
decidi usar uma abordagem mais simples utilizando o conceito de arvores geradoras (como falamos
  no forum e até então não sabia que estava seguindo esse conceito.) Após
  encontrar uma explicação que encontrei no `stackoverflow`, comecei a utilizar como
  referência e consegui concluir a atividade. 
  
- Escolhi usar Java pelo motivo de ter mais domínio

### Representação utilizada:

- Utilizei Listas de Adjacência, que representei através de um array de 3 posições, conforme
melhor explicado na sessão abaixo.

### Modelagem
- A modelagem é feita através da classe `Graph.java`.  Para esse exercício, utilizei um 
  array `int[][3] arestas` com 3 posições para representar as estrutras de `arestas`, com vertice `origem`, `destino` e `peso`, respectivamente, 
  mas poderia ter utilizado também uma estrutura de Lista de objeto Aresta contendo esses mesmos atributos, optei por essa opção pela simplicidade.
  
- Uma lista `Q` mantém a arvore geradora, mas só é utilizada para calculo dos próximos vertices.
- Um array `boolean[] vertices` mantém a ordem dos vertices já visitados.

### Como o algorítimo resolve o problema? (sem utilizar prim e kruskal)

O algorítmo resolve o problema pois ele consegue gerar uma arvore de custo mínimo.

A execução do algorítimo é feita da seguinte forma:

1 - Uma lista secundária, `int[][] arestas` (linha 91) é criada para manter a lista de arestas a partir
do vertice de caminho mínimo encontrado (ele é encontrado sempre que `buscaCaminhoMinimo` (linha 55) é executado.
Ela serve para comparar com as outras arestas adjacentes  sempre que o método `comparaArestasAdjacentes` (linha 32)  é execudato.

2 - Após essa etapa ser executada, o algorítmo de caminho mínimo `buscaCaminhoMinimo(arr[][])` é executado para retornar
o array com os vertices de menor caminho e salva o próximo vertice para ser buscado na próxima iteração (após imprimir o primeiro caminho mais curto) e
então é adicionado na arvore `Q`

3 - Em seguida, o array `vertices` é marcado com visitado após ter sido encontrado. Esse array
é utilizado no método `comparaArestasAdjacentes` para evitar que adicione arestas para comparação
caso o vertice já tenha sido visitado alguma vez.

4 - Por fim, a iteração do primeiro caminho mais curto é finalizada e a lista auxiliar
que armazena as `arestas` criadas para comparação são limpas para adicionar as próximas
arestas para comparação do próximo caminho mais curto.

5 - Imprime os menores caminhos.
