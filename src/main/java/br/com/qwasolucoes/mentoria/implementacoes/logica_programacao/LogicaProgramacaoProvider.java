package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;

/*
PRIMEIRAMENTE BOM DIA, SEGUNDO SÓ POR DEUS.
 */

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.LogicaProgramacao;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class LogicaProgramacaoProvider implements LogicaProgramacao{

	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

	@Override
	public List<Funcionario> conversaoStringParaPessoa(List<String> lista) throws ParseException {

		//foreach list
		List<Funcionario> listaFuncionario = new ArrayList<>();

		for (String funcionario : lista) {

			/*
			criando objeto funcionario a partir da lista que recebi como parametro
			filtrando a string com substring e limpando com trim, para setar sem espaços.

			*/

			Funcionario func = new Funcionario();

			String nomeFuncionario = funcionario.substring(0, 19).trim();
			func.setNome(nomeFuncionario);

			String sobrenomeFuncionario = funcionario.substring(19, 39).trim();
			func.setSobrenome(sobrenomeFuncionario);

			String diaDataFuncionario = funcionario.substring(40, 42);
			String mesDataFuncionario = funcionario.substring(42, 44);
			String anoDataFuncionario = funcionario.substring(44, 48);

			Date dataNascimento = sdf.parse(diaDataFuncionario + mesDataFuncionario + anoDataFuncionario);
			func.setDataNascimento(dataNascimento);

			String sexoFuncionario = funcionario.substring(48, 49).trim();
			func.setSexo(sexoFuncionario);

			String profissaoFuncionario = funcionario.substring(49, 89).trim();
			func.setProfissao(profissaoFuncionario);


			String cpfOrCnpjFuncionario = funcionario.substring(89, 103).trim();

			String cpfEditado;
			if(cpfOrCnpjFuncionario.length() == 11){
				cpfEditado = funcionario.substring(89, 92) + "." + funcionario.substring(92, 95) + "." + funcionario.substring(95, 98) + "-" + funcionario.substring(98, 100);
			}else {
				cpfEditado = funcionario.substring(89, 91) + "." + funcionario.substring(91, 94) + "." + funcionario.substring(94, 97) + "/" + funcionario.substring(97, 101) + "-" + funcionario.substring(101, 103);
			}
			func.setCpfCnpj(cpfEditado);

			String escolaridadeFuncionario = funcionario.substring(103, 143).trim();
			func.setEscolaridade(escolaridadeFuncionario);

			//save



			//calculoIdade
			LocalDate test = func.getDataNascimento().toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();

			int calculoIdadeFuncionario = Funcionario.calculaIdade(test);
			func.setIdade(calculoIdadeFuncionario);

			//MaiorIdade
			func.setMaiorIdade(func.getIdade() > 18);

			//calculo Taxa

			String salarioFuncionario = funcionario.substring(143, 153).trim();

			BigDecimal salario = new BigDecimal(salarioFuncionario);

			func.calculoTaxa(calculoIdadeFuncionario);

			//calculo salario
			func.setSalario(salario.subtract(func.getTaxa().multiply(salario)));



			listaFuncionario.add(func);
		}
		return listaFuncionario;
	}


	@Override
	public List<String> conversaoPessoaParaString(List<Funcionario> pessoas) {

		//StringBuilder nomeFuncionario = new StringBuilder();
		List<String> listReturn = new ArrayList<>();

		/*
		 * for para cada index dessa lista
		 * VariavelFuncionario adicionar o index
		 * tratar os espaços
		 *
		 * */


		for(Funcionario f : pessoas){

			//Carlos ajudou a refatorar tudo na mesma linha

			listReturn.add(Funcionario.validacaoString(f.getNome(),20));
			listReturn.add(Funcionario.validacaoString(f.getSobrenome(),20));
			listReturn.add(Funcionario.validacaoString(f.getDataNascimento().toString(),20));
			listReturn.add(Funcionario.validacaoString(f.getSexo(),1));
			listReturn.add(Funcionario.validacaoString(f.getProfissao(),40));
			listReturn.add(Funcionario.validacaoString(f.getCpfCnpj(),14));
			listReturn.add(Funcionario.validacaoString(f.getEscolaridade(),40));
			listReturn.add(Funcionario.validacaoString(f.getSalario().toString(),10));

			/* ANTES
			String sobrenomeFuncionario = f.getSobrenome();
			String sobrenomenomeFuncionarioFinal = Funcionario.validacaoString(nomeFuncionario,20);
			listReturn.add(sobreNomeFuncionarioFinal);
			*/
		}
		return listReturn;
	}

	@Override
	public Funcionario conversaoArrayParaPessoa(String[] array) throws ParseException {

		Funcionario func = new Funcionario();

		//for( String pessoa : array ) {
		func.setNome(array[0]);
		func.setSobrenome(array[1]);
		func.setDataNascimento(sdf.parse(array[2]));
		func.setSexo(array[3]);
		func.setProfissao(array[4]);
		func.setCpfCnpj(array[5]);
		func.setEscolaridade(array[6]);

		//calculoIdade
		LocalDate test = func.getDataNascimento().toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();

		int calculoIdadeFuncionario = Funcionario.calculaIdade(test);
		func.setIdade(calculoIdadeFuncionario);

		//MaiorIdade
		func.setMaiorIdade(func.getIdade() > 18);

		//calculo TAXA
		func.calculoTaxa(calculoIdadeFuncionario);

		//CALCULO SALARAIO
		func.setSalario(new BigDecimal(array[7]));

		BigDecimal salario = func.getSalario();
		func.setSalario(salario.subtract(func.getTaxa().multiply(salario)));

		return func;
	}

	@Override
	public List<Funcionario> conversaoArrayMultidimensionalParaPessoa(String[][] arrayMultidimensional) throws ParseException {



		List<Funcionario> listFuncionario4Return = new ArrayList<>();

		for(int i =0; i < arrayMultidimensional.length;i++) {

			Funcionario func = new Funcionario();

				func.setNome(arrayMultidimensional[i][0]);
				func.setSobrenome(arrayMultidimensional[i][1]);
				func.setDataNascimento(sdf.parse(arrayMultidimensional[i][2]));
				func.setSexo(arrayMultidimensional[i][3]);
				func.setProfissao(arrayMultidimensional[i][4]);
				func.setCpfCnpj(arrayMultidimensional[i][5]);
				func.setEscolaridade(arrayMultidimensional[i][6]);

				//calculoIdade
				LocalDate test = func.getDataNascimento().toInstant()
						.atZone(ZoneId.systemDefault())
						.toLocalDate();

				int calculoIdadeFuncionario = Funcionario.calculaIdade(test);
				func.setIdade(calculoIdadeFuncionario);

				//MaiorIdade
				func.setMaiorIdade(func.getIdade() > 18);


				// Set salario
				String salarioString = arrayMultidimensional[i][7].trim();
				BigDecimal salario = new BigDecimal(salarioString);
				func.setSalario(salario);

				// CALCULADO TAXA PELA IDADE
				func.calculoTaxa(calculoIdadeFuncionario);

				//CALCULO TAXA
				BigDecimal salarioFuncionario = func.getSalario();
				BigDecimal taxaFuncionario = func.getTaxa();

				BigDecimal taxaFinal = taxaFuncionario.multiply(salarioFuncionario);
				func.setTaxa(taxaFinal);

				listFuncionario4Return.add(func);
		}
		return listFuncionario4Return;
	}

	@Override
	public int[][] arrayMultidimensionalParesImparesPrimosResto(int[] array, int numeroDivisaoResto) {

		int qtdLinhas=0;
		int cont = 0;

		for (int i = 0; i < array.length; i++) {qtdLinhas +=1;}
		int[][] arrayReturn94 = new int[qtdLinhas][4];

		for(int numero: array) {
			if (numero % 2 == 0) {
				arrayReturn94[cont][0] = numero;
				arrayReturn94[cont][1] = 0;
			}else {
				arrayReturn94[cont][0] = 0;
				arrayReturn94[cont][1] = numero;
			}

			//primo
			if(isPrime(numero)) {
				arrayReturn94[cont][2] = numero;
			}else{
				arrayReturn94[cont][2] = 0;
			}


			//resto
			int x = numero % numeroDivisaoResto;
			arrayReturn94[cont][3] = x;
			cont+=1;


		}return arrayReturn94;
	}

	@Override
	public String[] arrayMultidimensionalPorPosicoes(String[][] arrayMultidimensional, int coluna, int linha) {

			String[] arrayReturn94 = new String[4];

			try{
				arrayReturn94[0] = arrayMultidimensional[coluna][linha-1];
				arrayReturn94[1] = arrayMultidimensional[coluna][linha+1];
				arrayReturn94[2] = arrayMultidimensional[coluna-1][linha];
				arrayReturn94[3] = arrayMultidimensional[coluna+1][linha];

			}catch (Exception e){e.getMessage();}





			return arrayReturn94;
	}

	@Override
	public String[] arrayMultidimensionalPorValor(String[][] arrayMultidimensional, String valor) {

		String[] arrayReturn93 = new String[2];

		for (int i = 0; i < arrayMultidimensional.length; i++) {

			for(int j = 0; j < arrayMultidimensional.length; j++) {

				if (arrayMultidimensional[i][j].equals(valor)){

					try {
						arrayReturn93[0] = arrayMultidimensional[i][j - 1];
					}
					catch(Exception e){
						System.out.println("Antecessor nulo!");
					}

					try{
						arrayReturn93[1] = arrayMultidimensional[i][j + 1];
					}
					catch(Exception e)
					{
						System.out.println("Sucesssor nulo!");
					}
				}
			}
		}
		return arrayReturn93;
	}

	@Override
	public String[] antecessorSucessorPor(String[] array, int posicao) {

		String[] arrayReturn92 = new String[2];

		arrayReturn92[0] = array[posicao-2];
		arrayReturn92[1] = array[posicao];

		return arrayReturn92;
	}

	@Override
	public String[] antecessorSucessorPor(String[] array, String valor) {

		String[] arrayReturn91 = new String[2];

		for (int i = 0; i < array.length; i++){

			if (array[i].equals(valor)){
				arrayReturn91[0] =  array[i-1];
				arrayReturn91[1] =  array[i+1];
			}
		}
		return arrayReturn91;
	}

	@Override
	public List<Integer> numerosPares(Integer limite) {

		List<Integer> arrayReturn90 = new ArrayList<>();

		for (int i = 0; i <= limite; i++){
			if (i % 2==0){
				arrayReturn90.add(i);
			}
		}
		return arrayReturn90;
	}

	@Override
	public List<Integer> numerosImpares(Integer limite) {
		List<Integer> arrayReturn90 = new ArrayList<>();

		for (int i = 0; i <= limite; i++){

			if (i % 2==1){
				arrayReturn90.add(i);
			}
		}
		return arrayReturn90;
	}


	@Override
	public List<Integer> numerosPrimos(Integer limite) {
		List<Integer> arrayReturn89 = new ArrayList<>();
		for (int i =0; i <= limite; i++){
			if(isPrime(i)){arrayReturn89.add(i);}
		}return arrayReturn89;
	}

	@Override
	public int[] numerosParesArray(Integer limite) {

		int cont = 0;
		int arrSize = numerosPares(limite).size();
		int[] arrayReturn88 = new int[arrSize];

		for (int i =0; i <= limite; i++){
			if (i % 2==0){
				arrayReturn88[cont] = i;
				cont ++;
			}
		}
		return arrayReturn88;
	}

	@Override
	public int[] numerosImparesArray(Integer limite) {
		int cont = 0;

		int arrSize = numerosImpares(limite).size();

		int[] arrayReturn87 = new int[arrSize];

		for (int i =0; i <= limite; i++){
			if (i % 2==1){
				arrayReturn87[cont] = i;
				cont ++;
			}
		}
		return arrayReturn87;
	}

	@Override
	public int[] numerosPrimosArray(Integer limite) {
		int cont = 0;
		int x = numerosPrimos(limite).size();
		int[] arrayReturn86 = new int[x];

		for (int i =0; i <= limite; i++){
			if(isPrime(i)){
				arrayReturn86[cont] = i;
				cont++;
			}
		}return arrayReturn86;
	}

	@Override
	public int[] primeiraUltimaPosicaoArray(Integer limite) {
		int[] arrayReturn85 = new int[2];
		int maior = 0;
		int menor = 0;

		for (int i =0; i <= limite; i++){
			if (i > maior){
				maior = i;
			}
			if (i < menor) {
				menor = i;
			}
		}
		arrayReturn85[0] = menor;
		arrayReturn85[1] = maior;

		return arrayReturn85;
	}

	@Override
	public int[] quantidadeParesImparesPrimos(List<Integer> valores) {
		int contPar = 0;
		int contImpar = 0;
		int contPrimos = 0;

		int[] arrayReturn84 = new int[3];

		for (Integer index : valores) {
			if (index % 2 == 0) {
				contPar ++;
			}
			else {
				contImpar++;
			}
			if (isPrime(index)){
				contPrimos++;
			}
		}
		arrayReturn84[0] = contPar;
		arrayReturn84[1] = contImpar;
		arrayReturn84[2] = contPrimos;

		return arrayReturn84;
	}

	@Override
	public int[] primeiraUltimaMediaPosicaoArray(Integer limite) {
		int[] arrayReturn83 = new int[3];
		int maior = 0;
		int menor = 0;
		int soma = 0;
		int cont = 0;

		for (int i =0; i <= limite; i++){
			//ultima
			if (i > maior){
				maior = i;
			}
			//primeira
			if (i < menor) {
				menor = i;
			}//media
			soma = soma + i;
			cont++;

		}
		int media = (soma / cont);

		arrayReturn83[0] = menor;
		arrayReturn83[1] = maior;
		arrayReturn83[2] = media;

		return arrayReturn83;
	}

	@Override
	public List<Integer> removerInteirosDuplicados(List<Integer> numeros) {

		HashSet<Integer> filtro = new HashSet<>(numeros);

		return new ArrayList<>(filtro);
	}

	@Override
	public List<BigDecimal> removerValoresDuplicados(List<BigDecimal> numeros) {
		List<BigDecimal> listReturn81 = new ArrayList<BigDecimal>();
		HashSet<BigDecimal> filtro = new HashSet<>();

		for (BigDecimal i : numeros) {
			if(filtro.add(i)) {
				listReturn81.add(i);
			}
		}
		return listReturn81;
	}

	@Override
	public List<String> removerTextosDuplicados(List<String> textos) {

		List<String> listReturn80 = new ArrayList<String>();
		HashSet<String> filtro = new HashSet<>();


		for (String i : textos) {
			if(filtro.add(i)) {
				listReturn80.add(i);
			}
		}
		return listReturn80;
	}

	@Override
	public Integer valorInteiroMaiorQtdDuplicados(List<Integer> numeros) {
		int moda = 0;
		//numeros de repeticoes
		int frequencia = Collections.frequency(numeros, numeros.get(0));
		moda = numeros.get(0);
		int numRepeticoes = frequencia;
		for (Integer element : numeros) {
			frequencia = Collections.frequency(numeros, element);
			if (frequencia > numRepeticoes) {
				moda = element;
			}
		}
		return moda;
	}

	@Override
	public String valorTextoMaiorQtdDuplicados(List<String> textos) {
		String moda;

		//numeros de repeticoes
		int frequencia = Collections.frequency(textos,textos.get(0));
		moda = textos.get(0);
		int numRepeticoes = frequencia;
		for (String element : textos) {
			frequencia = Collections.frequency(textos, element);
			if (frequencia > numRepeticoes) {
				moda = element;
			}
		}
		return moda;
	}

	@Override
	public List<Integer> listaInteirosDuplicados(List<Integer> textos) {

		List<Integer> listReturn79 = new ArrayList<>();
		HashSet<Integer> filtro = new HashSet<>();
		HashSet<Integer> filtro1 = new HashSet<>();

		for (Integer texto : textos) {
			if (!filtro.add(texto)) {
				if (filtro1.add(texto)){
					listReturn79.add(texto);
				}
			}
		}
		return listReturn79;
	}

	@Override
	public List<BigDecimal> listaDecimalDuplicados(List<BigDecimal> numeros) {

		List<BigDecimal> listReturn78 = new ArrayList<>();
		HashSet<BigDecimal> filtro = new HashSet<>();
		HashSet<BigDecimal> filtro1 = new HashSet<>();

		for (BigDecimal texto : numeros) {
			if (!filtro.add(texto)) {
				if (filtro1.add(texto)){
					listReturn78.add(texto);
				}
			}
		}
		return listReturn78;
	}


	@Override
	public List<String> listaTextoDuplicados(List<String> textos) {
		List<String> listReturn77 = new ArrayList<String>();

//		for (int i =0; i <textos.size(); i++) {
//			String textoAtual = textos.get(i);
//			int qtdVezesTextoAtual = 0;
//
//			for (String texto : textos){
//				if (textoAtual.equals(texto) ){
//					qtdVezesTextoAtual++;
//
//					if (qtdVezesTextoAtual >=2 && !listReturn77.contains(texto)){
//						listReturn77.add(texto);
//					}
//				}
//			}
//		}
		HashSet<String> filtroRepetidos = new HashSet<>();
		HashSet<String> filtroRepetidosFinal = new HashSet<>();

		for (String texto : textos) {
//			lista dos repetidos
			if (!filtroRepetidos.add(texto)) {
//				separando os repetidos unicos
				if (filtroRepetidosFinal.add(texto)) {
					listReturn77.add(texto);
				}
			}
		}
		return listReturn77;
	}

	@Override
	public Integer somarValores(Integer limite) {
		Integer soma = 0;
		for (int i =0; i <= limite; i++){
			soma = soma + i;
		}
		return soma;
	}

	@Override
	public Integer somarValoresPares(Integer limite) {
		Integer soma = 0;

		for (int i =0; i <= limite; i++){
			if (i% 2 == 0) {
				soma = soma + i;
			}
		}
		return soma;
	}

	@Override
	public Integer somarValoresImpares(Integer limite) {
		Integer soma = 0;

		for (int i =0; i <= limite; i++){
			if (i% 2 == 1) {
				soma = soma + i;
			}
		}
		return soma;
	}

	@Override
	public Integer somarValoresPrimos(Integer limite) {
		Integer soma = 0;

		for (int i =0; i <= limite; i++){
			if(isPrime(i)){
				soma = soma + i;
			}
		}
		return soma;
	}

	@Override
	public Integer somarValoresPosicoes(int[] valores) {
		Integer soma = 0;

		for(int i : valores){
			soma = soma + i;
		}
		return soma;
	}

	@Override
	public Integer somarValoresParesPosicoes(int[] valores) {
		Integer soma = 0;

		for(int i : valores){
			if (i % 2 == 0){soma = soma + valores[i];}
		}
		return soma;
	}

	@Override
	public Integer somarValoresImparesPosicoes(int[] valores) {
		Integer soma = 0;

		for(int i : valores){
			if (i % 2 == 1){soma = soma + valores[i];}
		}
		return soma;
	}

	//        int[] arrayInt = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6};
	@Override
	public Integer somarValoresPrimosPosicoes(int[] valores) {
		Integer soma = 10;

		for (int i = 0; i < valores.length; i++) {
			if(isPrime(valores[i])){
				soma = soma + valores[i];
			}
		}
		return soma;
	}

	@Override
	public Integer somarValoresPosicoesParesMultiplosDe(Integer limite, Integer multiplo) {
		int soma = 0;
		for (int i =0; i <= limite; i++){
			System.out.println("Index: " + i);
			if (i % 2 == 0 && i % multiplo == 0){
					soma += i;

			}
		}
		return soma;
	}

	@Override
	public boolean multiploDeSete(int valor) {

		if (valor % 7 == 0) {
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public String parOuImpar(int valor) {
		return valor % 2 == 0 ? "Par":  "Impar";

	}

	@Override
	public String parOuImparOuZero(int valor) {
		if (valor == 0 ){
			return "Zero";
		}else{
			return valor % 2 == 0 ? "Par":  "Impar";
		}
	}

	@Override
	public int[] obterDobrosAteDobroInformado(int valor) {
		int inicio = 3;
		int cont = 0;

		for (int i = inicio; i <= valor; i++){cont++;}

		int[] arrayReturn20 = new int[cont];

		for (int i = 0; inicio <= valor; i++){
			arrayReturn20[i] = inicio * 2;
			inicio ++;
		}
		return arrayReturn20;
	}

	@Override
	public int[] obterDobrosAteDez(int valor) {

		int[] arrayReturn19 = new int[10];

		int i = 0;
		int soma = valor + valor;

		while(i < 10){
			arrayReturn19[i] = soma + i;
			i++;
		}
	return arrayReturn19;
}

	@Override
	public int[] obterDobrosAteMil(int valor) {

		int soma = valor;
		int[] arrayReturn11 = new int[10];

		int i = 0;

		do {
			soma = soma + soma;
			arrayReturn11[i] = soma;
			i++;

		} while(soma < 1000);

		return arrayReturn11;
	}

	@Override
	public int[][] tabuada(int valor) {
		int c = 0;
		int t = 1;
		int valor1 = valor * 10;

		int[][] matriz = new int[valor1][3];

		while(t <= valor){
			for(int j = 1; j <= 10; j++){

				matriz[c][0] = t;
				matriz[c][1] = j;
				matriz[c][2] = t * j;
				c++;
//				x++;
			}
			t++;
		}
		return matriz;
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

	public double getModa(int[] array) {

		HashMap map = new HashMap();
		Integer i;
		Double moda = 0.0;
		Integer numAtual, numMaior = 0;

		for (int count = 0; count < array.length; count++) {

			i = (Integer) map.get(new Double(array[count]));

			if (i == null) {

				map.put(new Double(array[count]), new Integer(1));

			} else {
				map.put(new Double(array[count]), new Integer(i.intValue() + 1));

				numAtual = i.intValue() + 1;

				if (numAtual > numMaior) {
					numMaior = numAtual;

					moda = new Double(array[count]);
				}
			}
		}return moda;
	}
}
