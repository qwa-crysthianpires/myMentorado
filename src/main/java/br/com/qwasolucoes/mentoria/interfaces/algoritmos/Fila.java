package br.com.qwasolucoes.mentoria.interfaces.algoritmos;

import java.util.List;

/**
 * 
 * Uma fila é uma estrutura de dados dinâmica que admite remoção de elementos e inserção de novos objetos.  
 * 
 * Mais especificamente, uma  fila  (= queue)  é uma estrutura sujeita à seguinte regra de operação:  
 * 
 * sempre que houver uma remoção, o elemento removido é o que está na estrutura há mais tempo. 
 * 
 * Em outras palavras, o primeiro objeto inserido na fila é também o primeiro a ser removido. 
 * 
 * Essa política é conhecida pela sigla FIFO (= First-In-First-Out).
 * 
 * @author ronan
 *
 */
public interface Fila<T> {
	
	public void remover();

	public void adicionar(T elemento);
	
	public List<T> todos();
	
	public T obter(int indice);

}
