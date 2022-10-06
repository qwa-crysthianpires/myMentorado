package br.com.qwasolucoes.mentoria.interfaces.banco_dados;

import java.math.BigDecimal;
import java.util.List;

/**
 * Precisamos criar os relacionamentos entre os modelos abaixo:
 * 
 * Pessoa 				 | possui muitos 	| Endereços
 * Pessoa 				 | possui muitos 	| Contatos
 * Pessoa 				 | trabalha em uma	| Empresa
 * Pessoa 				 | possui muitas 	| Formações
 * Pessoa 				 | casada com uma	| Pessoa (Conjuge)
 * Empresa				 | possui muitas	| Profissões
 * Instituição de Ensino | possui muitas 	| Formações
 */
public interface BancoDados {

	/**
	 * Criar a DDL da estrutura do banco seguindo o relacionamentos acima.
	 */
	public void iniciarDDL();
	
	/**
	 * Criar os inserts das tabelas com base nos (.csv na pasta resource).
	 * 
	 * Classes dos modelos encontra-se em "br.com.qwasolucoes.mentoria.modelagem_dados"
	 * 
	 * Obs: O retorno será uma lista, um insert por elemento da lista.
	 */
	public List<String> iniciarInserts();
	
	public String criarSQLBuscarCPFsDasPessoasMaioresIdade();
	
	public String criarSQLBuscarNomeSobrenomeDasPessoasPorAnorNascimento(final Integer ano);

	public String criarSQLBuscarNomeSobrenomeDasPessoasPorEstadoCivil(final String estadoCivil);

	public String criarSQLBuscarPessoasPorTipoResidencia(final String tipoResidencia);

	public String criarSQLBuscarPessoasPorTipoContato(final String tipoContato);

	public String criarSQLBuscarPessoasPorBairro(final String bairro);

	public String criarSQLBuscarPessoasPorNomeBairroContem(final String valor);

	public String criarSQLBuscarPessoasPorEstado(final String estado);

	public String criarSQLBuscarPessoasPorProfissao(final String nomeProfissao);

	public String criarSQLBuscarPessoasPorProfissaoNomeAreaAtuacaoContem(final String valor);

	public String criarSQLBuscarPessoasPorSalarioBaseMaiorQue(final BigDecimal salarioBase);

	public String criarSQLBuscarPessoasPorSalarioBaseMaiorIgual(final BigDecimal salarioBase);

	public String criarSQLBuscarPessoasPorSalarioBaseEntre(final BigDecimal salarioBaseInicio, final BigDecimal salarioBaseFim);

	public String criarSQLBuscarPessoasPorEscolaridadeConcluida();

	public String criarSQLBuscarPessoasPorEscolaridadeAreaAtuacao(final String areaAtuacao);

	public String criarSQLBuscarPessoasPorEscolaridadeAnoTermino(final Integer ano);

	public String criarSQLBuscarPessoasPorEscolaridadeQuantidadeSemestre(final Integer semestre);

	public String criarSQLBuscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(final String areaAtuacao);

	public String criarSQLBuscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(final String areaAtuacao, final Integer semestre);

	public String criarSQLBuscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(final String estadoCivil, final String areaAtuacaoProfissao, final String areaAtuacaoEscolaridade);

	public String criarSQLBuscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(final String estadoCivil);

	public String criarSQLBuscarEnderecoPorTipoEndereco(final String tipoEndereco);

	public String criarSQLBuscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(final String cidade, final String sexo, final Integer anoNascimentoConjunge);

	public String criarSQLBuscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(final String estadoCivil);

	public String criarSQLBuscarNomeDoConjungeDasPessoasPorEstadoCivil(final List<String> estadoCivil);

	public String criarSQLBuscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(final String estadoCivil);

	public String criarSQLBuscarContatoPorProfissaoAreaAtuacao(final String areaAtuacao);

	public String criarSQLBuscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(final String areaAtuacao, final String estado, final String bairro);

	public String criarSQLBuscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(final String areaAtuacao, final List<String> estados, final String bairro);

	public String criarSQLBuscarContatoPorTipoContato(final String tipoContato);

	public String criarSQLBuscarContatoPorTiposContato(final List<String> tipoContato);

	public String criarSQLBuscarEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(final Integer anoNasicmento, final String areaAtuacaoProfissao, final String areaAtuacaoEscolaridade);

	public String criarSQLBuscarNomeInstituicaoPorPorAreaAtuacao(final String areaAtuacaoProfissao);
	
	public String criarSQLBuscarNomePessoasPorProfissaoPorAreaAtuacao(final String areaAtuacaoProfissao);

	public String criarSQLBuscarNomePessoasPorEscolaridadePorAreaAtuacao(final String areaAtuacaoEscolaridade);

	public String criarSQLBuscarQuantidadeTotalPessoasPorProfissaoPorAreaAtuacao(final String areaAtuacaoProfissao);

	public String criarSQLBuscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(final String areaAtuacaoEscolaridade);

	public String criarSQLBuscarQuantidadeTotalPessoasMaioresIdade();

	public String criarSQLBuscarQuantidadeTotalDasPessoasPorEstadoCivil(final String estadoCivil);

	public String criarSQLBuscarQuantidadeTotalPessoasPorBairro(final String bairro);

	public String criarSQLBuscarQuantidadeTotalPessoasPorProfissao(final String nomeProfissao);

	public String criarSQLBuscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(final BigDecimal salarioBase);

	public String criarSQLBuscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(final String areaAtuacao);

	public String criarSQLBuscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(final Integer semestre);

	public String criarSQLBuscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(final String areaAtuacao, final Integer semestre);

	public String criarSQLBuscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(final Integer anoNasicmento, final String areaAtuacaoProfissao, final String areaAtuacaoEscolaridade);

	public String criarSQLBuscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(final String estadoCivil);

	public String criarSQLBuscarQuantidadeTotalContatosPorTipoContato(final String tipoContato);

	public String criarSQLBuscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida();

	public String criarSQLBuscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(final String bairro, final String areaAtuacaoProfissao);

	public String criarSQLBuscarQuantidadeTotalContatoPorTiposContato(final List<String> tipoContato);
	
}
