package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;
import br.com.qwasolucoes.mentoria.exceptions.ValidacaoException;
import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.Excecoes;
import br.com.qwasolucoes.mentoria.model.Funcionario;

import java.util.ArrayList;
import java.util.List;


public class ExcecoesProvider implements Excecoes {


    @Override
    public List<Funcionario> validarPessoasSemCPF(List<Funcionario> pessoas) {


        for (Funcionario funcionario : pessoas) {
            try {
                ValidacaoException.salario(funcionario);
            } finally {
                System.out.println("Lista de Funcionarios (CPF/CNPJ)foram validados!");
            }
        }
        return pessoas;
    }

    @Override
    public List<Funcionario> validarPessoasSemSalario(List<Funcionario> pessoas) {
        //List<Funcionario> listReturn2 = new ArrayList<>();

        for (Funcionario funcionario : pessoas) {
            try {
                ValidacaoException.salario(funcionario);
            } finally {
                System.out.println("Lista de Funcionarios (Salarios) foram validados!");
            }
        }
        return pessoas;

    }
}
