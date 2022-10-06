package br.com.qwasolucoes.mentoria.modelagem_dados;

public class InstituicaoEnsino {

	private String codigo;
	private String nome;
	private String areaAtuacao;
	private String quantidadeSemestres;

	public InstituicaoEnsino(String codigo, String nome, String areaAtuacao, String quantidadeSemestres) {
		this.codigo = codigo;
		this.nome = nome;
		this.areaAtuacao = areaAtuacao;
		this.quantidadeSemestres = quantidadeSemestres;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getQuantidadeSemestres() {
		return quantidadeSemestres;
	}

	public void setQuantidadeSemestres(String quantidadeSemestres) {
		this.quantidadeSemestres = quantidadeSemestres;
	}

	@Override
	public String toString() {
		return "InstituicaoEnsino [codigo=" + codigo + ", nome=" + nome + ", areaAtuacao=" + areaAtuacao
				+ ", quantidadeSemestres=" + quantidadeSemestres + "]";
	}

}
