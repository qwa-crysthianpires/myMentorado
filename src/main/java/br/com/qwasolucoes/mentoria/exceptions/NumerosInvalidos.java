package br.com.qwasolucoes.mentoria.exceptions;


public class NumerosInvalidos extends RuntimeException{
    private String cpfCnpj;

    NumerosInvalidos(String nomeAtributo){
        this.cpfCnpj = cpfCnpj;
    }

    public String getMessage() {
        return String.format("O atributo %s está negativo", cpfCnpj);
    }
}

