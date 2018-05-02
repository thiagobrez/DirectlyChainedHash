package com.company;

import java.util.Arrays;

/**
 * @author João Grasel Cariolato
 * @author Thiago Brezinski
 */
public class Hash {

    private int[] dados;
    private int[] prox;
    private int tamanho;
    private int espalhamento;

    public Hash(int totalElementos, int fatorCarga, int espalhamento) throws Exception {
        this.tamanho = totalElementos / fatorCarga;
        if(espalhamento >= this.tamanho) throw new Exception("O espalhamento deve ser menor que o tamanho!");
        this.espalhamento = espalhamento;
        this.dados = new int[this.tamanho];
        this.prox = new int[this.tamanho];
        Arrays.fill(this.prox, -1);
    }

    public Hash(int tamanho, int espalhamento) throws Exception {
        if(espalhamento >= tamanho) throw new Exception("O espalhamento deve ser menor que o tamanho!");
        this.tamanho = tamanho;
        this.espalhamento = espalhamento;
        this.dados = new int[this.tamanho];
        this.prox = new int[this.tamanho];
        Arrays.fill(this.prox, -1);
    }

    private int hashID(int dado) {
        return dado % this.espalhamento;
    }

    public void inserir(int dado) throws Exception {
        int grupo = hashID(dado);
        while(this.prox[grupo] != -1) {
            if(grupo + this.espalhamento < this.tamanho - 1) {
                grupo += this.espalhamento;
            } else {
                throw new Exception("Encadeamento cheio para o dado: " + dado + ".");
            }
        }
        this.dados[grupo] = dado;
        this.prox[grupo] = grupo + this.espalhamento;
    }

    public boolean buscar(int dado) {
        int grupo = hashID(dado);
        if(this.dados[grupo] == dado) {
            return this.prox[grupo] != -1;
        }
        while(this.prox[grupo] != -1) {
            if(this.dados[this.prox[grupo]] == dado) {
                return this.prox[this.prox[grupo]] != -1;
            }
            grupo = this.prox[grupo];
        }
        return false;
    }

    public void excluir(int dado) throws Exception {
        int grupo = hashID(dado);
        if(this.dados[grupo] == dado) {
            this.prox[grupo] = -1;
        }
        while(this.prox[grupo] != -1) {
            if(this.dados[this.prox[grupo]] == dado) {
                this.prox[this.prox[grupo]] = -1;
                return;
            } else {
                grupo = this.prox[grupo];
            }
        }
        throw new Exception("Elemento inexistente!");
    }

    public void print() {
        for(int i = 0; i < this.tamanho; i++) {
            System.out.println(i + ":" + "[" + this.dados[i] + "]" + "[" + this.prox[i] + "]");
        }
    }

}