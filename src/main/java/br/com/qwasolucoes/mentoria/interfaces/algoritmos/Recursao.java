package br.com.qwasolucoes.mentoria.interfaces.algoritmos;

public interface Recursao {

	/**
	 * A recursão na programação é bem exemplificada quando uma função é definida em
	 * termos de si mesma. A função chama a si mesma recursivamente até que alcance
	 * o caso base.
	 * Ex: funcao recursiva(n): if n == 1: return 1 recursiva(n-1)
	 * Exercício: Escreva uma função recursiva que imprima os n primeiros números
	 * inteiros a partir de 0
	 */
	public int recursao(final int valor, final int limite);

	/**
	 * Escreva uma função recursiva que retorne a soma dos números de 1 a n
	 */
	public int recursaoSoma(final int valor, final int limite);
	
	/**
	 * Na matemática, a sucessão de Fibonacci (ou sequência de Fibonacci), é uma
	 * sequência de números inteiros, começando normalmente por 0 e 1, na qual cada
	 * termo subsequente corresponde à soma dos dois anteriores. A sequência recebeu
	 * o nome do matemático italiano Leonardo de Pisa, mais conhecido por Fibonacci,
	 * que descreveu, no ano de 1202, o crescimento de uma população de coelhos, a
	 * partir desta. Esta sequência já era, no entanto, conhecida na antiguidade. Os
	 * números de Fibonacci são, portanto, os números que compõem a seguinte
	 * sequência (sequência A000045 na OEIS): 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
	 * 89, 144, 233, 377, 610, 987, 1597, 2584, ... .[nota 1][2] Em termos
	 * matemáticos, a sequência é definida recursivamente pela fórmula abaixo: Fn =
	 * F(n - 1) + F(n - 2) e valores iniciais: F1 = 1, F2 = 1 Sabendo disso, escreva
	 * uma função para calcular a sequência de fibonacci de forma recursiva E outra
	 * de forma iterativa
	 * 
	 */
	public int recursaoFibonacci(final int valor, final int limite);

}
