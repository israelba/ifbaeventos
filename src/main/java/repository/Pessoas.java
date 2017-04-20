package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Pessoa;

public class Pessoas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public Pessoas(EntityManager manager){
		this.manager = manager;
	}
	
	public Pessoa porId(Long id){
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> todos(){
		TypedQuery<Pessoa> query = manager.createQuery(
				"from Pessoa", Pessoa.class);
		return query.getResultList();
	}
	
	public void guardar(Pessoa pessoa){
		this.manager.merge(pessoa);
	}
	
	public void remover(Pessoa pessoa){
		this.manager.remove(pessoa);
	}

}
