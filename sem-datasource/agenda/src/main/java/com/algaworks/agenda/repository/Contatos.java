package com.algaworks.agenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.agenda.model.Contato;
import com.algaworks.agenda.util.jpa.Transactional;

public class Contatos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void adicionar(Contato contato) {
		manager.persist(contato);
	}

	public List<Contato> todos() {
		return manager.createQuery("from Contato order by nome", Contato.class).getResultList();
	}

}
