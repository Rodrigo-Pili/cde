package br.com.cde.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cde.entidades.Livro;
import br.com.cde.persistencia.ConectionFactory;

public class LivroDAO {

	private Connection con = ConectionFactory.getConnection();
	private String sql;
	private PreparedStatement stmt;
	private ResultSet resultSet;

	public boolean cadastra(Livro livro) {
		sql = "insert into livro (titulo_livro, descricao_livro, preco, cod_genero, cod_funcionario, cod_editora, qtd_livros)\r\n"
				+ "values(?, ?, ?, ?, ?, ?, ?)";

		if (!(livro.getTitulo_livro().equals("") || livro.getPreco() < 0 || livro.getQtd_livros() < 0)) {
			try {
				stmt = con.prepareStatement(sql);

				stmt.setString(1, livro.getTitulo_livro());
				stmt.setString(2, livro.getDescricao_livro());
				stmt.setFloat(3, livro.getPreco());
				stmt.setInt(4, livro.getCod_genero());
				stmt.setInt(5, livro.getCod_funcionario());
				stmt.setInt(6, livro.getCod_editora());
				stmt.setInt(7, livro.getQtd_livros());

				stmt.execute();

				System.out.println("Livro cadastrado com sucesso");
				return true;
			} catch (SQLException e) {
				System.out.println("Não foi possível executar a query - CADASTRAR LIVRO - " + e.getMessage());
			}
		}
		return false;

	}
}