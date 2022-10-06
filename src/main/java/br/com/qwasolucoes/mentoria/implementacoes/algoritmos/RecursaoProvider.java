package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Recursao;

public class RecursaoProvider implements Recursao {
    @Override
    public int recursao(int valor, int limite) {

        if (valor > limite) {
            valor = (valor - 1);
            System.out.println(valor);
        }
        else if (valor < limite) {
            valor = (valor + 1);
            System.out.println(valor);

        } else {
            return 0 ;
        }
        return recursao(valor, limite);
    }

    @Override
    public int recursaoSoma(int valor, int limite) {

        if(valor == limite) {
            return limite;
        }

        return valor + recursaoSoma(valor + 1, limite);
    }

    @Override
    public int recursaoFibonacci(int valor, int limite) {


        if(valor == limite) {
            return limite;
        }

        if (valor < 2) {
            return valor;
        }
        return recursaoFibonacci(valor +1, limite) + recursaoFibonacci(valor +2, limite);
    }

}
