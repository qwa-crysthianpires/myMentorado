package br.com.qwasolucoes.mentoria.implementacoes.algoritmos.model;

public class ListaLigada<TIPO>{

    private Elemento<TIPO> primeiro;
    private Elemento<TIPO> ultimo;
    private int tamanho;


    public ListaLigada() {
        this.tamanho = 0;
    }

    public Elemento getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Elemento primeiro) {
        this.primeiro = primeiro;
    }

    public Elemento getUltimo() {
        return ultimo;
    }

    public void setUltimo(Elemento ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        tamanho = tamanho;
    }

    public void adicionarComeco(TIPO novoValor){

        Elemento novoElemento = new Elemento(novoValor);

        if (this.primeiro == null && this.ultimo == null){
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;

        }else{
            novoElemento.setProximo(primeiro);
            this.primeiro = novoElemento;
        }
        this.tamanho++;
    }


    public void adicionar(TIPO novoValor){

        Elemento novoElemento = new Elemento(novoValor);

        if (this.primeiro == null && this.ultimo == null){
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;

        }else{
            this.ultimo.setProximo(novoElemento);
            this.ultimo = novoElemento;
        }
        this.tamanho++;
    }

    public void remover(TIPO valorProcurado){

        Elemento<TIPO> anterior = null;
        Elemento<TIPO> atual = this.primeiro;

        for(int i = 0; i <this.getTamanho(); i++){

            if(atual.getValor().equals(valorProcurado)){

                if (atual == primeiro && atual == ultimo) {
                    this.primeiro = atual.getProximo();
                    atual.setProximo(null);
                }
                else if(atual == primeiro){
                    this.primeiro = atual.getProximo();
                    atual.setProximo(null);

                } else if(atual == ultimo){
                    this.ultimo = anterior;
                    anterior.setProximo(null);

                }else{
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                }

                this.tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }

    public Elemento get(int posicao){
        Elemento atual = this.primeiro;
        for(int i=0; i<posicao; i++){
            if (atual.getProximo() != null){
                atual = atual.getProximo();
            }
        }
        return atual;
    }
}
