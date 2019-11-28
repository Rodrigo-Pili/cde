package br.com.cde.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cde.entidades.Editora;
import br.com.cde.persistencia.ConectionFactory;

public class EditoraDAO {

	private Connection con = ConectionFactory.getConnection();
	private PreparedStatement stmt;
	private String sql;

	public boolean cadastra(Editora editora) {
		sql = "insert into editora (nome_editora) values (?)";

		if (!editora.getNome_editora().equals("")) {
			try {
				stmt = con.prepareStatement(sql);

				stmt.setString(1, editora.getNome_editora());

				stmt.execute();

				stmt.close();

				return true;
			} catch (SQLException e) {
				System.out.println("Erro ao executar a query - CADASTRO DE EDITORA - " + e.getMessage());
			}
		}
		return false;
	}

}
