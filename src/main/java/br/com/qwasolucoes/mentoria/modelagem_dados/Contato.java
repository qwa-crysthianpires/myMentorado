package br.com.qwasolucoes.mentoria.modelagem_dados;

public class Contato {

	private String cpf;
	private TipoContato tipo;
	private String valor;
	Pessoa pessoa;

	public Contato() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoContato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Contato [cpf=" + cpf + ", tipo=" + tipo + ", valor=" + valor + "]";
	}
}
