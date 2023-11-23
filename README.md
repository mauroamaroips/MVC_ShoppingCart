# MVC Pattern

## Introdução
O Padrão MVC é um padrão de arquitetura.


![height:200px](images/mvc.png) 


O Padrão tem como objetivo organizar uma aplicação dividindo as suas componentes em
- **Model**
    - Sabe tudo sobre, os dados persistentes  que devem ser apresentados;as operações que serão aplicadas para transformar os objectos.
    - Nada sabe sobre, as interfaces do utilizador, de como os dados serão mostrados, as acções das interfaces usadas para manipular os dados.
- **View**
    - Dispara as operações de consulta do Model (via Controller) para manipular/obter os dados e visualizá-los;
    - Define como os dados serão visualizados pelo utilizador;
    - Mantém consistência na apresentação dos dados quando o Model muda;
- **Controller**
    - Sincroniza as acções do View com as acções realizadas pelo Model;
    - Trabalha somente com sinais e não com os dados da aplicação;
    - Sabe os meios físicos pelos quais os utilizadores manipulam os dados no Model;

## Exemplo

Pretende-se realizar uma aplicação para gerir a compra de produtos online - " carrinho de compras" que deverá ter a seguinte interface 
![mvc](images/userinterface.jpg)
- O padrão **Observer** é implementado para gerir as notificações entre as classes do Model e da View.

- **Model**
  - A classe ShoppingCart é responsável por gerir a listad e produtos que compoe o carrinho de compras.
  - Cada vez que a lista de produtos é alterada notifica ShoppingCartUI.
  - A classe ShoppingCart assume o papel de ConcreteSubject.
- **View**
  - A classe ShoppingCartView implementa em JavaFX a interface grafica do ShoppingCart.
  - A classe ShoppinCartView implementa a interface Observer. Redefine o método update, qeu é responsavel por atualizar a UI de forma 
  a manter consistência na apresentação dos dados quando o ShoppingCart é alterado (adicionado ou removido produtos);
  
- **Controller**
  - Sincroniza as acções do View (pressionar os botões ) com as acções realizadas pelo Model. Esta sincronização é realizada pelo método doAddProduct, através dos métodos doAdd
  - É reponsável por solicitar à View para mostrar mensagens de alerta, caso a operação de adicionar Produto gere uma excepção.

## Exercício
1. Coloque um botão para remover produtos. E adicione o comportamento. 
2. Adicione um alarme, para quando o valor total do carrinho exceder um determinado valor. 
 - Nesse caso, não deve ser possivel adicionar mais produtos ao carrinho e o total deve ficar a vermelho.

    