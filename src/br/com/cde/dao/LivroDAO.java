package br.com.cde.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cde.entidades.Funcionario;
import br.com.cde.entidades.Livro;
import br.com.cde.persistencia.ConectionFactory;

public class LivroDAO {
	
	private Connection con = ConectionFactory.getConnection();
	private String sql;
	private PreparedStatement stmt;
	private ResultSet resultSet;
	
	public boolean cadastra(Livro livro) {
		sql = "insert into livro (titulo_livro, descricao_livro, preco, cod_genero, cod_funcionario, cod_editora, qtd_livros)\r\n" + 
				"values(?, ?, ?, ?, ?, ?, ?);";

//		if (!(livro.getNome_funcionario().equals("") || livro.getLogin_funcionario().equals("")
//				|| livro.getSenha_funcionario().equals(""))) {
//			try {
//				stmt = con.prepareStatement(sql);
//
//				stmt.setString(1, livro.getNome_funcionario());
//				stmt.setString(2, livro.getLogin_funcionario());
//				stmt.setString(3, livro.getSenha_funcionario());
//
//				stmt.execute();
//
//				return true;
//
//			} catch (SQLException e) {
//				System.out.println("Não foi possível executar a query - CADASTRAR FUNCIONARIO - " + e.getMessage());
//			}
//		}
		return false;
	}
}
