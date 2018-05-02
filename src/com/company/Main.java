package com.company;

public class Main {

    public static void main(String[] args) {

        try {
            Hash hash1 = new Hash(10, 2);

            hash1.inserir(10);
            System.out.println("Inserido elemento 10");
            hash1.inserir(11);
            System.out.println("Inserido elemento 11");
            hash1.inserir(12);
            System.out.println("Inserido elemento 12");
            hash1.inserir(13);
            System.out.println("Inserido elemento 13");
            hash1.inserir(14);
            System.out.println("Inserido elemento 14");
            hash1.inserir(15);
            System.out.println("Inserido elemento 15");

            System.out.println();

            System.out.println("Hash atual: ");
            hash1.print();
            System.out.println();

            System.out.println("Existe elemento 12: " + hash1.buscar(12));
            System.out.println("Existe elemento 16: " + hash1.buscar(16));

            System.out.println();
            hash1.excluir(15);
            System.out.println("Excluído elemento 15");
            hash1.excluir(12);
            System.out.println("Excluído elemento 12");
            System.out.println();

            System.out.println("Existe elemento 12: " + hash1.buscar(12));
            System.out.println();

            System.out.println("Hash atual: ");
            hash1.print();
            System.out.println();

            hash1.inserir(18);
            System.out.println("Inserido elemento 18");
            System.out.println();

            System.out.println("Hash atual: ");
            hash1.print();
            System.out.println();

            System.out.println("Tentando excluir elemento 20...");
            hash1.excluir(20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
