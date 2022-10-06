package br.com.qwasolucoes.mentoria.interfaces.algoritmos;

/**
 * Árvores binárias 
 * 
 * Uma árvore binária é uma estrutura de dados mais geral que uma lista encadeada.  
 * 
 * Nós e filhos Uma árvore binária (= binary tree) é um conjunto de registros que satisfaz certas condições. 
 * 
 * As condições não serão dadas explicitamente, mas elas ficarão implicitamente claras no contexto.  
 * 
 * Os registros serão chamados nós (poderiam também ser chamados células).  
 * 
 * Cada nó tem um endereço.  
 * 
 * Suporemos por enquanto que cada nó tem apenas três campos:  um número inteiro e dois ponteiros para nós. 

 * @author ronan
 *
 */
public interface ArvoreBinaria {
	
	public void adicionar(int elemento);
	
	public int[] todosOrdenado();
	
	public int primeiro();
	
	public int ultimo();

}
