### Instruções para rodar

1- Basta copiar todos os arquivos e colocar na pasta source(src) do seu projeto java

2- Em seguida basta rodar a classe Main.

3 - Você deve inserir primeiramente  o número dos casos de testes e em seguida seguir as orientações
para as entradas do exercício.


### Justificativa:

- A justificativa para escolha do algorítmo de Dijkstra para resolução do trabalho
se deu pois ele tinha uma didática melhor que ajudou no entendimento e implementação,
  além de encontrar diversas referências que ajudou a resolver o problema.

  
- Escolhi usar Java pelo motivo de ter mais domínio

### Representação utilizada:

- Utilizei uma estrutura Grafo com contém dois arrays de objetos, um para armazenar a lista de vertices e outro para
representar a lista de arestas que contém.

### Modelagem

- Na modelagem foi utilizado uma classe grafo que contém objetos do tipo Aresta e Vertice como já foi mencionado.
As `Arestas` representam as pontes e possuem como atributo `int noOrigem`, `int noDestino`, `int peso`, os vertices  
  representam os `pilares` e possuem um `ID` e a lista de adjacência, e as tabuas faltando representam os pesos nas arestas.
  
- A classe Graph_04 também contém o algorítmo de djikstra.

### Como o algorítimo resolve o problema? 

- Escolhi o algorítmo de Dijkstra pois ele resolve o problema dos caminhos mínimos
  entre todos os pares de vertices e para esse trabalho4, foi possivel calcular o custo mínimo
  entre um determinado vertice origem e seu destino. E fazendo um paralelo com o enunciado do exercicio
  calcula qual é o menor número de buracos que Pedrinho terá que pular, ou seja, quais pontes
  possuem menos tabuas faltando.
  
- Uma explicação mais específica do que cada metodo faz foi adicionada dentro da classe Graph_04.