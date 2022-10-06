package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Ordenacao;

public class OrdenaçãoProvider implements Ordenacao {
    @Override
    public int[] ordenar(int[] elementos) {

        for(int i = 1; i < elementos.length; i++) {

            int aux = elementos[i];
            int j = i-1;

            while(j >= 0 && elementos[j] > aux){
                elementos[j+1] = elementos[j];
                j--;
            }
            elementos[j+1] = aux;
        }
        return elementos;
    }

    @Override
    public int[] quicksort(int[] elementos) {

        quicksort1(elementos, 0, elementos.length -1);

        return elementos;
    }



    @Override
    public int[] mergesort(int[] elementos) {

        int tamanho = elementos.length;
        int qtdElementos = 1;

        /* Variaveis utilizadas para marcar o inicio, meio e fim do vetor. */
        int inicio, meio, fim;

        /* Percorre os elementos do vetor até chegar no fim do vetor. */

        while(qtdElementos < tamanho) {

            /* Aponta o inicio do vetor. */
            inicio = 0;

      /* Percorre o vetor do inicio + quantidade de elementos ja percorrido,
        até o tamanho do vetor. */

            while(inicio + qtdElementos < tamanho) {
                /* Guarda a posição do meio do vetor que será ordenado. */
                meio = inicio + qtdElementos;
                /* Guarda a posição final do vetor que será ordenado. */
                fim = inicio + 2 * qtdElementos;

        /* Caso o fim fique com um tamanho maior, que o tamanho do vetor,
         então faz o fim ter o mesmo tamanho que o tamanho do vetor. */
                if(fim > tamanho)
                    fim = tamanho;

        /* Chama o método que faz a intercalação dos valores
          ordenados do vetor. */
                intercala(elementos, inicio, meio, fim);

                /* Faz o inicio do vetor ser igual ao fim. */
                inicio = fim;
            }

            /* Percorre o vetor dobrando a quantidade de itens ja ordenados. */
            qtdElementos = qtdElementos * 2;
        }


        return elementos;
    }

    @Override
    public int[] bubbleSort(int[] elementos) {

        // for utilizado para controlar a quantidade de vezes que o vetor será ordenado.
        for(int i = 0; i < elementos.length - 1; i++) {
            // for utilizado para ordenar o vetor.
            for(int j = 0; j < elementos.length - 1 - i; j++) {
	        /* Se o valor da posição atual do vetor for maior que o proximo valor,
	          então troca os valores de lugar no vetor. */
                if(elementos[j] > elementos[j + 1]) {

                    int aux = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = aux;
                }
            }
        }
        return elementos;
    }

    @Override
    public int[] particaoPositivosNegativos(int[] valores) {

        for(int i = 0; i < valores.length - 1; i++) {

            for(int j = 0; j < valores.length - 1 - i; j++) {

                if(valores[j] % 2 == 1) {

                    int aux = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = aux;
                }
            }
        }
        return valores;
    }


    public static void quicksort1(int[] vetor, int esquerda, int direita){
        if (esquerda < direita){
            int p = particao(vetor, esquerda, direita);
            quicksort1(vetor, esquerda, p);
            quicksort1(vetor, p + 1, direita);
        }
    }

    static int particao(int[] vetor, int esquerda, int direita){
        int meio = (int) (esquerda + direita) / 2;
        int pivot = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        while(true){
            do{
                i++;
            }while(vetor[i] < pivot);
            do{
                j--;
            }while(vetor[j] > pivot);
            if (i >= j){
                return j;
            }
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }

    private static void intercala(int[] vetor, int inicio, int meio, int fim) {
        /* Vetor utilizado para guardar os valors ordenados. */
        int novoVetor[] = new int[fim - inicio];
        /* Variavel utilizada para guardar a posicao do inicio do vetor. */
        int i = inicio;
        /* Variavel utilizada para guardar a posição do meio do vetor. */
        int m = meio;
    /* Variavel utilizada para guarda a posição onde os
      valores serão inseridos no novo vetor. */
        int pos = 0;

    /* Enquanto o inicio não chegar até o meio do vetor, ou o meio do vetor
      não chegar até seu fim, compara os valores entre o inicio e o meio,
      verificando em qual ordem vai guarda-los ordenado.*/
        while(i < meio && m < fim) {
      /* Se o vetor[i] for menor que o vetor[m], então guarda o valor do
        vetor[i] pois este é menor. */
            if(vetor[i] <= vetor[m]) {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;
                // Senão guarda o valor do vetor[m] pois este é o menor.
            } else {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }

        // Adicionar no vetor os elementos que estão entre o inicio e meio,
        // que ainda não foram adicionados no vetor.
        while(i < meio) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }

        // Adicionar no vetor os elementos que estão entre o meio e o fim,
        // que ainda não foram adicionados no vetor.
        while(m < fim) {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }

        // Coloca no vetor os valores já ordenados.
        for(pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }
    }
}
