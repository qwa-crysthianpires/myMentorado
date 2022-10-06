package br.com.qwasolucoes.mentoria.interfaces.algoritmos;

public interface Ordenacao {
	
	public int[] ordenar(int[] elementos);

	public int[] quicksort(int[] elementos);

	public int[] mergesort(int[] elementos);

	public int[] bubbleSort(int[] elementos);

	/**
	 * Desenvolva um algoritmo eficiente in-place (sem criar estruturas de dados
	 * adicionais) que particione um array em números pares e ímpares. Todos os
	 * números pares devem preceder os números ímpares.
	 *
	 * Por exemplo: input A = 〈7, 17, 74, 21, 7, 9, 26, 10〉,
	 *
	 * result A = 〈74, 10, 26, 17, 7, 21, 9, 7〉.
	 */

	public int[] particaoPositivosNegativos(final int[] valores);

}
