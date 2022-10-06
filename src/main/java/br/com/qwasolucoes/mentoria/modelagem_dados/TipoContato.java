package br.com.qwasolucoes.mentoria.modelagem_dados;

public enum TipoContato {

	TELEFONE("Telefone"), CELULAR("Celular"), EMAIL("E-mail");

	private final String value;

	private TipoContato(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
