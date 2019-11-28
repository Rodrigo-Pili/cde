package br.com.cde.test;

import br.com.cde.dao.EditoraDAO;
import br.com.cde.entidades.Editora;

public class EditoraTest {
	public static void main(String[] args) {
		cadastra();
	}
	
	public static void cadastra() {
		Editora editora = new Editora();
		editora.setNome_editora("Superbrands");
		
		EditoraDAO dao = new EditoraDAO();
		dao.cadastra(editora);
	}
}
