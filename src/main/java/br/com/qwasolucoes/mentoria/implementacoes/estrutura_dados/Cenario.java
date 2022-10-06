package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import br.com.qwasolucoes.mentoria.model.ContatoFuncionario;
import br.com.qwasolucoes.mentoria.model.Funcionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cenario {

    public static void main(String[] args){
        EstruturaDadosMapProvider edmp = new EstruturaDadosMapProvider();

        List<String> abc = new ArrayList<>();

        abc.add("444.444.444-44");
        abc.add("(69) 2165-8863, (89) 2308-9519, (84) 2272-3614,(11) 3374-5211,(51) 2162-4435,(82) 3638-2155");
        abc.add("444.444.444-44");
        abc.add("(69) 2404-3653, (67) 3838-6172,(88) 2122-6117,(79) 2384-3617,(88) 2171-4534,(89) 2784-5114");



        Map<Funcionario, List<ContatoFuncionario>> mapaFrequenciaValoresOutput = edmp.cpfCnpjTelefonesObjeto(abc);

        System.out.println(mapaFrequenciaValoresOutput.toString());
    }
}
