package br.com.qwasolucoes.mentoria.interfaces.relacionamento;

import java.math.BigDecimal;
import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.Endereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;

/**
 * Precisamos criar os relacionamentos entre os modelos abaixo:
 * 
 * Pessoa 				 | possui muitos 	| Endereços
 * Pessoa 				 | possui muitos 	| Contatos
 * Pessoa 				 | trabalha em uma	| Empresa
 * Pessoa 				 | possui muitas 	| Formações
 * Pessoa 				 | casada com uma	| Pessoa (Conjuge)
 * 
 * Empresa				 | possui muitas	| Profissões
 * Instituição de Ensino | possui muitas 	| Formações
 */
public interface Relacionamentos {
	
	/**
	 * Criar e preencher as informações dos modelos com base nos (.csv na pasta resource)
	 *  e armazenar em uma estrutura de dados que preferir.
	 * 
	 * Classes dos modelos encontra-se em "br.com.qwasolucoes.mentoria.modelagem_dados"
	 * @throws Exception 
	 */
	public void iniciar() throws Exception;
	
	public List<String> buscarCPFsDasPessoasMaioresIdade();
	
	public List<String> buscarNomeSobrenomeDasPessoasPorAnorNascimento(final Integer ano);
	
	public List<String> buscarNomeSobrenomeDasPessoasPorEstadoCivil(final String estadoCivil);
	
	public List<Pessoa> buscarPessoasPorTipoResidencia(final String tipoResidencia);
	
	public List<Pessoa> buscarPessoasPorTipoContato(final String tipoContato);
	
	public List<Pessoa> buscarPessoasPorBairro(final String bairro);
	
	public List<Pessoa> buscarPessoasPorNomeBairroContem(final String valor);
	
	public List<Pessoa> buscarPessoasPorEstado(final String estado);
	
	public List<Pessoa> buscarPessoasPorProfissao(final String nomeProfissao);
	
	public List<Pessoa> buscarPessoasPorProfissaoNomeAreaAtuacaoContem(final String valor);
	
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorQue(final BigDecimal salarioBase);
	
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorIgual(final BigDecimal salarioBase);
	
	public List<Pessoa> buscarPessoasPorSalarioBaseEntre(final BigDecimal salarioBaseInicio, final BigDecimal salarioBaseFim);
	
	public List<Pessoa> buscarPessoasPorEscolaridadeConcluida();
	
	public List<Pessoa> buscarPessoasPorEscolaridadeAreaAtuacao(final String areaAtuacao);
	
	public List<Pessoa> buscarPessoasPorEscolaridadeAnoTermino(final Integer ano);
	
	public List<Pessoa> buscarPessoasPorEscolaridadeQuantidadeSemestre(final Integer semestre);
	
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(final String areaAtuacao);
	
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(final String areaAtuacao, final Integer semestre);
	
	public List<Pessoa> buscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(final String estadoCivil, final String areaAtuacaoProfissao, final String areaAtuacaoEscolaridade);
	
	public List<Endereco> buscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(final String estadoCivil);
	
	public List<Endereco> buscarEnderecoPorTipoEndereco(final String tipoEndereco);
	
	public List<Endereco> buscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(final String cidade, final String sexo, final Integer anoNascimentoConjunge);
	
	public List<String> buscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(final String estadoCivil);
	
	public List<String> buscarNomeDoConjungeDasPessoasPorEstadoCivil(final List<String> estadoCivil);
	
	public List<String> buscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(final String estadoCivil);
	
	public List<Contato> buscarContatoPorProfissaoAreaAtuacao(final String areaAtuacao);
	
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(final String areaAtuacao, final String estado, final String bairro);
	
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(final String areaAtuacao, final List<String> estados, final String bairro);
	
	public List<Contato> buscarContatoPorTipoContato(final String tipoContato);
	
	public List<Contato> buscarContatoPorTiposContato(final List<String> tipoContato);
	
	public List<String> buscarEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(final Integer anoNasicmento, final String areaAtuacaoProfissao, final String areaAtuacaoEscolaridade);
	
	public List<String> buscarNomeInstituicaoPorPorAreaAtuacao(final String areaAtuacaoProfissao);
	
	public List<String> buscarNomePessoasPorProfissaoPorAreaAtuacao(final String areaAtuacaoProfissao);
	
	public List<String> buscarNomePessoasPorEscolaridadePorAreaAtuacao(final String areaAtuacaoEscolaridade);
	
	public Integer buscarQuantidadeTotalPessoasPorProfissaoPorAreaAtuacao(final String areaAtuacaoProfissao);
	
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(final String areaAtuacaoEscolaridade);
	
	public Integer buscarQuantidadeTotalPessoasMaioresIdade();
	
	public Integer buscarQuantidadeTotalDasPessoasPorEstadoCivil(final String estadoCivil);
	
	public Integer buscarQuantidadeTotalPessoasPorBairro(final String bairro);
	
	public Integer buscarQuantidadeTotalPessoasPorProfissao(final String nomeProfissao);
	
	public Integer buscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(final BigDecimal salarioBase);
	
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(final String areaAtuacao);
	
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(final Integer semestre);
	
	public Integer buscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(final String areaAtuacao, final Integer semestre);

	public Integer buscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(final Integer anoNasicmento, final String areaAtuacaoProfissao, final String areaAtuacaoEscolaridade);
	
	public Integer buscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(final String estadoCivil);
	
	public Integer buscarQuantidadeTotalContatosPorTipoContato(final String tipoContato);
	
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida();
	
	public Integer buscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(final String bairro, final String areaAtuacaoProfissao);

	public Integer buscarQuantidadeTotalContatoPorTiposContato(final List<String> tipoContato);


}
