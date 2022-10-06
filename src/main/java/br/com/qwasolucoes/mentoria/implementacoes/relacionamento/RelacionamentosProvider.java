package br.com.qwasolucoes.mentoria.implementacoes.relacionamento;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import br.com.qwasolucoes.mentoria.interfaces.relacionamento.Relacionamentos;
import br.com.qwasolucoes.mentoria.modelagem_dados.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.Empresa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Endereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Profissao;
import br.com.qwasolucoes.mentoria.modelagem_dados.TipoContato;
import br.com.qwasolucoes.mentoria.modelagem_dados.TipoEndereco;

public class RelacionamentosProvider implements Relacionamentos {
//	private final static List<Pessoa> listaPessoas = new ArrayList<>();
	private final static Map<String, Pessoa> listaPessoas = new HashMap<>();
	private final static Map<String, Empresa> listaEmpresas = new HashMap<>();
	private final static Map<String, Profissao> listaProfissoes = new HashMap<>();

	private static final String CSV_FILE_PATH_CONTATO = "C:\\Dev\\mentoradosts\\MeuMentorado\\src\\main\\resources\\br\\com\\qwasolucoes\\mentoria\\modelagem_dados\\Contato.csv";
	private static final String CSV_FILE_PATH_EMPRESA = "C:\\Dev\\mentoradosts\\MeuMentorado\\src\\main\\resources\\br\\com\\qwasolucoes\\mentoria\\modelagem_dados\\Empresa.csv";
//	private static final String CSV_FILE_PATH_ESTAGIO = "C:\\Dev\\mentoradosts\\MeuMentorado\\src\\main\\resources\\br\\com\\qwasolucoes\\mentoria\\modelagem_dados\\Estágio - Contato.csv";
	private static final String CSV_FILE_PATH_ENDERECO = "C:\\Dev\\mentoradosts\\MeuMentorado\\src\\main\\resources\\br\\com\\qwasolucoes\\mentoria\\modelagem_dados\\Endereco.csv";
//	
//	private static final String CSV_FILE_PATH_ESCOLARIDADE = "C:\\Dev\\mentoradosts\\MeuMentorado\\src\\main\\resources\\br\\com\\qwasolucoes\\mentoria\\modelagem_dados\\Escolaridade.csv";
//	private static final String CSV_FILE_PATH_INST_ENSINO = "C:\\Dev\\mentoradosts\\MeuMentorado\\src\\main\\resources\\br\\com\\qwasolucoes\\mentoria\\modelagem_dados\\Instituição de Ensino.csv";
	private static final String CSV_FILE_PATH_PESSOA = "C:\\Dev\\mentoradosts\\MeuMentorado\\src\\main\\resources\\br\\com\\qwasolucoes\\mentoria\\modelagem_dados\\Pessoa.csv";
	private static final String CSV_FILE_PATH_PROFISSAO = "C:\\Dev\\mentoradosts\\MeuMentorado\\src\\main\\resources\\br\\com\\qwasolucoes\\mentoria\\modelagem_dados\\Profissão.csv";
//	private static final String CSV_FILE_PATH_TIPO_ENDERECO = "C:\\Dev\\mentoradosts\\MeuMentorado\\src\\main\\resources\\br\\com\\qwasolucoes\\mentoria\\modelagem_dados\\Tipo Endereço.csv";
	private List<Endereco> enderecos;
	private List<Profissao> profissoes;


