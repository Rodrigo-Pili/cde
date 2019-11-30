package br.com.cde.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cde.dao.LivroDAO;
import br.com.cde.entidades.Funcionario;
import br.com.cde.entidades.Livro;

@SuppressWarnings("deprecation")
@ManagedBean
public class livroBean {
	private Livro livro = new Livro();
	private LivroDAO dao = new LivroDAO();
	private Funcionario funcionario = new FuncionarioBean().getFuncionario();
	
	public Livro getLivro() {
		return livro;
	}
	
	public void salvar() {
		if(dao.cadastra(livro, funcionario)) {
			
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("livroCadastrado.xhtml");
			} catch (IOException e) {
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("livroCadastradoFail.xhtml");
				} catch (IOException e1) {
					System.out.println("Nao foi possível redirecionar para a página -- livro cadastradoFail.xhtml");
				}
				System.out.println("Não foi possivel efetuar o cadastramento de livro! " + e.getMessage());
			}
		}
	}
}
