package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;

import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.LogicaProgramacao;
import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.LogicaProgramacaoFaturamento;
import br.com.qwasolucoes.mentoria.model.Funcionario;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cenario {

    public static void main(String[] args) throws ParseException {
//
        LogicaProgramacao lpp = new LogicaProgramacaoProvider();
        LogicaProgramacaoFaturamento lpf = new LogicaProgramacaoFaturamentoProvider();
//
        int[] arrayInt = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6};
        Integer[] arrayInteger = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6};
        String[] arrayString = {"Roxo","Roxo","ouro","Magneta","cinza","cinza","Azul","Azul","Amarelo","Amarelo","Laranja","Laranja","Rosa","Rosa","Azul"};
        String[][] arrayValores = {{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};

//        List<String> listDiego = new ArrayList<String>();
//        listDiego.add("A");
//        listDiego.add("B");
//        listDiego.add("A");
//        listDiego.add("C");
//        listDiego.add("A");
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("1 - LISTA P/ OBJETO");
//
//
//        List<String> lista = new ArrayList<>();
//        String f1 = "Marcos              Silveira            27071997MVendedor                                12345678000191Superior Incompleto                     2000.00   ";
//        String f2 = "Joao                Silva               27072010MVendedor                                99933366611   Superior Incompleto                     2000.00   ";
//        String f3 = "Ronan               Marquinhos          27071985MVendedor                                33322244499   Superior Incompleto                     2000.00   ";
//        String f4 = "Marilia             Mendonça            27071960MVendedor                                99999999000191Superior Incompleto                     2000.00   ";
//
//        lista.add(f1);
//        lista.add(f2);
//        lista.add(f3);
//        lista.add(f4);
//
//        List<Funcionario> listaFuncionario1 = lpp.conversaoStringParaPessoa(lista);
//
//        for (Funcionario f11 : listaFuncionario1) {
//            System.out.println(f11);
//        }
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("2 - OBJETO P/ LISTA");
//        List<String> novaFuncionario = lpp.conversaoPessoaParaString(listaFuncionario1);
//        System.out.println(novaFuncionario);
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("3 - ARRAY P/ OBJETO");
//
//        String[] arrayFuncionarios = new String[]{"Marcos", "Silveira", "27071997", "M", "Vendedor", "12345678000191", "Superior Incompleto", "2000.00"};
//        Funcionario func = lpp.conversaoArrayParaPessoa(arrayFuncionarios);
//        System.out.println(func);
//
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("4 - ARRAY MULTIDIMENSIONAL");
//
//        String[][] arrayMultidimensionalFuncionario = new String[3][];
//
//
//        arrayMultidimensionalFuncionario[0] = func0;
//        arrayMultidimensionalFuncionario[1] = func1;
//        arrayMultidimensionalFuncionario[2] = func2;
//
//        List<Funcionario> listFuncionario1 = lpp.conversaoArrayMultidimensionalParaPessoa(arrayMultidimensionalFuncionario);
//
//        for (Funcionario linha : listFuncionario1) {
//            System.out.println(linha);
//        }
//
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("5 - arrayMultidimensionalParesImparesPrimosResto");
//
//        int[] arrayValoresInteiros = {1,2,3,4, 5,6,7,8,9,10,11,12,13,14,15,16};
//        int[][] input = lpp.arrayMultidimensionalParesImparesPrimosResto(arrayValoresInteiros, 3);
//
//        for (int[] linha : input) {
//            System.out.println(Arrays.toString(linha));
//        }
//
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("6 - arrayMultidimensionalPorPosicoes");
//
//
//        String[] arrayInput = lpp.arrayMultidimensionalPorPosicoes(arrayValores,1, 1);
//
//        System.out.println(Arrays.deepToString(arrayInput));
//
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("7 - antecessorSucessorPorPOSIÇÃO");
//
//        String[] arraySeteInput = {"0", "1", "2", "3", "4", "5","6","7","8","9"};
//        String[] arraySeteOutput = lpp.antecessorSucessorPor(arraySeteInput,3);
//        System.out.println(Arrays.deepToString(arraySeteOutput));
//
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("8 - antecessorSucessorPorVALOR");
//
//        String[] array8Input = {"0", "1", "2", "3", "4", "5","6","7","8","9"};
//        String[] array8Output = lpp.antecessorSucessorPor(array8Input,3);
//        System.out.println(Arrays.deepToString(array8Output));
//
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("9 - numerosPares");
//        System.out.println(lpp.numerosPares(27));
//
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("10 - numerosImpares");
//        System.out.println(lpp.numerosImpares(27));
//
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("11 - numerosPrimos");
//        System.out.println(lpp.numerosPrimos(27));
//
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("12 - numerosParesArray");
//        System.out.println(Arrays.toString(lpp.numerosParesArray(27)));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("13 - numerosImparesArray");
//        System.out.println(Arrays.toString(lpp.numerosImparesArray(27)));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("14 - numerosPrimosArray");
//        System.out.println(Arrays.toString(lpp.numerosPrimosArray(27)));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("15 - primeiraUltimaPosicaoArray");
//        System.out.println(Arrays.toString(lpp.primeiraUltimaMediaPosicaoArray(20)));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("16 - quantidadeParesImparesPrimos");
//        List<Integer> list16Input = new ArrayList<>();
//        for (int i = 0; i <= 50; i++) {list16Input.add(i);}
//        System.out.println(Arrays.toString(lpp.quantidadeParesImparesPrimos(list16Input)));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("17 - primeiraUltimaMediaPosicaoArray");
//        System.out.println(Arrays.toString(lpp.primeiraUltimaMediaPosicaoArray(20)));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("18 - removerInteirosDuplicados");
//
//        List<Integer> list18Input = Arrays.asList(arrayInteger);
//        List<Integer> list18Output = lpp.removerInteirosDuplicados(list18Input);
//        for(Integer i : list18Output) { System.out.println(i) ;}
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("19 - removerValoresDuplicados");
//        List<BigDecimal> list19Input = new ArrayList<>();
//        list19Input.add(new BigDecimal("1.00000000"));
//        list19Input.add(new BigDecimal("2.00000000"));
//        list19Input.add(new BigDecimal("2.00000000"));
//        list19Input.add(new BigDecimal("3.00000000"));
//        list19Input.add(new BigDecimal("3.00000000"));
//        list19Input.add(new BigDecimal("3.00000000"));
//        List<BigDecimal> list19Output = lpp.removerValoresDuplicados(list19Input);
//        for(BigDecimal i : list19Output) { System.out.println(i);}
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("20 - removerTextosDuplicados");
//
//        List<String> list20Input = Arrays.asList(arrayString);
//        List<String> list20Output = lpp.removerTextosDuplicados(list20Input);
//        for(String i : list20Output) { System.out.println(i);}
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("21 - valorInteiroMaiorQtdDuplicados");
//        List<Integer> list21Input = Arrays.asList(arrayInteger);
//        int maiorInteger = lpp.valorInteiroMaiorQtdDuplicados(list21Input);
//        System.out.println(maiorInteger);
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("22 - valorTextoMaiorQtdDuplicados");
//        List<String> list22Input = Arrays.asList(arrayString);
//        String maiorString = lpp.valorTextoMaiorQtdDuplicados(list22Input);
//        System.out.println(maiorString);
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("23 - listaInteirosDuplicados");
//        List<Integer> list23Input = Arrays.asList(arrayInteger);
//        List<Integer> list23Output = lpp.listaInteirosDuplicados(list23Input);
//        for(Integer i : list23Output) { System.out.println(i);}
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("24 - listaDecimalDuplicados");
//        List<BigDecimal> list24Output = lpp.listaDecimalDuplicados(list19Input);
//        for(BigDecimal i : list24Output) { System.out.println(i);}
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("25 - listaTextoDuplicados");
//        List<String> list25Input = Arrays.asList(arrayString);
//        List<String> list25Output = lpp.listaTextoDuplicados(listDiego);
//        for(String i : list25Output) { System.out.println(i);}
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("26 - somarValores");
//        System.out.println(lpp.somarValores(20));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("27 - somarValoresPares");
//        System.out.println(lpp.somarValoresPares(20));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("27 - somarValoresImpares");
//        System.out.println(lpp.somarValoresImpares(20));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("27 - somarValoresPrimos");
//        System.out.println(lpp.somarValoresPrimos(20));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("28 - somarValoresPosicoes");
//        System.out.println(lpp.somarValoresPosicoes(arrayInt));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("29 - somarValoresParesPosicoes");
//        System.out.println(lpp.somarValoresParesPosicoes(arrayInt));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("30 - somarValoresImparesPosicoes");
//        System.out.println(lpp.somarValoresImparesPosicoes(arrayInt));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("31 - somarValoresPrimosPosicoes");
//        System.out.println(lpp.somarValoresPrimosPosicoes(arrayInt));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("32 - somarValoresPosicoesParesMultiplosDe");
//        System.out.println(lpp.somarValoresPosicoesParesMultiplosDe(10, 3));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("33 - multiploDeSete");
//        System.out.println(lpp.multiploDeSete(50));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("34 - parOuImpar");
//        System.out.println(lpp.parOuImpar(20));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("35 - parOuImparOuZero");
//        System.out.println(lpp.parOuImparOuZero(20));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("36 - obterDobrosAteDobroInformado");
//        System.out.println(Arrays.toString(lpp.obterDobrosAteDobroInformado(20)));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("37 - obterDobrosAteDez");
//        System.out.println(Arrays.toString(lpp.obterDobrosAteDez(5)));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("38 - obterDobrosAteMil");
//        System.out.println(Arrays.toString(lpp.obterDobrosAteMil(50)));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("39 - tabuada");
//        System.out.println(Arrays.deepToString(lpp.tabuada(2)));
//
//
//
//X
//
//      System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//      System.out.println(" @ - LOGICA PROGRAMACAO FATURAMENTO");
//
//        //populando array//
//        //SOMA: 38400 // MEDIA: 11100
//
//
//        //1ºmes// soma=6900 // media 1725
//        lpf.adicionarFaturamentoSemanal(1200); //1semana
//        lpf.adicionarFaturamentoSemanal(2000); //2semana
//        lpf.adicionarFaturamentoSemanal(1300); //3semana
//        lpf.adicionarFaturamentoSemanal(2400); //4semana
//
//        //2ºmes// soma=13900 // media 3575
//        lpf.adicionarFaturamentoSemanal(3200); //1semana
//        lpf.adicionarFaturamentoSemanal(4000); //2semana
//        lpf.adicionarFaturamentoSemanal(3300); //3semana
//        lpf.adicionarFaturamentoSemanal(3400); //4semana
//
//        //3ºmes// soma=10900 // media 2725
//        lpf.adicionarFaturamentoSemanal(4200); //1semana
//        lpf.adicionarFaturamentoSemanal(3000); //2semana
//        lpf.adicionarFaturamentoSemanal(2300); //3semana
//        lpf.adicionarFaturamentoSemanal(1400); //4semana
//
//        //4ºmes// soma=12700 // media 3175
//        lpf.adicionarFaturamentoSemanal(3100); //1semana
//        lpf.adicionarFaturamentoSemanal(4100); //2semana
//        lpf.adicionarFaturamentoSemanal(3100); //3semana
//        lpf.adicionarFaturamentoSemanal(2400); //4semana
//
//
//

//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - obterFaturamentosSemanais - ");
//        System.out.println(Arrays.toString(lpf.obterFaturamentosSemanais()));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - calcularFaturamentoTotal - ");
//        System.out.println(lpf.calcularFaturamentoTotal());
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - calcularFaturamentoMensal - ");
//        System.out.println(Arrays.toString(lpf.calcularFaturamentoMensal()));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - calcularFaturamentoBimestral - ");
//        System.out.println(Arrays.toString(lpf.calcularFaturamentoBimestral()));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - calcularFaturamentoMedio - ");
//        System.out.println(lpf.calcularFaturamentoMedio());
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - calcularFaturamentoMedio - ");
//        System.out.println(lpf.calcularFaturamentoMedio());
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - calcularFaturamentoMedio - ");
//        System.out.println(Arrays.toString(lpf.calcularFaturamentoMedioDoMes()));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - calcularFaturamentoMedioPorSemanaDoMes - ");
//        System.out.println(Arrays.toString(lpf.calcularFaturamentoMedioPorSemanaDoMes()));
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - obterMesMaiorFaturamento - ");
//        System.out.println(lpf.obterMesMaiorFaturamento());
//
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(" - obterMesMenorFaturamento - ");
//        System.out.println(lpf.obterMesMenorFaturamento());

    }
}
