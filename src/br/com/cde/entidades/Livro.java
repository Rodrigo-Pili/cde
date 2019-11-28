package br.com.cde.entidades;

public class Livro {

	private Integer cod_livro;
	private String titulo_livro;
	private String descricao_livro;
	private float preco;
	private Integer cod_genero;
	private Integer cod_funcionario;
	private Integer cod_editora;

	public Integer getCod_livro() {
		return cod_livro;
	}

	public void setCod_livro(Integer cod_livro) {
		this.cod_livro = cod_livro;
	}

	public String getTitulo_livro() {
		return titulo_livro;
	}

	public void setTitulo_livro(String titulo_livro) {
		this.titulo_livro = titulo_livro;
	}

	public String getDescricao_livro() {
		return descricao_livro;
	}

	public void setDescricao_livro(String descricao_livro) {
		this.descricao_livro = descricao_livro;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Integer getCod_genero() {
		return cod_genero;
	}

	public void setCod_genero(Integer cod_genero) {
		this.cod_genero = cod_genero;
	}

	public Integer getCod_funcionario() {
		return cod_funcionario;
	}

	public void setCod_funcionario(Integer cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}

	public Integer getCod_editora() {
		return cod_editora;
	}

	public void setCod_editora(Integer cod_editora) {
		this.cod_editora = cod_editora;
	}

}
