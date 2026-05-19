public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(0);
        arvoreBinaria.inserir(-3);
        arvoreBinaria.inserir(-5);
        arvoreBinaria.inserir(-4);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(9);
        
        System.out.println("\n--- Exibição Em-Ordem Original ---");
        arvoreBinaria.exibir("Em");

        System.out.println("\n--- 1. Removendo Nó Folha (-4) ---");
        arvoreBinaria.remover(-4);

        System.out.println("\n--- 2. Removendo Nó com 1 Filho (7, que tem o 9) ---");
        arvoreBinaria.remover(7);

        System.out.println("\n--- 3. Removendo Nó com 2 Filhos (5, que tem o 3 e 10) ---");
        arvoreBinaria.remover(5);

        System.out.println("\n--- Exibição Em-Ordem Após Remoções ---");
        arvoreBinaria.exibir("Em");
    }
}