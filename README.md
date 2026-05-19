# Atividade1-Arvores

Relatório de justificativa técnica da abordagem recursiva:

- Ajuste automático dos ponteiros (O "Pai" do nó):

O maior desafio de remover um nó de forma iterativa (com loops while) é que, quando apagamos um nó, precisamos atualizar o nó pai dele para apontar para o novo filho. Isso exige criar variáveis extras para ficar guardando quem era o pai e fazer várias checagens para saber se o nó que saiu estava na esquerda ou na direita. Com a recursão, a própria estrutura da função resolve isso na "volta" da execução, limpando ou reconectando os nós de forma automática e muito mais limpa.

- Combina com o resto do código:

A árvore, por si só, é uma estrutura que funciona muito bem com recursão. Como os métodos de inserção e os percursos fornecidos para a atividade já utilizam essa lógica, manter a remoção como recursiva deixa o código todo conversando na mesma língua, facilitando a leitura e o entendimento do projeto.

- Facilidade no caso de 2 filhos:

O cenário mais incoveniente é quando o nó tem dois filhos, pois precisamos achar o menor valor da direita, colocar no lugar do nó apagado e depois ir lá embaixo deletar o sucessor original. Na recursão, para deletar esse sucessor depois de copiar o valor dele, basta chamar a própria função de remoção de novo em uma linha: atual.setDireita(removerRecursivo(..., menorValor)). Fazer isso com loops daria um trabalho enorme e o código ficaria gigante.
