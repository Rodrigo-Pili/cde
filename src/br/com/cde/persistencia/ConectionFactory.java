package br.com.cde.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
	public static Connection getConnection() {
		try {
			// for�a o carregamento do drive, como ele ta na web ele n�o esta conseguindo
			// carregar
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/cde?useTimezone=true&serverTimezone=UTC", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}	
	}
}
