Planejamento inicial: (Seção 1)
Começamos planejando utilizar as seguintes estruturas para cada comando: Deques para visitar e voltar. Pilha para avançar, e, listas para histórico e favoritar. Todavia, foi nos indicado utilizar deque para o comando avançar, e decidimos acatar a sugestão da professora. Nosso planejamento inicial foi começar confirmando com a inteligencia artificial se estávamos utilizando as estruturas de dados corretas para cada comando. Após isso começamos o código, fizemos primeiramente a classe Node, com ajuda do Copilot, o que agilizou muito o nosso trabalho, gerando as classes em pouco tempo e caso sentíssemos falta de algo corrigíamos tranquilamente. 

Conversa com a IA: (Seção 2)
*Toda a parte de IA foi feita pelo Sonnet 5.5 (Versão mais recente da IA generativa do Claude)

1- Prompt usado: está correta está implementação da lista? Quais pontos posso colocar a mais?
Resposta: Sim, a lógica está correta. Os ponteiros do insere estão na ordem certa, com anterior e posterior guardados antes de religar. Os sentinelas funcionam em lista vazia, no início e no fim, sem casos especiais, os métodos: contains, tamanho e "estaVazia" também estão certos.

Pequenos ajustes
toText com String +=: cada concatenação cria uma String nova, então fica O(n²). Com StringBuilder funciona igual e é mais eficiente.
Posição inválida: IndexOutOfBoundsException, descreve melhor o erro do que IllegalArgumentException. Para url == null, a IllegalArgumentException está certa.
Campos do Node: como você acessa anterior.next e atual.url direto, eles precisam ser visíveis para a Lista. Se Node for uma classe interna private static class Node, tudo funciona e fica bem encapsulado.

Decisão: Aderimos o indexOutOfBounds que o copilot tinha colocado como throwIlllegal sem nenhum motivo aparente, como não aprendemos o stringbuilder optamos por deixar do jeito que já estava anteriormente.

2- Prompt usado: É necessário manter o private final nesse codigo?

Resposta:
Não é necessário. O código funciona sem eles, mas os dois são boas práticas. 
Private mantém header, trailer e tamanho inacessíveis de fora da classe. Sem ele, o Browser poderia mexer direto em lista.tamanho ou trocar o header, e quebrar a lista sem passar pelos métodos. Funciona sem, mas você perde o encapsulamento, que costuma ser cobrado em Estruturas de Dados.

Decisão: Resolvemos manter sem o final por não ter o costume de usar e por ser um código pequeno e relativamente simples.

3- Prompt usado: É possível colocar um atributo como static e quando uso isso?

Resposta: Sim, é possível. Um atributo static pertence à classe, não a cada objeto: existe uma única cópia, compartilhada por todas as instâncias.
Quando usar
Constantes: private static final int LIMITE = 100;. É o uso mais comum, e a convenção é escrever em maiúsculas.
Contadores ou dados compartilhados entre todos os objetos da classe, como o totalListas acima.

Decisão: Decidimos utilizar o static por conta que possibilita mudar o LIMITE se necessário, além disso o atributo é compartilhado com todas instâncias, isso facilita nosso trabalho devido aos dois deques utilizarem esse mesmo atributo.

Erros encontrados e como foram corrigidos: (Seção 3)
Com copilot, percebemos que ele não recomendava a criação do trailer e header mesmo sendo uma lista duplamente encadeada, além disso ele também sugeriu para, nas listas, criar métodos para inserir na frente, numa posição index, e no final. Nós achamos tais sugestões desnecessárias e deixamos apenas o insere com índice, para simplificar, de resto não percebemos muitos problemas, ajudou a acelerar bastante o processo e tirou nossas dúvidas como mostrado acima.

Partes do Código que você escreveu sem IA: (Seção 4)
Escrevemos sem IA boa parte do código, mais especificamente as classe Node, Deque e Lista. Contudo, deixamos o autocomplete do VSCODE ligado para acelerar o processo, sempre atentado para as sugestões que nos eram passadas. A maioria das sugestões não foram aderidas pelo fato de serem muito genéricas, e, diferente do que nos foi ensinado durante as aulas. As classes Browser e App tiveram o uso de IA generativa.

Reflexão final: (Seção 5)
Não achamos nenhuma parte muito complexa no trabalho, já tivemos que lidar com trabalhos mais complicados e complexos durante a graduação. Na nossa concepção, a parte importante nesse trabalho era identificar a estrutura de dados e implementá-la corretamente. Devido às estruturas terem regras particulares que precisam ser seguidas, saber modificar elas para usar em cada caso se torna a parte-chave do trabalho.

Na nossa concepção, Deque é basicamente uma estrutura que mistura pilha e fila, uma classe muito útil devido a poder entrar no fim e no início, além disso permite que gere o fluxo de dois lados, como por exemplo, quando sai do início vai para um lugar, e quando sai do final vai para outro, a mesma coisa para quando entra, isso permite ela ser muito versátil e funcional em diversos casos. 

Acreditamos que a IA fez bem no trabalho a parte bruta de gerar o código e tirar dúvidas, porém, acreditamos que ela faz mal por deixar a mente preguiçosa e menos treinada. Além disso, em alguns casos, ela simplesmente ignora as regras das estruturas, um exemplo foi a recomendação do copilot para a criação do metodo insereEntre em um deque, coisa que não faz muito sentido.
