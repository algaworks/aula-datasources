package com.algaworks.agenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.agenda.model.Contato;
import com.algaworks.agenda.repository.Contatos;

@Named
@ViewScoped
public class CadastroContatoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Contato contato;

	private List<Contato> todosContatos;

	@Inject
	private Contatos contatos;
	
	@PostConstruct
	public void iniciar() {
		this.contato = new Contato();
		this.todosContatos = contatos.todos();
	}

	public void cadastrar() {
		this.contatos.adicionar(this.contato);
		this.iniciar();
	}

	public List<Contato> getTodosContatos() {
		return todosContatos;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
