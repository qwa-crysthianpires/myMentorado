package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao.model;

import java.math.BigDecimal;
import java.util.Date;

public class Pessoa {
	
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
	
}
