package br.com.cde.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cde.dao.GeneroDAO;
import br.com.cde.entidades.Genero;

@SuppressWarnings("deprecation")
@ManagedBean
public class GeneroBean {

	private Genero genero = new Genero();
	private GeneroDAO dao = new GeneroDAO();

	public Genero getGenero() {
		return genero;
	}

	public void cadastroGenero() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroGenero.xhtml");
		} catch (IOException e) {
			System.out
					.println("Não foi possível redirecionar para a página - cadastroGenero.xhtml - " + e.getMessage());
		}
	}

	public void salvar() {
		if (dao.cadastra(getGenero())) {
			System.out.println("Genero " + genero.getNome_genero() + " genero com sucesso");

			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("generoCadastrado.xhtml");
			} catch (IOException e) {
				System.out.println(
						"Não foi possível redirecionar para página - generoCadastrado.xhtml " + e.getMessage());
			}
			return;
		}

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("generoCadastradoFail.xhtml");
		} catch (IOException e) {
			System.out.println(
					"Não foi possível redirecionar para página - generoCadastradoFail.xhtml " + e.getMessage());
		}

	}
	
	public void voltar() {
		System.out.println("Clicou no voltar");
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroGenero.xhtml");
		} catch (IOException e) {
			System.out.println("Não foi possível redirecionar para a página - login.xhtml - " + e.getMessage());
		}
	}
}