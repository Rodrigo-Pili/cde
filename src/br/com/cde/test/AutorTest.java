package br.com.cde.test;

import br.com.cde.dao.AutorDAO;
import br.com.cde.entidades.Autor;

public class AutorTest {

	public static void main(String[] args) {
		cadastra();
	}
	
	public static void cadastra() {
		Autor autor = new Autor();
		autor.setNome_autor("Rodrigo Pili");
		
		AutorDAO dao = new AutorDAO();
		dao.cadastra(autor);
	}
}
