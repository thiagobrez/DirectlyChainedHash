package com.company;

import java.util.Arrays;

public class Hash {

    private int[] dados;
    private int[] proximosIndices;
    private int tamanho;

    public Hash(int totalElementos, int fatorCarga) {
        this.tamanho = totalElementos / fatorCarga;
        this.dados = new int[this.tamanho * 2];
        this.proximosIndices = new int[this.tamanho * 2];
        Arrays.fill(this.dados, -1);
        Arrays.fill(this.proximosIndices, -1);
    }

    private int hashID(int dado) {
        return dado % this.tamanho;
    }

    //TODO: encadear posicoes livres no oveflow

    public void inserir(int dado) {
        int grupo = hashID(dado);
        if(this.dados[grupo] == -1) {
            this.dados[grupo] = dado;
        } else {
            if(this.proximosIndices[grupo] == -1) {
                for(int i = this.tamanho; i < this.dados.length; i++) {
                    if(this.dados[i] == -1) {
                        this.dados[i] = dado;
                        this.proximosIndices[grupo] = i;
                    }
                }
            }
        }
    }

}
