package br.com.qwasolucoes.mentoria.interfaces.algoritmos;

import java.util.List;

/**
 * Listas encadeadas 
 * 
 * Uma lista encadeada é uma representação de uma sequência de objetos, todos do mesmo tipo. 
 * 
 * Cada elemento da sequência é armazenado em uma célula da lista: 
 * 
 * o primeiro elemento na primeira célula, o segundo na segunda, e assim por diante. 
 *  
 * Estrutura de uma lista encadeada Uma lista encadeada  (= linked list = lista ligada)  é uma sequência de células; 
 * 
 * cada célula contém um objeto (todos os objetos são do mesmo tipo) e o endereço da célula seguinte.  
 * 
 * @author ronan
 *
 * @param <T>
 */
public interface ListaEncadeada<T> {
	
	public void remover();

	public void adicionar(T elemento);
	
	public List<T> todos();
	
	public T obter(int indice);

}