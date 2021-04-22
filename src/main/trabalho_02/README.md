### Instruções para rodar 

1- Basta pegar os arquivos Graph.java e Main.java e coloca-los na pasta do seu projeto (src).

2- Em seguida basta rodar a classe Main.

### Justificativa: 

- Escolhi resolver o problema com a Busca em Largura (BFS).
Pelo fato de que o exercício quer saber quais são as cidades que juca pode visitar,
então podemos simplesmente gerar uma árvore com os caminhos até essas cidades.
  
- Escolhi usar Java pelo motivo de ter mais domínio do que C ou Python
  
### Representação utilizada:

- Utilizei Listas de Adjacência, uma vez que achei mais simples de utilizar no algorítimo BFS.

### Modelagem

- A modelagem é feia através da classe Graph.java que e possui uma lista de listas 
    `ArrayList<ArrayList<Integer>> adj` que representa os vertices que são adjacentes.
  
- A classe Main.java é a classe inicial e possui as validações necessárias caso
  o usuário entre com valores errados.

### Como o algorítimo resolve o problema? 

Executa a busca em largura a partir do vértice de origem L e para cada outro vértice v, com v ∈ V e v ≠ L, verificar se ele 
foi descoberto e se seu custo é menor ou igual a P. 
Caso positivo faça S = S ∪ v.
A resposta para o problema é o conjunto S.

Existe uma modificação no BFS na linha 79 até 82 (Graph.java), ela é listada abaixo:

`
    
    //Recebe como parametro a cidade onde juca está e o máximo de pedagios que ele pode pagar
    //Modificamos o BFS para atender a lógica do exercício:
    //verificar se a cidade foi descoberto e se seu custo é < P (número de pedagios) e != s (da cidade que juca está)
    //então juca pode ir nessa cidade
    if (d[u] <= P && cor[u] == PRETO && u != s) {
        S[C] = u;//atribui a cidade que juca pode viajar a lista ao conjunto S. (u representa a cidade, S o conjunto)
        Arrays.sort(S);//ordena o array em ordem alfabetica toda vez um um valor é inserido
        //apenas utilizei o quicksort já implementado no java.
        C++;//incrementa o contador do array de cidades que juca pode visitar
    }
`