package br.com.qwasolucoes.mentoria.interfaces.algoritmos;

import java.util.List;

/**
 * Uma pilha é uma estrutura de dados que admite remoção de elementos e inserção de novos objetos.  
 * Mais especificamente, uma  pilha (= stack)  é uma estrutura sujeita à seguinte regra de operação:  
 * 
 * sempre que houver uma remoção, o elemento removido é o que está na estrutura há menos tempo. 
 * 
 * Em outras palavras, o primeiro objeto a ser inserido na pilha é o último a ser removido. 
 * 
 * Essa política é conhecida pela sigla LIFO (= Last-In-First-Out).
 * 
 * @author ronan
 */
public interface Pilha<T> {
	
	public void empilhar(T elemento);
	
	public T desempilhar();
	
	public List<T> obterTodos();	

}
