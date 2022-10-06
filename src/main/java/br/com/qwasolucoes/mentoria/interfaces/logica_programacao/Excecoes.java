package br.com.qwasolucoes.mentoria.interfaces.logica_programacao;

import java.util.List;

import br.com.qwasolucoes.mentoria.exceptions.ValidacaoException;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public interface Excecoes {
	
	/**
	 * Dada uma lista de pessoas, precisamos identificar se possue pessoas com CPF inválidos.
	 * 
	 * Caso encontre CPF null ou contendo alfanúmericos, lance uma exceção contendo todos as pessoas inválidas.
	 * 
	 * Caso contrario retorne a mesma lista.
	 */
	public List<Funcionario> validarPessoasSemCPF(final List<Funcionario> pessoas) throws Exception;

	/**
	 * Dada uma lista de pessoas, precisamos identificar se possue pessoas sem salários.
	 * 
	 * Caso encontre pessoa sem salário, lance uma exceção contendo todos as pessoas inválidas.
	 * 
	 * Caso contrario retorne a mesma lista.
	 */
	public List<Funcionario> validarPessoasSemSalario(final List<Funcionario> pessoas) ;
	
}
