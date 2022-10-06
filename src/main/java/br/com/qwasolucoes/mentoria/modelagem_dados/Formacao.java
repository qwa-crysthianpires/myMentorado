package br.com.qwasolucoes.mentoria.modelagem_dados;

public class Formacao {

	private String cpf;
	private String codigo;
	private String conclusao;
	private String dataTermino;
	private String semestreAtual;

	public Formacao(String cpf, String codigo, String conclusao, String dataTermino, String semestreAtual) {
		this.cpf = cpf;
		this.codigo = codigo;
		this.conclusao = conclusao;
		this.dataTermino = dataTermino;
		this.semestreAtual = semestreAtual;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getSemestreAtual() {
		return semestreAtual;
	}

	public void setSemestreAtual(String semestreAtual) {
		this.semestreAtual = semestreAtual;
	}

	@Override
	public String toString() {
		return "Formacao [cpf=" + cpf + ", codigo=" + codigo + ", conclusao=" + conclusao + ", dataTermino="
				+ dataTermino + ", semestreAtual=" + semestreAtual + "]";
	}

}
