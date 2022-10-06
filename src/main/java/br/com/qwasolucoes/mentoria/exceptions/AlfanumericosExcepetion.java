package br.com.qwasolucoes.mentoria.exceptions;

public class AlfanumericosExcepetion extends RuntimeException{
    private final String cpfCnpj;

    AlfanumericosExcepetion(String cpfCnpj){
        this.cpfCnpj = cpfCnpj;
    }

    public String getMessage() {

        return String.format("O cpfCnpj %s ALFANUMERICO1", cpfCnpj);
    }

}
