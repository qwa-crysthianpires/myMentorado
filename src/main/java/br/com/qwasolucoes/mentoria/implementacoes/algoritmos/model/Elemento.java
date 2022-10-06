
package br.com.qwasolucoes.mentoria.implementacoes.algoritmos.model;

public class Elemento<TIPO> {
    private TIPO valor;
    private Elemento<TIPO> proximo;

    private Elemento <TIPO> anterior;

    private Elemento<TIPO> inicio;


    public Elemento(TIPO novoValor){
        this.valor = novoValor;
    }

    public TIPO getValor() {
        return valor;
    }

    public void setValor(TIPO valor) {
        this.valor = valor;
    }

    public Elemento<TIPO> getProximo() {
        return proximo;
    }

    public void setProximo(Elemento<TIPO> proximo) {
        this.proximo = proximo;
    }

    public Elemento<TIPO> getAnterior() {
        return anterior;
    }

    public void setAnterior(Elemento<TIPO> anterior) {
        this.anterior = anterior;
    }
    public boolean isEmpty(){
        return inicio == null;
    }

    public Elemento<TIPO> getInicio() {
        return inicio;
    }

    public void setInicio(Elemento<TIPO> inicio) {
        this.inicio = inicio;
    }
}
