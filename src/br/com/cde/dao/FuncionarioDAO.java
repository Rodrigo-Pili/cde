package br.com.cde.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cde.entidades.Funcionario;
import br.com.cde.persistencia.ConectionFactory;

public class FuncionarioDAO {

	private Connection con = ConectionFactory.getConnection();
	private String sql;
	private PreparedStatement stmt;
	private ResultSet resultSet;

	public boolean cadastra(Funcionario funcionario) {
		sql = "insert into funcionario (nome_funcionario, login_funcionario, senha_funcionario, cod_permissao) values(?, ?, ?, 2)";

		if (!(funcionario.getNome_funcionario().equals("") || funcionario.getLogin_funcionario().equals("")
				|| funcionario.getSenha_funcionario().equals(""))) {
			try {
				stmt = con.prepareStatement(sql);

				stmt.setString(1, funcionario.getNome_funcionario());
				stmt.setString(2, funcionario.getLogin_funcionario());
				stmt.setString(3, funcionario.getSenha_funcionario());

				stmt.execute();

				return true;

			} catch (SQLException e) {
				System.out.println("Não foi possível executar a query - CADASTRAR FUNCIONARIO - " + e.getMessage());
			}
		}
		return false;
	}

	public Funcionario autentica(Funcionario funcionarioConsulta) {
		sql = "select * from funcionario where login_funcionario = ? and senha_funcionario = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, funcionarioConsulta.getLogin_funcionario());
			stmt.setString(2, funcionarioConsulta.getSenha_funcionario());

			resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				Funcionario funcionario = new Funcionario();

				funcionario.setCod_funcionario(resultSet.getInt("cod_funcionario"));
				funcionario.setNome_funcionario(resultSet.getString("nome_funcionario"));
				funcionario.setLogin_funcionario(resultSet.getString("login_funcionario"));
				funcionario.setSenha_funcionario(resultSet.getString("senha_funcionario"));
				funcionario.setCod_permissao(resultSet.getInt("cod_permissao"));

				return funcionario;
			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query - AUTENTICAÇÃO - " + e.getMessage());
		}

		return null;
	}
}
