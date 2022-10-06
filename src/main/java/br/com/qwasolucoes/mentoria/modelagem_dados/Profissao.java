package br.com.qwasolucoes.mentoria.modelagem_dados;

public class Profissao {

	private String codigoProfissao;
	private String nome;
	private String areaAtuacao;
	private String salarioBase;
	private Empresa empresa;
	
	public Profissao() {}
	
	public Profissao(String codigoProfissao, String nome, String areaAtuacao, String salarioBase) {
		this.codigoProfissao = codigoProfissao;
		this.nome = nome;
		this.areaAtuacao = areaAtuacao;
		this.salarioBase = salarioBase;
	}

	public String getCodigoProfissao() {
		return codigoProfissao;
	}

	public void setCodigoProfissao(String codigoProfissao) {
		this.codigoProfissao = codigoProfissao;
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

	public String getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(String salarioBase) {
		this.salarioBase = salarioBase;
	}
	
//	@EMPRESA

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void adicionarEmpresa(Empresa empresa) {
		this.empresa  =  empresa;
		empresa.adicionarProfissoes(this);;
	}

	@Override
	public String toString() {
		return "Profissao [codigoProfissao=" + codigoProfissao + ", nome=" + nome + ", areaAtuacao=" + areaAtuacao
				+ ", salarioBase=" + salarioBase + "]";
	}
}
