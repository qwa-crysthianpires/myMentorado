package br.com.qwasolucoes.mentoria.interfaces.estrutura_dados;

import java.util.List;
import java.util.Map;

import br.com.qwasolucoes.mentoria.model.ContatoFuncionario;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public interface EstruturaDadosMap {

	/**
	 * Dada uma lista de nomes, retorne um map com cada nome e com a frequência com
	 * qual cada nome aparece na lista
	 */
	public Map<String, Integer> nomeFrequencia(final List<String> nomes);
	
	/**
	 * Dado um mapa, retorne um map com cada chave e com a frequência com
	 * qual cada valor aparece no mapa
	 */
	public Map<String, Integer> mapaFrequenciaValores(final Map<String, String> mapa);
	
	/**
	 * Dado um mapa, retorne um map com cada chave e com a frequência com
	 * qual cada valor aparece nos valores da lista 
	 */
	public Map<String, Integer> mapaFrequenciaValoresLista(final Map<String, List<String>> mapa);

	/**
	 * Dada uma lista de elementos com nome e telefone (Separado por ; Exemplo:
	 * [nome;telefone1,telefone2,telefone3 até n],
	 * 
	 * retorne um map em que a chave é o nome e valor uma lista com os números de
	 * telefone daquela pessoa
	 */
	public Map<String, List<String>> nomeTelefones(final List<String> elemento);
	
	/**
	 * Dada uma lista de elementos com cpfCnpj e telefone (Separado por ; Exemplo:
	 * [cpfCnpj;telefone1,telefone2,telefone3 até n],
	 * 
	 * retorne um map em que a chave é o a pessoa e valor uma lista de contatos com os números de
	 * telefone daquela pessoa
	 */
	public Map<Funcionario, List<ContatoFuncionario>> cpfCnpjTelefonesObjeto(final List<String> elemento);
	
	/**
	 * Dado um mapa de elementos, retorne as chaves.
	 * 
	 * retorne uma lista das chaves do mapa
	 */
	public List<String> chavesMapa(final Map<String, String> mapa);
	
	/**
	 * Dado um mapa de elementos, retorne os valores.
	 * 
	 * retorne uma lista dos valores do mapa
	 */
	public List<String> valoresMapa(final Map<String, String> mapa);
	
	/**
	 * Dada um limite, adicione os números pares, impares, primos e multiplos de 10, nas suas chaves correspondentes.
	 * 
	 * EX:
	 * 
	 * ["NUMEROS_PARES", 		{2, 4, 6, 8, 10, n} ]
	 * ["NUMEROS_IMPARES", 		{1, 3, 5, 7, 9,  n} ]
	 * ["NUMEROS_PRIMOS", 		{2, 3, 5, 7, 11, n} ]
	 * ["NUMEROS_MULTIPLOS_10", {10, 20, 30, 40, 50, n} ]
	 * 
	 */
	public Map<String, List<Integer>> tipoNumerosCorrespondentes(final int limite);
	
	/**
	 * Qual o maior número encontrado entre os valores do MAPA
	 */
	public Integer maiorNumeroEntreValores(final Map<String, List<Integer>> map);
	
	/**
	 * Qual o a chave do maior número encontrado entre os valores do MAPA
	 */
	public String chaveMaiorNumeroEntreValores(final Map<String, List<Integer>> map);
	
}
