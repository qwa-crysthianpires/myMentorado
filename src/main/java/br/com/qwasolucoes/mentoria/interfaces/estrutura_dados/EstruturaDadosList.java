package br.com.qwasolucoes.mentoria.interfaces.estrutura_dados;

import java.math.BigDecimal;
import java.util.List;

import br.com.qwasolucoes.mentoria.model.Funcionario;

public interface EstruturaDadosList {

	public List<String> nomes(final List<Funcionario> pessoas);
	
	public List<String> sobrenomes(final List<Funcionario> pessoas);
	
	public List<Integer> maiores18(final List<Funcionario> pessoas);
	
	public List<Integer> menores18(final List<Funcionario> pessoas);
	
	public Integer pessoaMaisVelha(final List<Funcionario> pessoas);
	
	public Integer pessoaMaisNova(final List<Funcionario> pessoas);
	
	public BigDecimal maiorSalario(final List<Funcionario> pessoas);
	
	public BigDecimal menorTaxa(final List<Funcionario> pessoas);
	
	public String nomePrimeiraPessoa(final List<Funcionario> pessoas);
	
	public String nomeUltimaPessoa(final List<Funcionario> pessoas);
	
	public String maiorNome(final List<Funcionario> pessoas);
	
	public String maiorNomeCompleto(final List<Funcionario> pessoas);
	
	public Integer quantidadePessoasSexoMasculino(final List<Funcionario> pessoas);
	
	public List<BigDecimal> maioresSalariosPeloValor(final List<Funcionario> pessoas, BigDecimal valor);

}
