package br.com.cde.test;

import br.com.cde.dao.LivroDAO;
import br.com.cde.entidades.Funcionario;
import br.com.cde.entidades.Livro;

public class LivroTest {
	public static void main(String[] args) {
		cadastra();
	}
	
	public static void cadastra() {
		Livro livro = new Livro();
		livro.setTitulo_livro("Pirilim");
		livro.setDescricao_livro("Livro didatico");
		livro.setPreco_livro(50.5f);
		livro.setCod_funcionario(2);
		livro.setCod_genero(1);
		livro.setCod_editora(1);
		livro.setQtd_livros(2);
		
		LivroDAO dao = new LivroDAO();
		//dao.cadastra(livro, Funcionario);
	}
}
