package br.com.cde.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cde.entidades.Cliente;
import br.com.cde.persistencia.ConectionFactory;

public class ClienteDAO {

	private Connection con = ConectionFactory.getConnection();
	private PreparedStatement stmt;
	private String sql;
	private ResultSet resultSet;

	public boolean cadastra(Cliente cliente) {
		sql = "insert into cliente (nome_cliente, login_cliente, senha_cliente, email_cliente, cod_permissao) values(?, ?, ?, ?, 1)";

		if (!(cliente.getNome_cliente().equals("") || cliente.getLogin_cliente().equals("")
				|| cliente.getSenha_cliente().equals(""))) {
			try {
				stmt = con.prepareStatement(sql);

				stmt.setString(1, cliente.getNome_cliente());
				stmt.setString(2, cliente.getLogin_cliente());
				stmt.setString(3, cliente.getSenha_cliente());
				stmt.setString(4, cliente.getEmail_cliente());

				stmt.execute();

				stmt.close();
				
				return true;
			} catch (SQLException e) {
				System.out.println("Erro ao executar a query - CADASTRO DE CLIENTE - " + e.getMessage());
			}
		}
		return false;
	}

	public Cliente autentica(Cliente clienteConsulta) {
		sql = "select * from cliente where login_cliente = ? and senha_cliente = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, clienteConsulta.getLogin_cliente());
			stmt.setString(2, clienteConsulta.getSenha_cliente());

			resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				Cliente cliente = new Cliente();

				cliente.setCod_cliente(resultSet.getInt("cod_cliente"));
				cliente.setNome_cliente(resultSet.getString("nome_cliente"));
				cliente.setLogin_cliente(resultSet.getString("login_cliente"));
				cliente.setSenha_cliente(resultSet.getString("senha_cliente"));
				cliente.setEmail_cliente(resultSet.getString("email_cliente"));
				cliente.setCod_permissao(resultSet.getInt("cod_permissao"));

				return cliente;
			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query - AUTENTICAÇÃO - " + e.getMessage());
		}

		return null;
	}
}
