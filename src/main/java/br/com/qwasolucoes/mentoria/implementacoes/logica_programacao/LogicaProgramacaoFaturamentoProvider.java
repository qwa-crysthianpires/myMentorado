package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;


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
        int fatMes1 = 0, fatMes2 = 0, fatMes3 = 0, fatMes4 = 0;

        for(int i = 0; i < array.length; i++) {
            if (i >=0 && i<4){
                fatMes1 += array[i];
            }
            else if (i >3 && i<=7){
                fatMes2 += array[i];
            }
            else if (i>=8 && i<=11){
                fatMes3 += array[i];
            } else if (i >= 11 && i<=15) {
                fatMes4 += array[i];
            }

        }
        arrayReturn2[0] = fatMes1;
        arrayReturn2[1] = fatMes2;
        arrayReturn2[2] = fatMes3;
        arrayReturn2[3] = fatMes4;

        //NAO FICOU BOM, MAS FUNCIONOU. Revisar!


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
        //4
        int[] arrayReturn3 = new int[4];
        int tempo =4;
        int fatMes1 = 0, fatMes2 = 0, fatMes3 = 0, fatMes4 = 0;



        for(int i = 0; i < array.length; i++) {
            if (i >=0 && i<4){
                fatMes1 += array[i];
            }
            else if (i >3 && i<=7){
                fatMes2 += array[i];
            }
            else if (i>=8 && i<=11){
                fatMes3 += array[i];
            } else if (i >= 11 && i<=15) {
                fatMes4 += array[i];
            }
        }

        arrayReturn3[0] = fatMes1/4;
        arrayReturn3[1] = fatMes2/4;
        arrayReturn3[2] = fatMes3/4;
        arrayReturn3[3] = fatMes4/4;


        return  arrayReturn3;
    }

    @Override
    public int[] calcularFaturamentoMedioPorSemanaDoMes() {
        int[] arrayReturn4 = new int[4];
        int fatSem1 = 0, fatSem2 = 0, fatSem3= 0, fatSem4 = 0, cont =4;

        for(int i = 0; i < array.length; i++){
            if (i == 0 || i == cont || i==cont*2 || i == cont*3){
                fatSem1 += array[i];
            }
            if (i == 1 || i == cont+1 || i==(cont*2)+1 || i == (cont*3)+1){
                fatSem2 += array[i];
            }

            if (i == 2 || i == cont+2 || i==(cont*2)+2 || i == (cont*3)+2){
                fatSem3 += array[i];
            }

            if (i == 3 || i == cont+3 || i==(cont*2)+3 || i == (cont*3)+3){
                fatSem4 += array[i];
            }
        }
        arrayReturn4[0] = fatSem1/4;
        arrayReturn4[1] = fatSem2/4;
        arrayReturn4[2] = fatSem3/4;
        arrayReturn4[3] = fatSem4/4;

        return arrayReturn4;
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
}
