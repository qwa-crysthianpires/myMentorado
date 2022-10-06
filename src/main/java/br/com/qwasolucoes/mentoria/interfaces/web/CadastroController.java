package br.com.qwasolucoes.mentoria.interfaces.web;

import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;

public interface CadastroController {

	public void cadastrar(Pessoa pessoa);
	
	public void atualizar(String id, Pessoa pessoa);
	
	public void deletar(String id);
	
	public void buscarPorIdentificador(String id);

}
