package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;


import br.com.qwasolucoes.mentoria.implementacoes.algoritmos.model.No;
import br.com.qwasolucoes.mentoria.interfaces.algoritmos.ListaEncadeada;

import java.util.List;

public class ListaEncadeadaProvider<T> implements ListaEncadeada {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;


    @Override
    public void remover() {

    }

    @Override
    public void adicionar(Object elemento) {

        No<T> celula = new No<T>((T) elemento);
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }



    @Override
    public List todos() {
        return null;
    }

    @Override
    public Object obter(int indice) {
        return null;
    }

    @Override
    public String toString() {
        return "ListaEncadeadaProvider{" +
                "inicio=" + inicio +
                ", ultimo=" + ultimo +
                ", tamanho=" + tamanho +
                '}';
    }
}
