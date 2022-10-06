package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.implementacoes.algoritmos.model.Elemento;
import br.com.qwasolucoes.mentoria.implementacoes.algoritmos.model.EstruturaEstatica;
import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Pilha;


import java.util.List;

public class PilhaProvider<T> extends EstruturaEstatica implements Pilha   {

    Elemento topo = null;

    public PilhaProvider(){super();}


    @Override
    public void empilhar(Object elemento) {
        super.adiciona(elemento);
    }

    @Override
    public Object desempilhar() {
        if(this.estaVazia()){
            return null;
        }
        else{
            return this.elementos[--tamanho];
        }
    }

    @Override
    public List obterTodos() {
        return null;
    }
}
