package br.com.cde.test;

import br.com.cde.dao.ClienteDAO;
import br.com.cde.entidades.Cliente;

public class ClienteTest {

	public static void main(String[] args) {
		cadastra();
	}
	
	private static void cadastra() {
		Cliente cliente = new Cliente();
		cliente.setNome_cliente("Silze Cristiane de Souza Pili Mehes");
		cliente.setLogin_cliente("silze");
		cliente.setSenha_cliente("123");
		cliente.setEmail_cliente("silze.mehes@uol.com.br");
		
		ClienteDAO dao = new ClienteDAO();
		dao.cadastra(cliente);
	}
}
