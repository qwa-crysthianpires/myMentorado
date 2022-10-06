package br.com.qwasolucoes.mentoria.exceptions;


import br.com.qwasolucoes.mentoria.model.Funcionario;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoException{
	public static void cpfCnpj(Funcionario funcionario){

		if(funcionario.getCpfCnpj() == null) {
			throw new IllegalArgumentException("CPF/CNPJ está nulo!");
		}
		if(funcionario.getCpfCnpj().trim().isEmpty()){
			throw new StringVaziaException("CPF/CNPJ está vazio!");
		}
//		if(funcionario.getCpfCnpj().trim().length() != 11 || funcionario.getCpfCnpj().trim().length() != 14){
//			throw new TamanhoCpfCnpj("Tamanho Diferente");
//		}
		if(isAlphaNumeric(funcionario.getCpfCnpj())){
			throw new AlfanumericosExcepetion("Erro Alfanumericos2");
		}
	}

	public static void salario(Funcionario funcionario){
		if(funcionario.getSalario() == null){
			throw new IllegalArgumentException("Salario está nulo!");
		}
		if(Objects.equals(funcionario.getSalario(), BigDecimal.ZERO)){
			throw new StringVaziaException("Salario está vazio!");
		}
	}

	private static boolean isAlphaNumeric(String str)
	{
		// Regex to check string is alphanumeric or not.
		String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the string is empty
		// return false
		if (str == null) {
			return false;
		}
		// Pattern class contains matcher() method
		// to find matching between given string
		// and regular expression.
		Matcher m = p.matcher(str);

		// Return if the string
		// matched the ReGex
		return m.matches();
	}
}
