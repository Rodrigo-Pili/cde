package br.com.cde.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cde.entidades.Autor;
import br.com.cde.persistencia.ConectionFactory;

public class AutorDAO {

	private Connection con = ConectionFactory.getConnection();
	private PreparedStatement stmt;
	private String sql;
	private ResultSet resultSet;

	public boolean cadastra(Autor autor) {
		sql = "insert into autor (nome_autor) values(?)";

		if (!(autor.getNome_autor().equals(""))) {
			try {
				stmt = con.prepareStatement(sql);

				stmt.setString(1, autor.getNome_autor());

				stmt.execute();

				stmt.close();
				
				return true;
			} catch (SQLException e) {
				System.out.println("Erro ao executar a query - CADASTRO DE AUTOR - " + e.getMessage());
			}
		}
		return false;
	}
}
