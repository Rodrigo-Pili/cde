package br.com.cde.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cde.dao.EditoraDAO;
import br.com.cde.entidades.Editora;

@SuppressWarnings("deprecation")
@ManagedBean
public class EditoraBean {
	
	EditoraDAO dao = new EditoraDAO();
	Editora editora = new Editora();
	
	public Editora getEditora() {
		return editora;
	}
	
	public void voltarCadastro() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroEditora.xhtml");
		} catch (IOException e) {
			System.out.println(
					"Não foi possível redirecionar para página - cadastroEditora.xhtml.xhtml " + e.getMessage());
		}
	}
	
	public void salvar() {
		if (dao.cadastra(getEditora())) {
			System.out.println("Editora " + editora.getNome_editora() + " editora com sucesso");

			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("editoraCadastrado.xhtml");
			} catch (IOException e) {
				System.out.println(
						"Não foi possível redirecionar para página - editoraCadastrado.xhtml " + e.getMessage());
			}
			return;
		}

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("editoraCadastradoFail.xhtml");
		} catch (IOException e) {
			System.out.println(
					"Não foi possível redirecionar para página - editoraCadastradoFail.xhtml " + e.getMessage());
		}

	}
}
