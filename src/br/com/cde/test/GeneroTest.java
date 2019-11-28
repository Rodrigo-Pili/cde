package br.com.cde.test;

import br.com.cde.dao.GeneroDAO;
import br.com.cde.entidades.Genero;

public class GeneroTest {

	public static void main(String[] args) {
		cadastra();
	}

	public static void cadastra() {
		Genero genero = new Genero();
		genero.setNome_genero("JavaScript");
		
		GeneroDAO dao = new GeneroDAO();
		dao.cadastra(genero);
	}
}
