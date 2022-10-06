package br.com.qwasolucoes.mentoria.interfaces.estrutura_dados;

import java.util.List;
import java.util.Set;

import br.com.qwasolucoes.mentoria.model.Funcionario;

public interface EstruturaDadosSet {

	/**
	 * Dada uma lista de nomes, contendo nomes repetidos, retorna-los de forma única
	 * em ordem alfabética DICA: explore as diferentes implementações de set
	 */
	public Set<String> nomesUnicosOrdenados(final List<String> nomes);

	/**
	 * Dada uma lista com valores positivos e negativos, retorne o maior número de
	 * um dígito Ex: Input: [-999, 77, -7, 5, 8, 99, 776] Retorno: 8
	 */
	public Set<String> valoresPositivosNegativos(final int[] valores);
	
	
	/**
	 * Dada 2 listas de valores, retorne os valores duplicados entre as duas e ordenado 
	 * 
	 * Exemplo: 
	 * 
	 * valores1: [1, 2, 3, 4, 5]
	 * valores2: [5, 4, 6, 2, 7] 
	 * Retorno:  [2, 4, 5]
	 */
	public Set<Integer> valoresDuplicadosOrdenados(final List<Integer> valores1, final List<Integer> valores2);
	
	/**
	 * Dada 2 listas de valores, retorne os valores diferentes entre as duas e ordenado 
	 * 
	 * Exemplo: 
	 * 
	 * valores1: [1, 2, 3, 4, 5]
	 * valores2: [5, 4, 6, 2, 7] 
	 * Retorno:  [1, 3, 6, 7]
	 */
	public Set<Integer> valoresDiferentesOrdenados(final List<Integer> valores1, final List<Integer> valores2);
	
	/**
	 * Dada 2 listas de valores, retorne os valores diferentes da lista 1 (valores1) entre as duas e ordenado 
	 * 
	 * Exemplo: 
	 * 
	 * valores1: [1, 2, 3, 4, 5]
	 * valores2: [5, 4, 6, 2, 7] 
	 * Retorno:  [1, 3]
	 */
	public Set<Integer> valoresDuplicadosDaPrimeiraListaOrdenados(final List<Integer> valores1, final List<Integer> valores2);
	
	/**
	 * Dada 2 listas de valores, retorne os valores diferentes da lista 2 (valores2) entre as duas e ordenado 
	 * 
	 * Exemplo: 
	 * 
	 * valores1: [1, 2, 3, 4, 5]
	 * valores2: [5, 4, 6, 2, 7] 
	 * Retorno:  [6, 7]
	 */
	public Set<Integer> valoresDiferentesDaSegundaListaOrdenados(final List<Integer> valores1, final List<Integer> valores2);
	
	/**
	 * Dada uma lista de pessoas, contendo pessoas repetidas, retorna-las de forma única
	 * em ordem alfabética DICA: explore as diferentes implementações de set
	 * 
	 * Obs: O que determina se uma pessoa é igual a outra é o CPF / CNPJ
	 * 
	 */
	public Set<Funcionario> pessoasUnicasOrdenados(final List<Funcionario> pessoas);
	
	/**
	 * Dada 2 listas de pessoas, retorne os valores duplicados entre as duas e ordenado
	 * 
	 *  Obs: O que determina se uma pessoa é igual a outra é o CPF / CNPJ
	 */
	public Set<Funcionario> pessoasDuplicadosOrdenados(final List<Funcionario> pessoas1, final List<Funcionario> pessoas2);
	
	/**
	 * Dada 2 listas de pessoas, retorne os valores diferentes entre as duas e ordenado
	 * 
	 *  Obs: O que determina se uma pessoa é igual a outra é o CPF / CNPJ
	 */
	public Set<Funcionario> pessoasDiferentesOrdenados(final List<Funcionario> pessoas1, final List<Funcionario> pessoas2);
	
	/**
	 * Dada 2 listas de pessoas, retorne os valores diferentes da lista 1 (pessoas1) entre as duas e ordenado
	 * 
	 *  Obs: O que determina se uma pessoa é igual a outra é o CPF / CNPJ
	 */
	public Set<Funcionario> pessoasDuplicadosDaPrimeiraListaOrdenados(final List<Funcionario> pessoas1, final List<Funcionario> pessoas2);
	
	/**
	 * Dada 2 listas de pessoas, retorne os valores diferentes da lista 2 (pessoas2) entre as duas e ordenado
	 * 
	 *  Obs: O que determina se uma pessoa é igual a outra é o CPF / CNPJ
	 */
	public Set<Funcionario> pessoasDiferentesDaSegundaListaOrdenados(final List<Funcionario> pessoas1, final List<Funcionario> pessoas2);

}
