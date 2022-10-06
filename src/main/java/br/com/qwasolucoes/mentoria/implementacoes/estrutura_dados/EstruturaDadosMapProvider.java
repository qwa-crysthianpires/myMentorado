package br.com.qwasolucoes.mentoria.implementacoes.estrutura_dados;

import br.com.qwasolucoes.mentoria.interfaces.estrutura_dados.EstruturaDadosMap;
import br.com.qwasolucoes.mentoria.model.ContatoFuncionario;
import br.com.qwasolucoes.mentoria.model.Funcionario;

import java.util.*;
import java.util.regex.Pattern;

public class EstruturaDadosMapProvider implements EstruturaDadosMap {
    @Override
    public Map<String, Integer> nomeFrequencia(List<String> nomes) {
        Map<String, Integer> FrequenciaNomes = new HashMap<String, Integer>();
        int quantidadeNome= 0;

        for (int i=0; i<nomes.size(); i++) {
            quantidadeNome= 0;

            for (String nome : nomes) {
                if (nomes.get(i).equals(nome)) {
                    quantidadeNome++;
                    FrequenciaNomes.put(nomes.get(i), quantidadeNome);
                }
            }
        }
        return FrequenciaNomes;
    }

    @Override
    public Map<String, Integer> mapaFrequenciaValores(Map<String, String> mapa) {

        Map<String, Integer> chaveFrequenciaValores = new HashMap<String, Integer>();
        int frequenciaValores;
//                    <chave, valor>
        for(Map.Entry<String, String> elemento : mapa.entrySet()){
            frequenciaValores = 0;

            for(Object value : mapa.values()){

                if (elemento.getValue() == value){
                    frequenciaValores++;

//                    se a chave ainda nao foi adicionada para return -> aidicionar
//                    chaveUnica = true; if
                    chaveFrequenciaValores.put(elemento.getKey(), frequenciaValores);
                }
            }
        }
        return chaveFrequenciaValores;
    }

    @Override
    public Map<String, Integer> mapaFrequenciaValoresLista(Map<String, List<String>> mapa) {
        Map<String, Integer> mapaFrequenciaValoresLista = new HashMap<String, Integer>();
        int frequenciaValoresLista;

        for(Map.Entry<String, List<String>> elemento : mapa.entrySet()){
            frequenciaValoresLista = 0;
            for(Object value : mapa.values()){
                if (elemento.getValue()== value){
                    frequenciaValoresLista++;
                    mapaFrequenciaValoresLista.put(elemento.getKey(), frequenciaValoresLista);
                }
            }
        }
        return mapaFrequenciaValoresLista;
    }

    @Override
    public Map<String, List<String>> nomeTelefones(List<String> elemento) {

        List<String> listTelefones = new ArrayList<String>();
        Map<String, List<String>> nomesTelefones = new HashMap<String, List<String>>();

        for (Integer i = 0; i < elemento.size(); i+=2) {
                listTelefones.clear();

                //separando o index com telefones...
                String telefones = elemento.get(i+1);

                String[] newTelefonne = telefones.split(",");

                for(String tel : newTelefonne) {
                    listTelefones.add(tel);}

//                Adicionando ao map
            nomesTelefones.put(elemento.get(i).trim(), listTelefones);
        }
        return nomesTelefones;
    }

    @Override
    public Map<Funcionario, List<ContatoFuncionario>> cpfCnpjTelefonesObjeto(List<String> elemento) {
        List<ContatoFuncionario> listaContatos = new ArrayList<>();
        Map<Funcionario, List<ContatoFuncionario>> mapaFuncionarioListaContatos = new HashMap<>();

        for (int i = 0; i < elemento.size(); i+=2){
            Funcionario funcionario = new Funcionario();
            ContatoFuncionario contatoFuncionario = new ContatoFuncionario();

            for(int j=1; j < elemento.size(); j+=2){
                int tipo =  tipoContatoFuncionario(elemento.get(j).trim());

                contatoFuncionario.setTipo(tipo);
                contatoFuncionario.setValor(elemento.get(j));
                listaContatos.add(contatoFuncionario);
            }
            funcionario.setCpfCnpj(elemento.get(i));
            mapaFuncionarioListaContatos.put(funcionario, listaContatos);
        }
        return mapaFuncionarioListaContatos;
    }


