package br.com.cde.test;

import br.com.cde.dao.FuncionarioDAO;
import br.com.cde.entidades.Funcionario;

public class FuncionarioTest {
	public static void main(String[] args) {
		cadastra();
	}
	
	private static void cadastra() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome_funcionario("Silze Mehes");
		funcionario.setLogin_funcionario("silze");
		funcionario.setSenha_funcionario("123");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.cadastra(funcionario);
		
		System.out.println("Funcionario " + funcionario.getNome_funcionario() + " cadastrado com sucesso!");
	}
}
