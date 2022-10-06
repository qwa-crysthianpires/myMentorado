package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.implementacoes.algoritmos.model.Elemento;
import br.com.qwasolucoes.mentoria.interfaces.algoritmos.ArvoreBinaria;

class ArvoreBinariaProvider<T extends Comparable> implements ArvoreBinaria {

    private Elemento<Integer> raiz;


    @Override
    public void adicionar(int elemento) {
//        Elemento<Integer> novoElemento = new Elemento<Integer>(elemento);
//
//        if (raiz == null) {
//            this.raiz = novoElemento;
//        }else {
//            Elemento<Integer> atual = this.raiz;
//
//            while (true) {
//                if (novoElemento.getValor().compareTo(atual.getValor()) == -1) {
//
//                    if (atual.getEsquerda() != null) {
//                        atual = atual.getEsquerda();
//                    } else {
//                        atual.setEsquerda(novoElemento);
//                        break;
//                    }
//                } else {
//                    if (atual.getDireita() != null) {
//                        atual = atual.getDireita();
//
//                    } else {
//                        atual.setDireita(novoElemento);
//                        break;
//                    }
//                }
//            }
//        }
    }

    @Override
    public int[] todosOrdenado() {

//        Elemento<Integer> atual = this.raiz;
//
//        if(atual != null){
////            todosOrdenado();
//            System.out.println(atual.getValor());
//
//
//            todosOrdenado();
//            System.out.println(atual.getValor());
//        }

        return new int[0];
    }

    @Override
    public int primeiro() {
        return 0;
    }

    @Override
    public int ultimo() {
        return 0;
    }
}
