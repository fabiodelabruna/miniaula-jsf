package br.senai.sc.aulas.miniaula;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.senai.sc.aulas.miniaula.model.Aluno;
import br.senai.sc.aulas.miniaula.util.JpaUtil;

public class AlunoDao {

	public void salvar(Aluno aluno) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		manager.persist(aluno);
		
		transaction.commit();
		manager.close();
	}
	
	public void alterar(Aluno aluno) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		aluno = manager.merge(aluno);
		
		transaction.commit();
		manager.close();
	}
	
	public void excluir(Aluno aluno) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		aluno = manager.find(Aluno.class, aluno.getId());
		manager.remove(aluno);
		
		transaction.commit();
		manager.close();
	}
	
	public List<Aluno> buscarTodos() {
		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<Aluno> query = manager.createQuery("from Aluno", Aluno.class);
		List<Aluno> alunos = query.getResultList();
		
		manager.close();
		
		return alunos;
	}
	
}
