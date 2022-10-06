package br.com.qwasolucoes.mentoria.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Objects;

public class Funcionario {

	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private Integer idade;
	private String sexo;
	private String profissao;
	private String cpfCnpj;
	private String escolaridade;
	private BigDecimal salario;
	private boolean maiorIdade;
	private BigDecimal taxa;


	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	public Funcionario(){}


	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getProfissao() {
		return profissao;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public boolean isMaiorIdade() {
		return maiorIdade;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public void setMaiorIdade(boolean maiorIdade) {
		this.maiorIdade = maiorIdade;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Funcionario)) return false;
		Funcionario that = (Funcionario) o;
		return isMaiorIdade() == that.isMaiorIdade() && getNome().equals(that.getNome()) && getSobrenome().equals(that.getSobrenome()) && getDataNascimento().equals(that.getDataNascimento()) && getIdade().equals(that.getIdade()) && getSexo().equals(that.getSexo()) && getProfissao().equals(that.getProfissao()) && getCpfCnpj().equals(that.getCpfCnpj()) && getEscolaridade().equals(that.getEscolaridade()) && getSalario().equals(that.getSalario()) && getTaxa().equals(that.getTaxa());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNome(), getSobrenome(), getDataNascimento(), getIdade(), getSexo(), getProfissao(), getCpfCnpj(), getEscolaridade(), getSalario(), isMaiorIdade(), getTaxa());
	}

	@Override
	public String toString() {
		return "Funcionario{" +
				"nome='" + nome + '\'' +
				", sobrenome='" + sobrenome + '\'' +
				", dataNascimento=" + sdf.format(dataNascimento) +
				", idade=" + idade +
				", sexo='" + sexo + '\'' +
				", profissao='" + profissao + '\'' +
				", cpfCnpj='" + cpfCnpj + '\'' +
				", escolaridade='" + escolaridade + '\'' +
				", salario=" + salario +
				", maiorIdade=" + maiorIdade +
				", taxa=" + taxa +
				'}';
	}

	public static int calculaIdade(final LocalDate aniversario) {
		final LocalDate dataAtual = LocalDate.now();
		final Period periodo = Period.between(aniversario, dataAtual);
		return periodo.getYears();
	}

	public void calculoTaxa(int idade) {
		if (idade < 18) {
			setTaxa(new BigDecimal("0.20"));
		} else if (idade < 23) {
			setTaxa(new BigDecimal("0.15"));
		} else if (idade < 31) {
			setTaxa(new BigDecimal("0.10"));
		} else if (idade < 50) {
			setTaxa(new BigDecimal("0.05"));
		} else {
			setTaxa(new BigDecimal("0.01"));
		}
	}

	public static String validacaoString(String string, int quantidade){

		StringBuilder sb = new StringBuilder();
		sb.append(string);
		int stringTamanho = string.length();
		int stringComplete = quantidade - stringTamanho;

		for(int i = 0; i < stringComplete; i++){sb.append(" ");}
		return sb.toString();
	}

	public static int[] addX(int n, int arr[], int x)
	{
		int i;

		int[] arrayTemp = new int[n + 1];

		for (i = 0; i < n; i++)
			arrayTemp[i] = arr[i];

		arrayTemp[n] = x;

		return arrayTemp;
	}
}
