package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pessoa {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private String nome;
	private String Sobrenome;
	private Date dataNascimento;
	private String sexo;
	private String cpf;
	private String estadoCivil;
	private String conjugue;
	private boolean maiorIdade;

	private Profissao profissao;
	private List<Endereco> enderecos = new ArrayList<>();
	private List<Contato> contatos = new ArrayList<>();
	private Empresa Empresa;
	private List<Formacao> formacoes;

	public Pessoa() {
	}

	public Pessoa(String nome, String sobrenome, Date dataNascimento, String sexo, String cpf, String estadoCivil,
			String conjugue) {

		this.nome = nome;
		this.Sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.estadoCivil = estadoCivil;
		this.conjugue = conjugue;
	}

	public Pessoa(String nome, String sobrenome, String sexo, String cpf, String estadoCivil, String conjugue) {
		this.nome = nome;
		this.Sobrenome = sobrenome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.estadoCivil = estadoCivil;
		this.conjugue = conjugue;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getConjugue() {
		return conjugue;
	}

	public void setConjugue(String conjugue) {
		this.conjugue = conjugue;
	}

	public boolean isMaiorIdade() {
		return maiorIdade;
	}

	public void setMaiorIdade(boolean maiorIdade) {
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco e) {
		this.enderecos.add(e);
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Empresa getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(Empresa empresa) {
		Empresa = empresa;
	}

	public List<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", Sobrenome=" + Sobrenome + ", dataNascimento=" + dataNascimento + ", sexo="
				+ sexo + ", cpf=" + cpf + ", estadoCivil=" + estadoCivil + ", conjugue=" + conjugue + ", maiorIdade="
				+ maiorIdade + ", enderecos=" + enderecos + ", contatos=" + contatos + ", Empresa=" + Empresa
				+ ", formacoes=" + formacoes + "]";
	}

	public void idade(String data) throws ParseException {

		Date dataTratada = sdf.parse(data);
		this.dataNascimento = dataTratada;

		LocalDate tempo = this.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		final LocalDate dataAtual = LocalDate.now();
		final Period periodo = Period.between(tempo, dataAtual);

		if (periodo.getYears() >= 18) {
			this.maiorIdade = true;
		} else {
			this.maiorIdade = false;
		}
	}

	public boolean pessoasPelaData(Pessoa pessoa, Integer ano) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String year = df.format(dataNascimento);

		if (ano.equals(Integer.parseInt(year))) {
			return true;
		} else {
			return false;
		}
	}

	public void adicionarContatos(Contato contato) {
		this.contatos.add(contato);
		contato.pessoa = this;
	}

}