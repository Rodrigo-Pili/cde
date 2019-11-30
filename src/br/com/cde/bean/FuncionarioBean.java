package br.com.cde.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cde.dao.FuncionarioDAO;
import br.com.cde.entidades.Funcionario;

@SuppressWarnings("deprecation")
@ManagedBean
public class FuncionarioBean {

	private static Funcionario funcionario = new Funcionario();
	private FuncionarioDAO dao = new FuncionarioDAO();

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void cadastroAutor() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroAutor.xhtml");
		} catch (IOException e) {
			System.out
					.println("N�o foi poss�vel redirecionar para a p�gina - cadastroAutor.xhtml - " + e.getMessage());
		}
	}
	
	public void voltarTelaPrincipal() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("paginaPrincipalFuncionario.xhtml");
		} catch (IOException e) {
			System.out
					.println("N�o foi poss�vel redirecionar para a p�gina - paginaPrincipalFuncionario.xhtml - " + e.getMessage());
		}
	}
	
	public void cadastroLivro() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroLivro.xhtml");
		} catch (IOException e) {
			System.out
					.println("N�o foi poss�vel redirecionar para a p�gina - cadastroLivro.xhtml - " + e.getMessage());
		}
	}	
	
	public void cadastroEditora() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroEditora.xhtml");
		} catch (IOException e) {
			System.out
					.println("N�o foi poss�vel redirecionar para a p�gina - cadastroEditora.xhtml - " + e.getMessage());
		}
	}
	
	public void cadastroGenero() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroGenero.xhtml");
		} catch (IOException e) {
			System.out
					.println("N�o foi poss�vel redirecionar para a p�gina - cadastroGenero.xhtml - " + e.getMessage());
		}
	}
	
	public void cadastrar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroFuncionario.xhtml");
		} catch (IOException e) {
			System.out
					.println("N�o foi poss�vel redirecionar para a p�gina - cadastroFuncionario.xhtml - " + e.getMessage());
		}
	}
	
	public void voltarPrincipal() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("paginaPrincipalFuncionario.xhtml");
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel redirecionar para p�gina - paginaPrincipalFuncionario.xhtml " + e.getMessage());
		}
	}
	
	public void voltarLogin() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("loginFuncionario.xhtml");
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel redirecionar para p�gina - loginFuncionario.xhtml " + e.getMessage());
		}
	}
	
	public void voltarCadastro() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroFuncionario.xhtml");
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel redirecionar para p�gina - funcionarioCadastrado.xhtml " + e.getMessage());
		}
	}
	
	public void entrar() {
		funcionario = dao.autentica(getFuncionario());

		if (funcionario != null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("funcionario", funcionario);
				FacesContext.getCurrentInstance().getExternalContext().redirect("paginaPrincipalFuncionario.xhtml");
			} catch (IOException e) {
				System.out.println(
						"N�o foi poss�vel redirecionar para p�gina - paginaPrincipalFuncionario.xhtml - " + e.getMessage());
			}
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("loginFailFuncionario.xhtml");
			} catch (IOException e) {
				System.out.println("N�o foi poss�vel redirecionar para p�gina - loginFailFuncionario.xhtml - " + e.getMessage());
			}
		}
	}

	public void salvar() {
		if(dao.cadastra(getFuncionario())){
			System.out.println("Funcionario " + funcionario.getNome_funcionario() + " cadastrado com sucesso");
			
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("funcionarioCadastrado.xhtml");
			} catch (IOException e) {
				System.out.println("N�o foi poss�vel redirecionar para p�gina - funcionarioCadastrado.xhtml " + e.getMessage());
			}
			return;
		}
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("funcionarioCadastradoFail.xhtml");
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel redirecionar para p�gina - funcionarioCadastradoFail.xhtml " + e.getMessage());
		}
	}
	
	
}
