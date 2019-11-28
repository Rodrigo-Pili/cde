package br.com.cde.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cde.entidades.Genero;
import br.com.cde.persistencia.ConectionFactory;

public class GeneroDAO {

	private Connection con = ConectionFactory.getConnection();
	private PreparedStatement stmt;
	private String sql;

	public boolean cadastra(Genero genero) {
		sql = "insert into genero (nome_genero) values (?);";

		if (!(genero.getNome_genero().equals(""))) {
			try {
				stmt = con.prepareStatement(sql);

				stmt.setString(1, genero.getNome_genero());

				stmt.execute();

				stmt.close();

				return true;
			} catch (SQLException e) {
				System.out.println("Erro ao executar a query - CADASTRO DE GENERO - " + e.getMessage());
			}
		}
		return false;
	}

}
