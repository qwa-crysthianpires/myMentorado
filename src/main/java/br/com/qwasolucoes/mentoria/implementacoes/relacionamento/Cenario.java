package br.com.qwasolucoes.mentoria.implementacoes.relacionamento;

import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;

public class Cenario {

	public static void main(String[] args) {

		RelacionamentosProvider rp = new RelacionamentosProvider();

		try {
			rp.iniciar();

//			List<String> a = rp.buscarCPFsDasPessoasMaioresIdade();
//			System.out.println("CPF Maiores de Idade -> " + a);
//
//			List<String> b = rp.buscarNomeSobrenomeDasPessoasPorAnorNascimento(2000);
//			System.out.println("CPF Nome/Sobrenome pela Data -> " + b);
//
//			List<String> c = rp.buscarNomeSobrenomeDasPessoasPorEstadoCivil("SOLTEIRO");
//			System.out.println("Nome/Sobrenome pela Estado Civil -> " + c);
//
//			List<Pessoa> d = rp.buscarPessoasPorTipoContato("Telefone");
//			System.out.println("Pessoa que tem e-mail -> " + d);
//
//			List<Pessoa> e = rp.buscarPessoasPorBairro("Bairro 125");
//			System.out.println("Pessoas que moram no Bairro  ->"  + e);
//			
//			List<Pessoa> f = rp.buscarPessoasPorNomeBairroContem("Limao");
//			System.out.println("Pessoas pelo NomeBairroContem -> " + f);
//			
//			List<Pessoa> g = rp.buscarPessoasPorEstado("PR");
//			System.out.println("Pessoas pelo Estado -> " + g);
			
			List<Pessoa> h = rp.buscarPessoasPorProfissao("Engenheiro civil");
			System.out.println("Pessoas pela Profissao -> " + h);
			
			
		} catch (Exception e) {
			System.out.println("ERRO CENARIO: " + e.getMessage());
		}
	}

}