    @Override
    public List<String> chavesMapa(Map<String, String> mapa) {
        List<String> chavesMapa = new ArrayList<String>();

        for(Map.Entry<String, String> elemento : mapa.entrySet()){
            chavesMapa.add(elemento.getKey());
        }
        return chavesMapa;
    }

    @Override
    public List<String> valoresMapa(Map<String, String> mapa) {

        List<String> mapaValores = new ArrayList<String>();

        for(String valor : mapa.keySet()){
            mapaValores.add(valor);
        }
        return mapaValores;
    }

    @Override
    public Map<String, List<Integer>> tipoNumerosCorrespondentes(final int limite)  {

        Map<String, List<Integer>> mapaNumeros = new HashMap<String, List<Integer>>();

        mapaNumeros.put("NUMEROS_PARES", numerosPares(limite));
        mapaNumeros.put("NUMEROS_IMPARES", numerosImpares(limite));
        mapaNumeros.put("NUMEROS_PRIMOS", numerosPrimos(limite));
        mapaNumeros.put("NUMEROS_MULTIPLOS_10", numerosMultiplos10(limite));

        return mapaNumeros;
    }

    @Override
    public Integer maiorNumeroEntreValores(Map<String, List<Integer>> map) {
        return null;
    }

    @Override
    public String chaveMaiorNumeroEntreValores(Map<String, List<Integer>> map) {
        String result = null;
        String chave = null;
        int maiorNumero = 0;

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {

            String key = entry.getKey();
            List<Integer> values = entry.getValue();

            for (int i = 0; i < values.size(); i++) {
                if(values.get(i) > maiorNumero){
                    maiorNumero = values.get(i);
                    chave = entry.getKey();
                }
            }
            result = "Chave: " + chave +" - Valor: "+maiorNumero;
//            System.out.println(String.format("key: %s | value: %s", key, value));
        }

        return result;
    }

    static List<Integer> numerosPrimos(int limite) {
        List<Integer> numerosPrimo = new ArrayList<Integer>();
        // Check from 2 to n-1
        for (int i = 0; i < limite; i++) {
            if(isPrime(i)){
                numerosPrimo.add(i);
            }
        }
        return numerosPrimo;
    }


    static List<Integer> numerosPares(int limite) {
        List<Integer> numerosPares = new ArrayList<Integer>();
        for (int i = 0; i <= limite; i++) {
            if (i % 2 == 0) {
                numerosPares.add(i);
            }
        }
        return numerosPares;
    }
    static List<Integer> numerosImpares(int limite){
        List<Integer> numerosImpares = new ArrayList<Integer>();
        for (int i = 0; i <= limite; i++) {
            if (i % 2 == 1) {
                numerosImpares.add(i);
            }
        }
        return numerosImpares;
    }

    static List<Integer> numerosMultiplos10(int limite) {
        List<Integer> numerosMultiplos10 = new ArrayList<Integer>();
        for(int i = 1; i <= limite; i++) {
            if (i % 10 ==0){
                numerosMultiplos10.add(i);
            }
        }
        return numerosMultiplos10;
    }
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;

        return true;
    }


    public static int tipoContatoFuncionario(String var){
        if(isEmail(var))
            return 2;
        else if(isTelefone(var)){
            return 0;
        }
        else {
            return 1;
        }
    }

    public static boolean isCelphone(String var){
        return var.length() == 11;
    }
    public static boolean isTelefone(String var){
        return var.length() == 10;
    }

    public static boolean isEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