	@Override
	public void iniciar() throws Exception {

		try {

			pessoaInitialzr();
			contatoInitialzr();
			enderecoInitialzr();
			empresaInitialzr();
			profissaoInitialzr();
			for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
				System.out.println(pessoa.getValue());
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("INICIALIZADOS C/ SUCESSO");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	@Override
	public List<String> buscarCPFsDasPessoasMaioresIdade() {
		List<String> cpfMaioresIdades = new ArrayList<>();
		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
				if (pessoa.getValue().isMaiorIdade()) {
					cpfMaioresIdades.add(pessoa.getValue().getCpf());
				}
			}
		}
		return cpfMaioresIdades;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorAnorNascimento(Integer ano) {
		List<String> pessoasPelaDataNasc = new ArrayList<>();
		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
				if (pessoa.getValue().pessoasPelaData(pessoa.getValue(), ano)) {
					pessoasPelaDataNasc.add(pessoa.getValue().getNome() + " " + pessoa.getValue().getSobrenome());
				}
			}
		}
		return pessoasPelaDataNasc;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorEstadoCivil(String estadoCivil) {
		List<String> pessoasPeloEstadoCivil = new ArrayList<>();
		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
				if (pessoa.getValue().getEstadoCivil().equals(estadoCivil)) {
					pessoasPeloEstadoCivil.add(pessoa.getValue().getNome() + " " + pessoa.getValue().getSobrenome());
				}
			}
		}
		return pessoasPeloEstadoCivil;
	}

	@Override
	public List<Pessoa> buscarPessoasPorTipoResidencia(String tipoResidencia) {
		List<Pessoa> pessoasPeloTipoResidencia = new ArrayList<>();
		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
				if (pessoa.getValue().getEnderecos().equals(tipoResidencia)) {
					pessoasPeloTipoResidencia.add(pessoa.getValue());
				}
			}
		}
		return pessoasPeloTipoResidencia;
	}

	@Override
	public List<Pessoa> buscarPessoasPorTipoContato(String tipoContato) {
		List<Pessoa> pessoasPorTipoContato = new ArrayList<>();

		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
				List<Contato> contatos = pessoa.getValue().getContatos();
				for (Contato contato : contatos) {

//					se for email, adiciona a pessoa na lista
					if (contato.getTipo().getValue().equalsIgnoreCase(tipoContato)) {
						pessoasPorTipoContato.add(pessoa.getValue());
					}
				}
			}
		}
		return pessoasPorTipoContato;
	}

	@Override
	public List<Pessoa> buscarPessoasPorBairro(String bairro) {
		List<Pessoa> pessoasPessoasPorBairro = new ArrayList<>();

		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
				enderecos = pessoa.getValue().getEnderecos();
				for (Endereco endereco : enderecos) {
					if (endereco.getBairro().equals(bairro)) {
						pessoasPessoasPorBairro.add(pessoa.getValue());
					}
				}
			}
		}

		return pessoasPessoasPorBairro;
	}

	@Override
	public List<Pessoa> buscarPessoasPorNomeBairroContem(String valor) {
		List<Pessoa> pessoasPessoasPorNomeBairroContem = new ArrayList<>();

		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
				enderecos = pessoa.getValue().getEnderecos();
				for (Endereco endereco : enderecos) {
					String nomeBairro = endereco.getBairro();
					if (nomeBairro.indexOf(valor) >= 0) {
						pessoasPessoasPorNomeBairroContem.add(pessoa.getValue());
					}
				}
			}
		}
		return pessoasPessoasPorNomeBairroContem;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEstado(String estado) {
		List<Pessoa> pessoasPessoasPorEstado = new ArrayList<>();

		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
				enderecos = pessoa.getValue().getEnderecos();
				for (Endereco endereco : enderecos) {
					String estadoPessoa = endereco.getEstado();
					if (estadoPessoa.equals(estado)) {
						pessoasPessoasPorEstado.add(pessoa.getValue());
					}
				}
			}
		}

		return pessoasPessoasPorEstado;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissao(String nomeProfissao) {
		List<Pessoa> pessoasPessoasPorProfissao = new ArrayList<>();
		try {
			for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
				System.out.println(pessoa.getValue().getProfissao());
				if (pessoa.getKey() != null && pessoa.getValue() != null) {
					Profissao profissao = pessoa.getValue().getProfissao();
					System.out.println(profissao.getNome());
//					if (profissao.getNome().equals(nomeProfissao)) {
//						pessoasPessoasPorProfissao.add(pessoa.getValue());
//					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return pessoasPessoasPorProfissao;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoNomeAreaAtuacaoContem(String valor) {
		List<Pessoa> pessoasPessoasPorProfissaoNomeAreaAtuacaoContem = new ArrayList<>();

		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
			}
		}

		return pessoasPessoasPorProfissaoNomeAreaAtuacaoContem;
	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorQue(BigDecimal salarioBase) {
		List<Pessoa> pessoasPessoasPorSalarioBaseMaiorQue = new ArrayList<>();

		for (Map.Entry<String, Pessoa> pessoa : listaPessoas.entrySet()) {
			if (pessoa.getKey() != null && pessoa.getValue() != null) {
			}
		}

		return pessoasPessoasPorSalarioBaseMaiorQue;
	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {
		List<Pessoa> pessoasPessoasPorSalarioBaseMaiorIgual = new ArrayList<>();

		return pessoasPessoasPorSalarioBaseMaiorIgual;
	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseEntre(BigDecimal salarioBaseInicio, BigDecimal salarioBaseFim) {
		List<Pessoa> pessoasPessoasPorSalarioBaseEntre = new ArrayList<>();

		return pessoasPessoasPorSalarioBaseEntre;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeConcluida() {
		List<Pessoa> pessoasPessoasPorEscolaridadeConcluida = new ArrayList<>();

		return pessoasPessoasPorEscolaridadeConcluida;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		List<Pessoa> pessoasPessoasPorEscolaridadeAreaAtuacao = new ArrayList<>();

		return pessoasPessoasPorEscolaridadeAreaAtuacao;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAnoTermino(Integer ano) {
		List<Pessoa> pessoasPessoasPorEscolaridadeAnoTermino = new ArrayList<>();

		return pessoasPessoasPorEscolaridadeAnoTermino;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		List<Pessoa> pessoasPessoasPorEscolaridadeQuantidadeSemestre = new ArrayList<>();

		return pessoasPessoasPorEscolaridadeQuantidadeSemestre;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(String areaAtuacao) {
		List<Pessoa> pessoasbuscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido = new ArrayList<>();

		return pessoasbuscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		return null;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(String estadoCivil,
			String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		return null;
	}

	@Override
	public List<Endereco> buscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		return null;
	}

	@Override
	public List<Endereco> buscarEnderecoPorTipoEndereco(String tipoEndereco) {
		return null;
	}

	@Override
	public List<Endereco> buscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(String cidade,
			String sexo, Integer anoNascimentoConjunge) {
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasPorEstadoCivil(List<String> estadoCivil) {
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(String estadoCivil) {
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacao(String areaAtuacao) {
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(String areaAtuacao, String estado,
			String bairro) {
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(String areaAtuacao,
			List<String> estados, String bairro) {
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorTipoContato(String tipoContato) {
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorTiposContato(List<String> tipoContato) {
		return null;
	}

	@Override
	public List<String> buscarEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		return null;
	}

	@Override
	public List<String> buscarNomeInstituicaoPorPorAreaAtuacao(String areaAtuacaoProfissao) {
		return null;
	}

	@Override
	public List<String> buscarNomePessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {
		return null;
	}

	@Override
	public List<String> buscarNomePessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasMaioresIdade() {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalDasPessoasPorEstadoCivil(String estadoCivil) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairro(String bairro) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissao(String nomeProfissao) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalContatosPorTipoContato(String tipoContato) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida() {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(String bairro,
			String areaAtuacaoProfissao) {
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalContatoPorTiposContato(List<String> tipoContato) {
		return null;
	}

//
//		@@@ INICIANDO CSV, POPULANDO AS CLASSES @@@
//	
	private static void pessoaInitialzr() {

		try {

			String[] nextRecord;
			FileReader filereader = new FileReader(CSV_FILE_PATH_PESSOA);
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();

			while ((nextRecord = csvReader.readNext()) != null) {

				Pessoa pessoa = new Pessoa();
				pessoa.setNome(nextRecord[0]);
				pessoa.setSobrenome(nextRecord[1]);
				pessoa.idade(nextRecord[2]);
				pessoa.setSexo(nextRecord[3]);
				pessoa.setCpf(nextRecord[4]);
				pessoa.setEstadoCivil(nextRecord[5]);
				pessoa.setConjugue(nextRecord[6]);

				String chave = nextRecord[4];
				listaPessoas.put(chave, pessoa);
				
			}

		} catch (Exception e) {
			System.out.println("Erro pessoaInitialzr: " + e.getMessage());
		}
	}

	private static void contatoInitialzr() {
		try {
			String[] nextRecord;
			FileReader filereader = new FileReader(CSV_FILE_PATH_CONTATO);
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();

			while ((nextRecord = csvReader.readNext()) != null) {
				String cpf = nextRecord[0];
				String tipo = nextRecord[1];
				String valor = nextRecord[2];

				Integer tipoInteiro = Integer.parseInt(tipo);

				Pessoa pessoa = listaPessoas.get(cpf);

				if (tipoInteiro == 1) {
					Contato contato = new Contato();
					contato.setCpf(cpf);
					contato.setTipo(TipoContato.TELEFONE);
					contato.setValor(valor);
					pessoa.adicionarContatos(contato);

				} else if (tipoInteiro == 2) {

					Contato contato = new Contato();
					contato.setCpf(cpf);
					contato.setTipo(TipoContato.CELULAR);
					contato.setValor(valor);
					pessoa.adicionarContatos(contato);
				} else if (tipoInteiro == 3) {

					Contato contato = new Contato();
					contato.setCpf(cpf);
					contato.setTipo(TipoContato.CELULAR);
					contato.setValor(valor);
					pessoa.adicionarContatos(contato);
				} else {
					System.out.println("NENHUM DOS 3");
				}

			}
		} catch (Exception e) {
			System.out.println("Erro contatoInitialzr: " + e.getMessage());
		}
	}

	private static void enderecoInitialzr() {
		try {
			String[] nextRecord;
			FileReader filereader = new FileReader(CSV_FILE_PATH_ENDERECO);
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();

			while ((nextRecord = csvReader.readNext()) != null) {
				Endereco endereco = new Endereco();
				endereco.setCpf(nextRecord[0]);
				endereco.setPais(nextRecord[2]);
				endereco.setRua(nextRecord[3]);
				endereco.setNumero(nextRecord[4]);
				endereco.setBairro(nextRecord[5]);
				endereco.setCidade(nextRecord[6]);
				endereco.setEstado(nextRecord[7]);
				endereco.setCep(nextRecord[8]);
				endereco.setComplementoCep(nextRecord[9]);

				String tipo = nextRecord[1];
				if (tipo.equals("R")) {
					endereco.setTipoEndereco(TipoEndereco.R);
				} else if (tipo.equals("P")) {
					endereco.setTipoEndereco(TipoEndereco.P);
				}

				Pessoa pessoa = listaPessoas.get(nextRecord[0]);
				pessoa.setEnderecos(endereco);

//				System.out.println("EnderecoINITIALZR: " + endereco);
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void profissaoInitialzr() {
		try {
			String[] nextRecord;
			FileReader filereader = new FileReader(CSV_FILE_PATH_PROFISSAO);
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();

			while ((nextRecord = csvReader.readNext()) != null) {
				Profissao profissao = new Profissao();
				profissao.setCodigoProfissao(nextRecord[0]);
				profissao.setNome(nextRecord[1]);
				profissao.setAreaAtuacao(nextRecord[2]);
				profissao.setSalarioBase(nextRecord[3]);
				listaProfissoes.put(nextRecord[0], profissao);
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void empresaInitialzr() {
		try {
			String[] nextRecord;
			FileReader filereader = new FileReader(CSV_FILE_PATH_EMPRESA);
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();

			while ((nextRecord = csvReader.readNext()) != null) {
				Empresa empresa = new Empresa();
				Pessoa pessoa = listaPessoas.get(nextRecord[2]);
				empresa.setNome(nextRecord[0]);
				empresa.setCodigo(nextRecord[1]);
				empresa.setPessoa(pessoa);
				listaEmpresas.put(nextRecord[1], empresa);
				
			}
		} catch (Exception e) {
			System.out.println("ERRO EMPRESA " + e.getMessage());
		}
	}
	
}
