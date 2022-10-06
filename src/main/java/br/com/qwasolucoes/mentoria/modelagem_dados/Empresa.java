package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private String nome;
	private String codigo;
	private Pessoa pessoa;
	private List<Profissao> profissoes;

	public Empresa() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

//	@PESSOA
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

//	@PROFFISAO
	public List<Profissao> getProfissoes() {
		return profissoes;
	}

	public void setProfissoes(List<Profissao> profissoes) {
		this.profissoes = profissoes;
	}

	public void adicionarProfissoes(Profissao profissao) {
		this.profissoes.add(profissao);
	}

	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", codigo=" + codigo + ", pessoa=" + pessoa + ", profissoes=" + profissoes
				+ "]";
	}
}
