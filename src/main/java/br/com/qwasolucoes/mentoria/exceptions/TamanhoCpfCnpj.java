package br.com.qwasolucoes.mentoria.exceptions;

public class TamanhoCpfCnpj extends RuntimeException{

    private String cpfCnpj;

    TamanhoCpfCnpj(String cpfCnpj){
        this.cpfCnpj = cpfCnpj;
    }

    public String getMessage() {
        return String.format("O CPF/CNPJ %s está Inválido!", cpfCnpj);
    }
}
