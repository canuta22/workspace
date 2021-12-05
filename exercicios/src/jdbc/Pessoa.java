package jdbc;

public class Pessoa {

	private int codigo;
	private String nome;

	public Pessoa(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public final int getCodigo() {
		return codigo;
	}

	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}
}
