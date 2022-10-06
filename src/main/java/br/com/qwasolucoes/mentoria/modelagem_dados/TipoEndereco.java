package br.com.qwasolucoes.mentoria.modelagem_dados;

public enum TipoEndereco {

	R("Residencial"), P("Celular");

	private final String value;

	private TipoEndereco(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}