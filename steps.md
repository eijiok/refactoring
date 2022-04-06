1. Impressões: 
    1. Muitas coisas fazendo em um único método
    2. Algumas coisas tinham que ser feitas em outras classes

2. Programa funciona, mas difícil de manter.

3. Se fosse imprimir em HTML? Como faríamos?
    1. Copiar e colar seria a escolha mais fácil.
        1. Se copiar e colar e garantir que o programa não vai mudar, ok.
        2. Mas se mudar, vai sofrer.

4. Mudanças vão acontecer, cedo ou tarde.

Dica:
"Quando você tem que adicionar uma funcionalidade no código, 
e o códiog não está estruturado de forma conviente para adicionar a funcionalidade, 
primeiro refatore o código para deixá-lo fácil de adicioar a funcionalidade,
 e então adicione a funcionalidade."

 Passos:
 1. Tenha um conjunto de testes sólido

 2. Extrair methodo: switch  --------> método: amountFor
    1. Variáveis: thisAmount e each. Se tem só uma variável modificada, fácil. Caso contrário teria que fazer montar um objeto. Talvez não seja o melhor caso.


Dica: 
Refatore em pequenos passos. Se cometer um erro, vai ser fácil de encontrá-lo.

3. Rename Variable:  each -> aRental   amount -> result

Dica:
Qualquer todo consegue escrever um código que um computador por entender. 
Bons programadores escrevem código que humanos podem entender

4. Feature envy -> move amountFor

5. Renamte amountFor -> getCharge

6. Inline variable thisAmount
    Variaveis temporárias geralmente deixam o código difícil de entender.
    Performance é um preço a se pagar. No entanto, vc não sabe se é um problema.
    Caso ocorra, é muito mais fácil otimizar um código limpo que um com code smells.

7. Extract frequentRenterPoint(rental) -> getFrequentRenterPoints

8. Removento temporários
    totalAmount -> getTotalCharge

    frequentRenterPoints -> getTotalFrequentRenterPoints

performance: o while roda 3 vezes. Isso pode acarretar problemas de performance. PODE.
Se isso ocorrer, com o código mais limpo, será mais fácil de atacar os problemas de performance.

9. Pode ser implementado o htmlStatement

10. Trocando Logica condicional de código de preço por polimorfismo

    1. getCharge extrai método e manda para movie

    2. getRentalFrequentRenterPoints manda para movie

11. Polimorfismo
    1. Criar Price class que tem o priceCode
    2. Substituir o priceCode
    3. Criar subclasses de Price: NewReleasePric, RegularPrice, ChildrensPrice
    4. Carregar a classe certa no setter no priceCode
    5. Mover getCharge para Price
    6. Mover getRentalFrequentRenterPoints para Price
    7. Ir descendo getCharge para cada filho