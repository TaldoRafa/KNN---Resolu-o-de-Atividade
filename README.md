# IDENTIFICAÇÃO DO TIPO DE PROTEÍNA COM ALGORITMO KNN EM JAVA

Nesta atividade, foi utilizado o algoritmo K-vizinhos mais próximos (KNN), implementado em Java, para identificar o tipo de proteína faltante em um lanche. A previsão foi feita com base em atributos qualitativos convertidos para valores numéricos. O algoritmo aplicou a fórmula da distância euclidiana para os valores de K = 1, K = 3 e K = 5, a fim de determinar o vizinho ou vizinhos mais próximos e, assim, prever a proteína.

## 1 - LEITURA E PREPARAÇÃO DOS DADOS

O primeiro passo foi a leitura dos dados a partir de um arquivo .xlsx que continha informações sobre diversos lanches, incluindo tipo de pão, tipo de queijo, vegetais, tipo de molho e tipo de proteína. Utilizando a biblioteca Apache POI, os dados foram carregados e convertidos para objetos de uma classe Java chamada Snack, onde cada atributo foi representado como um Enum. Um dos lanches no arquivo apresentava o valor da proteína faltando, e o objetivo era prever essa proteína com base nos outros atributos (pão, queijo, vegetais e molho), comparando com os demais lanches.

## 2 - CONVERSÃO DOS DADOS QUALITATIVOS PARA ESCALAS NUMÉRICAS

Para possibilitar o cálculo da distância entre os lanches, foi necessário converter os atributos qualitativos (como tipo de pão, tipo de queijo, etc.) em valores numéricos. Cada atributo foi mapeado para uma escala entre 0 e 1, de acordo com o número de categorias presentes em cada conjunto de dados. Assim, todos os atributos passaram a ter uma representação numérica uniforme, permitindo o uso da fórmula da distância euclidiana. Isso garantiu que os cálculos fossem consistentes, independentemente da natureza qualitativa dos dados originais.

## 3 - CÁLCULO DA DISTÂNCIA EUCLIDIANA

O algoritmo KNN utiliza a fórmula da distância euclidiana para medir a proximidade entre os diferentes lanches. A distância euclidiana é calculada a partir da soma das diferenças quadradas entre os valores numéricos de atributos correspondentes de dois lanches, conforme a fórmula:

Neste caso, Xi e Yi são os valores numéricos dos atributos dos dois lanches, como tipo de pão, tipo de queijo, etc. A distância calculada indica o quão próximos (ou distantes) os lanches estão uns dos outros com base nos seus atributos conhecidos.

## 4 - APLICAÇÃO DO ALGORITMO KNN

Uma vez calculadas as distâncias entre o lanche com a proteína faltante e todos os outros lanches, o próximo passo foi determinar os K vizinhos mais próximos. Para os valores de K = 1, K = 3 e K = 5, o algoritmo identificou os lanches com menor distância e utilizou o tipo de proteína desses vizinhos para prever o valor faltante.

- K = 1: O vizinho mais próximo foi selecionado, e o tipo de proteína desse lanche foi atribuído ao lanche com a informação faltante.
- K = 3: Os três vizinhos mais próximos foram considerados, e o tipo de proteína mais frequente entre eles foi atribuído ao lanche.
- K = 5: O mesmo processo foi repetido com os cinco vizinhos mais próximos.

## 5 - RESULTADOS

Após a aplicação do KNN com os valores de K = 1, 3 e 5, a previsão para o tipo de proteína foi concluída. Em todos os casos, o tipo de proteína mais frequente entre os vizinhos mais próximos foi Frango, o que indica que essa é a proteína que melhor preenche a lacuna no lanche em questão.

## 6 - FERRAMENTAS UTILIZADAS

- **Java**: A linguagem de programação utilizada para implementar o algoritmo e manipular os dados.
- **Biblioteca Apache POI**: Usada para leitura e manipulação dos dados contidos no arquivo Excel.
- **Enums**: Para converter os atributos qualitativos dos lanches em valores numéricos em uma escala de 0 a 1.
- **Distância Euclidiana**: A fórmula matemática aplicada para medir a similaridade entre os lanches.
- **Algoritmo KNN**: Para identificar os vizinhos mais próximos e prever o tipo de proteína faltante.

O processo garantiu que a previsão foi feita com base em dados consistentes e usando uma técnica comprovada de classificação. O resultado, em todos os casos, apontou que a proteína mais adequada para o lanche em questão é Frango.
