package br.com.qwasolucoes.mentoria.exceptions;


public class StringVaziaException extends RuntimeException {

    private String cpfCnpj;


    public StringVaziaException(String cpfCnpj) {
        this.cpfCnpj=cpfCnpj;
    }

    public String getMessage() {
        return String.format("O atributo '%s' está vazio.", cpfCnpj);
    }
}
