public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    public void inserirRecursivo(No novoNo, No atual) {
        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo() == novoNo.getConteudo()) {
            System.out.println("Não é possível informar nós repetidos.");
            return;
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    public boolean estaVazia() {
        if(this.raiz == null || this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    // MÉTODOS DE REMOÇÃO ADICIONADOS

    public void remover(Integer conteudo) {
        if (estaVazia()) {
            System.out.println("A árvore está vazia. Não há o que remover.");
            return;
        }
        this.raiz = removerRecursivo(this.raiz, conteudo);
    }

    private No removerRecursivo(No atual, Integer conteudo) {
        if (atual == null) {
            System.out.println("Nó " + conteudo + " não encontrado na árvore.");
            return null;
        }

        if (conteudo < atual.getConteudo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), conteudo));
        } else if (conteudo > atual.getConteudo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), conteudo));
        }
        else {
            System.out.println("O nó " + conteudo + " foi removido da Árvore.");

            // CASO 1: Nó Folha (Não tem filhos)
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }

            // CASO 2: Apenas um filho (na Direita ou na Esquerda)
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            // CASO 3: Dois filhos (Metodologia do Sucessor - Menor dos Maiores)
            Integer menorValor = encontrarMenorValor(atual.getDireita());
            atual.setConteudo(menorValor);
            atual.setDireita(removerRecursivo(atual.getDireita(), menorValor));
        }

        return atual;
    }

    private Integer encontrarMenorValor(No raizSubarvore) {
        No aux = raizSubarvore;
        while (aux.getEsquerda() != null) {
            aux = aux.getEsquerda();
        }
        return aux.getConteudo();
    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void exibir(String percurso) {
        switch (percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }
    }
}