package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import br.com.qwasolucoes.mentoria.interfaces.estrutura_dados.EstruturaDadosSet;
import br.com.qwasolucoes.mentoria.model.Funcionario;

import java.util.*;

public class EstruturaDadosSetProvider implements EstruturaDadosSet {
    @Override
    public Set<String> nomesUnicosOrdenados(List<String> nomes) {
        return ordenacaoSet(ordenacaoString(nomes));
    }

    @Override
    public Set<String> valoresPositivosNegativos(int[] valores) {

        bubbleSort(valores);
        Set<String> x = new HashSet<String>();
        x.add(valores.toString());

        return x;
    }

    @Override
    public Set<Integer> valoresDuplicadosOrdenados(List<Integer> valores1, List<Integer> valores2) {
        Set<Integer> duplicadosOrdenados = new HashSet<Integer>();
        int repeticao = 0;
        for (int i = 0; i < valores1.size(); i++){
            for(int j = 0; j < valores1.size(); j++){
                if (valores1.get(i).equals(valores2.get(j))){
                    repeticao++;
                    if(repeticao >1){
                        duplicadosOrdenados.add(valores1.get(i));
                    }
                }
            }
        }
        return duplicadosOrdenados;
    }

    @Override
    public Set<Integer> valoresDiferentesOrdenados(List<Integer> valores1, List<Integer> valores2) {
        TreeSet<Integer> diferentesOrdenados = new TreeSet<>(diferenteEntreLista(valores1, valores2));
       return diferentesOrdenados;
    }

//

    @Override
    public Set<Integer> valoresDuplicadosDaPrimeiraListaOrdenados(List<Integer> valores1, List<Integer> valores2) {
        HashSet<Integer> valoresDuplicadosDaPrimeiraListaOrdenados = new HashSet<Integer>();

//      ordena os numeros inteiros ex.[1,2,3,4,5]
//        ordenacaoInteger(valores1);
        valoresDuplicadosDaPrimeiraListaOrdenados.addAll(ordenacaoInteger(valores1));
        return valoresDuplicadosDaPrimeiraListaOrdenados;
    }

    @Override
    public Set<Integer> valoresDiferentesDaSegundaListaOrdenados(List<Integer> valores1, List<Integer> valores2) {
        HashSet<Integer> valoresDuplicadosDaPrimeiraListaOrdenados = new HashSet<Integer>(valores2);
        valoresDuplicadosDaPrimeiraListaOrdenados.removeAll(valores1);

        return valoresDuplicadosDaPrimeiraListaOrdenados;
    }

    @Override
    public Set<Funcionario> pessoasUnicasOrdenados(List<Funcionario> pessoas) {
        TreeSet<Funcionario> funcionariosSeparados = new TreeSet<>();
        int cont ;

       for(int i = 0; i < pessoas.size(); i++){
           cont = 0;
           for(int j = 0; j < pessoas.size(); j++){
               if (pessoas.get(i).getCpfCnpj() == pessoas.get(j).getCpfCnpj()){
                   cont++;
               }
               if(cont ==1){

               }
           }
       }
       return funcionariosSeparados;
    }

    @Override
    public Set<Funcionario> pessoasDuplicadosOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {
        return null;
    }

    @Override
    public Set<Funcionario> pessoasDiferentesOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {
        return null;
    }

    @Override
    public Set<Funcionario> pessoasDuplicadosDaPrimeiraListaOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {
        return null;
    }

    @Override
    public Set<Funcionario> pessoasDiferentesDaSegundaListaOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {
        return null;
    }



    static Set<String> ordenacaoSet(List<String> ListaString){
        Set<String> set = new HashSet<String>();

        for (String elemento: ListaString){
            set.add(elemento);
        }
        return set;
    }
    static List<Integer> diferenteEntreLista(List<Integer> primeiraLista, List<Integer> segundaLista){
        List<Integer> diferencas = new ArrayList<>(primeiraLista);
        diferencas.removeAll(segundaLista);
        List<Integer> temp = new ArrayList<>(segundaLista);
        temp.removeAll(primeiraLista);
        diferencas.addAll(temp);

        return diferencas;
    }
    static List<String> ordenacaoString(List<String> nomes) {
        String temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nomes.size() - 1; i++) {
                if (nomes.get(i).compareTo(nomes.get(i + 1)) > 0) {
                    temp = nomes.get(i);
                    nomes.set(i, nomes.get(i + 1));
                    nomes.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return nomes;
    }
    static List<Integer> ordenacaoInteger(List<Integer> numeros) {
        int temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < numeros.size() - 1; i++) {
                if (numeros.get(i).compareTo(numeros.get(i + 1)) > 0) {
                    temp = numeros.get(i);
                    numeros.set(i, numeros.get(i + 1));
                    numeros.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return numeros;
    }
    public int[] bubbleSort(int[] elementos) {

        // for utilizado para controlar a quantidade de vezes que o vetor será ordenado.
        for(int i = 0; i < elementos.length - 1; i++) {
            // for utilizado para ordenar o vetor.
            for(int j = 0; j < elementos.length - 1 - i; j++) {
	        /* Se o valor da posição atual do vetor for maior que o proximo valor,
	          então troca os valores de lugar no vetor. */
                if(elementos[j] > elementos[j + 1]) {

                    int aux = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = aux;
                }
            }
        }
        return elementos;
    }
}
