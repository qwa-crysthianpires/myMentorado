package br.com.qwasolucoes.mentoria.interfaces.algoritmos;

/**
 * Árvores binárias de busca 
 * 
 * Assim como árvores binárias generalizam a ideia de listas encadeadas, árvores binárias de busca (= binary search trees = BSTs) 
 * 
 * generalizam a ideia de listas encadeadas crescentes.
 * 
 * @author ronan
 *
 */
public interface ArvoreBinariaBusca {

	public void inserir(int elemento);
	
	/**
	 * Árvore em ordem
	 * 
	 * É a estratégia de varredura de árvore binária na qual lê-se primeiro a sub-árvore esquerda em intra-ordem, seguido pelo nó raiz e finalmente pela sub-árvore direita em intra-ordem
	 * 
	 * @return árvore em ordem
	 */
	public int[] todosOrdenado();
	
	/**
	 * Árvore pré ordem
	 * 
	 * É a estratégia de varredura de uma árvore binária na qual o primeiro nó é o nó raiz, seguido pela sub-árvore esquerda em pré-ordem e finalmente pela sub-árvore direita em pré-ordem;
	 * 
	 * @return árvore pré ordem
	 */
	public int[] preOrdem();
	
	/**
	 * Árvore pós ordem
	 * 
	 * É a estratégia de varredura na qual primeiro lê-se os nós da sub-árvore esquerda em pós-ordem, depois os nós da sub-árvore direita em pós-ordem e finalmente o nó raiz.
	 * 
	 * @return árvore pós ordem
	 */
	public int[] posOrdem();
	
	public int primeiro();
	
	public int ultimo();
	
}
