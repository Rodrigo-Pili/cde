package br.com.cde.entidades;

public class Funcionario {

	private Integer cod_funcionario;
	private String nome_funcionario;
	private String login_funcionario;
	private String senha_funcionario;
	private Integer cod_permissao;

	public Integer getCod_funcionario() {
		return cod_funcionario;
	}

	public void setCod_funcionario(Integer cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}

	public String getNome_funcionario() {
		return nome_funcionario;
	}

	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}

	public String getLogin_funcionario() {
		return login_funcionario;
	}

	public void setLogin_funcionario(String login_funcionario) {
		this.login_funcionario = login_funcionario;
	}

	public String getSenha_funcionario() {
		return senha_funcionario;
	}

	public void setSenha_funcionario(String senha_funcionario) {
		this.senha_funcionario = senha_funcionario;
	}

	public Integer getCod_permissao() {
		return cod_permissao;
	}

	public void setCod_permissao(Integer cod_permissao) {
		this.cod_permissao = cod_permissao;
	}

}
