package br.com.qwasolucoes.mentoria.modelagem_dados;

public class Endereco {

	private String cpf;
	
	private TipoEndereco tipoEndereco;
	private String pais;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String complementoCep;
	
	
	public Endereco() {}
	
	public Endereco(String cpf, TipoEndereco tipoEndereco, String pais, String rua, String numero, String bairro,
			String cidade, String estado, String cep, String complementoCep) {
		super();
		this.cpf = cpf;
		this.tipoEndereco = tipoEndereco;
		this.pais = pais;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.complementoCep = complementoCep;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplementoCep() {
		return complementoCep;
	}
	public void setComplementoCep(String complementoCep) {
		this.complementoCep = complementoCep;
	}
	@Override
	public String toString() {
		return "Endereco [cpf=" + cpf + ", tipoEndereco=" + tipoEndereco + ", pais=" + pais + ", rua=" + rua
				+ ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep="
				+ cep + ", complementoCep=" + complementoCep + "]";
	}
	
	
}