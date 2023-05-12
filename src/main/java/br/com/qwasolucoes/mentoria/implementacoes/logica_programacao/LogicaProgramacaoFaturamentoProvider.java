package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;


import java.util.Arrays;

import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.LogicaProgramacaoFaturamento;


public class LogicaProgramacaoFaturamentoProvider implements LogicaProgramacaoFaturamento {

    private final int[] array = new int[16];
    private int count = 0;

//    private static final int TEMPO_MENSAL = 4;
    @Override
    public void adicionarFaturamentoSemanal(int faturamento) {
        array[count] = faturamento;
        count++;

    }

    @Override
    public int[] obterFaturamentosSemanais() {
        int[] arrayReturn1 = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayReturn1[i] = array[i];
        }
        return arrayReturn1;
    }

    @Override
    public int calcularFaturamentoTotal() {
        int fatTotal = 0;

        for(int i = 0; i < array.length; i++) {
            fatTotal += array[i];
        }

        return fatTotal;
    }

    @Override
    public int[] calcularFaturamentoMensal() {
        int[] arrayReturn2 = new int[4];

        arrayReturn2[0] = soma(array, 0, 3);
        arrayReturn2[1] = soma(array, 4, 7);
        arrayReturn2[2] = soma(array, 8, 11);
        arrayReturn2[3] = soma(array, 12, 15);

        return arrayReturn2;
    }


    @Override
    public int[] calcularFaturamentoBimestral() {

        int[] arrayReturn3 = new int[2];
        int bimestral = 8, fatBimestral1 = 0, fatBimestral2 = 0;

        for(int i = 0; i <= bimestral; i++) {
            if (i>=0 && i<=3){
                fatBimestral1 += array[i];
            }
            else if (i>=4 && i<=7){
                fatBimestral2 += array[i];
            }
        }
        arrayReturn3[0] = fatBimestral1;
        arrayReturn3[1] = fatBimestral2;

        return arrayReturn3;
    }

    @Override
    public int calcularFaturamentoMedio() {
        int fatTotal = 0;

        for(int i = 0; i < array.length; i++) {
            fatTotal += array[i];
        }
        return (fatTotal/ (array.length));
    }

    @Override
    public int[] calcularFaturamentoMedioDoMes() {
        int semanasPorMes = 4;
        int mesesNoAno = 4;
        int[] arrayReturn = new int[mesesNoAno];

        for (int mes = 0; mes < mesesNoAno; mes++) {
            int inicioDaSemana = mes * semanasPorMes;
            int fimDaSemana = inicioDaSemana + semanasPorMes;
            int faturamentoTotal = 0;

            for (int semana = inicioDaSemana; semana < fimDaSemana; semana++) {
                faturamentoTotal += array[semana];
            }

            arrayReturn[mes] = faturamentoTotal / semanasPorMes;
        }

        return arrayReturn;
    }


    @Override
    public int[] calcularFaturamentoMedioPorSemanaDoMes() {
        int[] arrayReturn4 = new int[4];
        int weekSize = array.length / 4;

        for(int i = 0; i < array.length; i++) {
            int weekIndex = i / weekSize;
            arrayReturn4[weekIndex] += array[i];
        }

        return Arrays.stream(arrayReturn4).map(i -> i / weekSize).toArray();
    }


    @Override
    public int obterMesMaiorFaturamento() {
      int maior = 0;

       int[] x = calcularFaturamentoMensal();

       for (int i = 0; i < x.length; i++) {
           if (x[i] > maior){
               maior = x[i];
           }
       }

      return maior;
    }

    @Override
    public int obterMesMenorFaturamento() {
        int menor = 9999;

        int[] x = calcularFaturamentoMensal();

        for (int i = 0; i < x.length; i++) {
            if (x[i] < menor) {
                menor = x[i];
            }
        }
        return menor;
    }
    
    private int soma(int[] array, int inicio, int fim) {
        int soma = 0;
        for (int i = inicio; i <= fim; i++) {
            soma += array[i];
        }
        return soma;
    }

}
