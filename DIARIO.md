Mikael: Comecei planejando utilizar deques, listas e pilha, porém fui alertado da professora que talvez utilizar apenas um deque para delimitar o tamanho poderia ter falhas, então decidimos usar 2 deques invés de um deque e uma pilha, deques para voltar e avançar e listas para histórico e favoritos. Meu planejamento inicial foi começar confirmando com a inteligencia artificial se era correto utilizar minhas estrutras de dados e se eram as melhores opções, após isso foi escrevendo o código do Node primeiro e depois da lista com ajuda do copilot oq agilizou muito o meu trabalho, gerando as classes em pouco tempo e caso eu sentisse falta de algo eu corrigia tranquilamente. 

1 Prompt usado: está correta está implementação da lista? quais pontos posso colocar a mais?
Resposta: Sim, a lógica está correta. Os ponteiros do insere estão na ordem certa, com anterior e posterior guardados antes de religar. Os sentinelas funcionam em lista vazia, no início e no fim, sem casos especiais, e contem, tamanho e estaVazia também estão certos.

Pequenos ajustes
toText com String +=: cada concatenação cria uma String nova, então fica O(n²). Com StringBuilder funciona igual e é mais eficiente.
Posição inválida: IndexOutOfBoundsException descreve melhor o erro do que IllegalArgumentException. Para url == null, a IllegalArgumentException está certa.
Campos do Node: como você acessa anterior.next e atual.url direto, eles precisam ser visíveis para a Lista. Se Node for uma classe interna private static class Node, tudo funciona e fica bem encapsulado.

Decisão: Aderi o indexOutOfBounds que o copilot tinha colocado como throwIlllegal sem motivo, como não aprendi o stringbuilder optei por deixar do jeito que estava devido a não saber mexer com isso

2 Prompt usado: É necessário manter o private final nesse codigo?

Resposta:
Não é necessário. O código funciona sem eles, mas os dois são boas práticas. 

private mantém header, trailer e tamanho inacessíveis de fora da classe. Sem ele, o Browser poderia mexer direto em lista.tamanho ou trocar o header, e quebrar a lista sem passar pelos métodos. Funciona sem, mas você perde o encapsulamento, que costuma ser cobrado em Estruturas de Dados.

Decisão: Resolvi manter sem o final por não ter o costume de usar e por ser um código "pequeno" e mais "simples" acredito que não seja necessário e o mantive sem

3 Prompt: É possivel colocar um atributo como static e quando uso isso?

Resposta: Sim, é possível. Um atributo static pertence à classe, não a cada objeto: existe uma única cópia, compartilhada por todas as instâncias.

Quando usar
Constantes: private static final int LIMITE = 100;. É o uso mais comum, e a convenção é escrever em maiúsculas.

Contadores ou dados compartilhados entre todos os objetos da classe, como o totalListas acima.

Decisão: Aderi a utilizar isso por conta que caso seja necessário mudar o LIMITE eu consigo e é compartilhado com todas instancias que é o que eu preciso, devido aos dois deques usarem isso

Erros percebidos: com copilot eu percebi que ele nao recomendava a criação do trailer e header mesmo sendo uma lista duplamente encadeada, além disso o autocomplete sugeriu na lista, criar um inserenafrente, no final e entre, oq achei desnecessário e deixei apenas o insere com indice, mas não é algo errado, apenas quis simplificar, de resto nao senti muitos problemas, ajudou a acelerar bastante o progresso e tirou minhas duvidas como mostrado acima alem de algumas outras, alias esses prompts foram respondidos pelo claude.

Escrevi sem ia boa parte do código caso auto complete não esteja sendo considerado, porém sem o auto complete nao cheguei a escrever muita coisa devido a apenas desacelerar o progresso, apenas tive que pensar no que queria aderir e no que não aderir e modificar algo como o Node para o jeito que eu queria e que foi visto em aula

Não achei nenhuma parte muito complexa no trabalho, tivemos que lidar com um trabalho 100 vezes maior e complexo na materia de POD, onde desenvolvemos o uso do git e tratamos com volumes de dados maiores e classes herdadas e coisas complexas na semana retrasada. Como parte importante nesse trabalho era identificar a estrutra de dados e implementa-la corretamente e acho que isso é o mais dificil devido a estruturas terem regras e ser necessário segui-las e saber modificar elas para usar em cada caso, acho que é isso que faz o trabalho mais dificil alem de entender cada peça sem falha.

Para mim Deque é basicamente uma estrutura que mistura pilha e fila, juntas as duas e assim nasce o deque, uma classe muito util devido a poder entrar no fim e no inicio, além disso permite que gere o fluxo de dois lados, como por exemplo, quando sai do inicio vai para um lugar, e quando sai do final vai para outro, a mesma coisa para quando entra, isso permite ela ser muito versatil e funcional em diversos casos. 

Acredito que a IA fez bem no trabalho a parte bruta de gerar o código e tirar dúvidas porém acredito que ela faz mal por deixar a mente preguiçosa e menos treinada, além, de em alguns casos ignorar as regras das estruras, por exemplo o copilot recomendou a criação do metodo insereEntre em um deque, coisa que não faz muito sentido, então acho esse um dos pontos negativos da ia