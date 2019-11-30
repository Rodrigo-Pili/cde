package br.com.cde.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cde.dao.AutorDAO;
import br.com.cde.entidades.Autor;

@SuppressWarnings("deprecation")
@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();
	private AutorDAO dao = new AutorDAO();
	
	public Autor getAutor() {
		return autor;
	}
	
	public void voltar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroAutor.xhtml");
		} catch (IOException e) {
			System.out.println("Não foi possivel redirecionar para pagina - cadastroAutor.xhtml - " + e.getMessage());
		}
	}

	public void salvar() throws IOException {
		if (dao.cadastra(autor)) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("autorCadastrado.xhtml");
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.out.println("Não foi possivel efeturar o cadastramento do livro! " + e.getMessage());
			}
			return;
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("autorCadastradoFail.xhtml");
	}
}
