package br.com.cde.entidades;

public class Cliente {

	private Integer cod_cliente;
	private String nome_cliente;
	private String email_cliente;
	private String login_cliente;
	private String senha_cliente;
	private Integer cod_permissao;

	public Integer getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(Integer cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_clliente) {
		this.nome_cliente = nome_clliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getLogin_cliente() {
		return login_cliente;
	}

	public void setLogin_cliente(String login_cliente) {
		this.login_cliente = login_cliente;
	}

	public String getSenha_cliente() {
		return senha_cliente;
	}

	public void setSenha_cliente(String senha_cliente) {
		this.senha_cliente = senha_cliente;
	}

	public Integer getCod_permissao() {
		return cod_permissao;
	}

	public void setCod_permissao(Integer cod_permissao) {
		this.cod_permissao = cod_permissao;
	}

}