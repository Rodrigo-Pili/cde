package br.com.cde.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cde.dao.ClienteDAO;
import br.com.cde.entidades.Cliente;

@SuppressWarnings("deprecation")
@ManagedBean
public class CadastroClienteBean {

	private Cliente cliente = new Cliente();
	private ClienteDAO dao = new ClienteDAO();

	public Cliente getCliente() {
		return cliente;
	}

	public void salvar() {
		if (dao.cadastra(getCliente())) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("clienteCadastrado.xhtml");
			} catch (IOException e) {
				System.out.println(
						"N�o foi poss�vel redirecionar para a p�gina - clienteCadastrado.xhtml - " + e.getMessage());
			}

			return;
		}

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("clienteCadastradoFail.xhtml");
		} catch (IOException e) {
			System.out.println(
					"N�o foi poss�vel redirecionar para a p�gina - clienteCadastradoFail.xhtml - " + e.getMessage());
		}
	}

	public void entrar() {
		Cliente cliente = dao.autentica(getCliente());
		
		if (cliente != null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
				FacesContext.getCurrentInstance().getExternalContext().redirect("paginaPrincipal.xhtml");
			} catch (IOException e) {
				System.out.println(
						"N�o foi poss�vel redirecionar para p�gina - paginaPrincipal.xhtml - " + e.getMessage());
			}
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("loginFail.xhtml");
			} catch (IOException e) {
				System.out.println("N�o foi poss�vel redirecionar para p�gina - loginFail.xhtml - " + e.getMessage());
				
			}
		}
	}

	public void cadastrar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroCliente.xhtml");
		} catch (IOException e) {
			System.out
					.println("N�o foi poss�vel redirecionar para a p�gina - cadastroCliente.xhtml - " + e.getMessage());
		}
	}

	public void voltarParaCadastro() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroCliente.xhtml");
		} catch (IOException e) {
			System.out
					.println("N�o foi poss�vel redirecionar para a p�gina - cadastroCliente.xhtml - " + e.getMessage());
		}
	}

	public void voltar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel redirecionar para a p�gina - login.xhtml - " + e.getMessage());
		}
	}
}
