package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import br.com.qwasolucoes.mentoria.interfaces.estrutura_dados.EstruturaDadosList;
import br.com.qwasolucoes.mentoria.model.Funcionario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class EstruturaDadosListProvider implements EstruturaDadosList {
    @Override
    public List<String> nomes(List<Funcionario> pessoas) {
        List<String> listNomes = new ArrayList<String>();

        for (Funcionario f : pessoas) {
            listNomes.add(f.getNome());
        }
        return listNomes;
    }

    @Override
    public List<String> sobrenomes(List<Funcionario> pessoas) {
        List<String> listSobrenomes = new ArrayList<String>();

        for (Funcionario f : pessoas) {
            listSobrenomes.add(f.getSobrenome());
        }
        return listSobrenomes;
    }



    @Override
    public List<Integer> maiores18(List<Funcionario> pessoas) {
        List<Integer> maiores18 = new ArrayList<Integer>();

        for (Funcionario f : pessoas) {
           if(f.getIdade() > 18){
               maiores18.add(f.getIdade());
           }
        }
        return maiores18;

    }

    @Override
    public List<Integer> menores18(List<Funcionario> pessoas) {
        List<Integer> menores18 = new ArrayList<Integer>();

        for (Funcionario f : pessoas) {
            if(f.getIdade() > 18){
                menores18.add(f.getIdade());
            }
        }
        return menores18;
    }

    @Override
    public Integer pessoaMaisVelha(List<Funcionario> pessoas) {
       int pessoaMaisVelha =0;
        for (Funcionario f : pessoas) {

            if (f.getIdade() > pessoaMaisVelha){
                pessoaMaisVelha = f.getIdade();
            }
        }
        return pessoaMaisVelha;
    }

    @Override
    public Integer pessoaMaisNova(List<Funcionario> pessoas) {
        int pessoaMaisNova =99;
        for (Funcionario f : pessoas) {

            if (f.getIdade() < pessoaMaisNova){
                pessoaMaisNova = f.getIdade();
            }
        }
        return pessoaMaisNova;
    }

    @Override
    public BigDecimal maiorSalario(List<Funcionario> pessoas) {
        BigDecimal maiorSalario = new BigDecimal(0.0);

        for (Funcionario f : pessoas) {

            if (f.getSalario().compareTo(maiorSalario) == 1){
                maiorSalario = f.getSalario();
            }
        }
        return maiorSalario;
    }

    @Override
    public BigDecimal menorTaxa(List<Funcionario> pessoas) {
        BigDecimal menorTaxa = new BigDecimal(999999);
        for (Funcionario f : pessoas) {
            if (f.getTaxa().compareTo(menorTaxa) == 1){
                menorTaxa = f.getTaxa();
            }
        }
        return menorTaxa;
    }

    @Override
    public String nomePrimeiraPessoa(List<Funcionario> pessoas) {

        String nomePrimeiraPessoa = pessoas.get(0).getNome();

        return nomePrimeiraPessoa;
    }

    @Override
    public String nomeUltimaPessoa(List<Funcionario> pessoas) {
        String nomeUltimaPessoa = pessoas.get(pessoas.size() - 1).getNome();

        return nomeUltimaPessoa;
    }

    @Override
    public String maiorNome(List<Funcionario> pessoas) {
        String maiorNome = "a";

        for (Funcionario f : pessoas) {
            if (f.getNome().length() > maiorNome.length()){
                maiorNome = f.getNome();
            }
        }
        return maiorNome;
    }

    @Override
    public String maiorNomeCompleto(List<Funcionario> pessoas) {
        String maiorNomeCompleto = "a";

        for (Funcionario f : pessoas) {
            if (f.getNome().length()+ f.getSobrenome().length() > maiorNomeCompleto.length())
            {
                maiorNomeCompleto = f.getNome() + f.getSobrenome();
            }
        }
        return maiorNomeCompleto;
    }

    @Override
    public Integer quantidadePessoasSexoMasculino(List<Funcionario> pessoas) {
       int quantidadePessoasSexoMasculino = 0;
        for (Funcionario f : pessoas) {
            if (f.getSexo().toUpperCase() == "M" || f.getSexo() == "m" ){
                quantidadePessoasSexoMasculino++;
            }
        }


       return quantidadePessoasSexoMasculino;
    }

    @Override
    public List<BigDecimal> maioresSalariosPeloValor(List<Funcionario> pessoas, BigDecimal valor) {
        List <BigDecimal> maioresSalariosPeloValor = new ArrayList<BigDecimal>();

        for (Funcionario f : pessoas) {
             if(f.getSalario().compareTo(valor) == 1) {
                 maioresSalariosPeloValor.add(f.getSalario());
             };
        }
        return null;
    }
}
