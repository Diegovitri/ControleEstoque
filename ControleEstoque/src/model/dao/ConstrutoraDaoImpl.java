package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Construtora;

public class ConstrutoraDaoImpl implements ConstrutoraDao {
	
	@PersistenceContext(unitName="ControleEstoquePU")
	private EntityManager entityManager;

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Construtora> getConstrutoras(Construtora construtora) {
		StringBuffer hql = new StringBuffer("from Construtora c"
				+ " where 1 = 1");		
		if (construtora.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (construtora.getCodigo() != null) {
			query.setParameter("codigo",construtora.getCodigo());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Construtora construtora) {
		construtora = entityManager.merge(construtora);
		entityManager.remove(construtora);
	}

	@Override
	@Transactional
	public Construtora salvar(Construtora construtora) {
		entityManager.persist(construtora);
		return construtora;
	}

	@Override
	public void atualizar(Construtora construtora) {
		construtora = entityManager.merge(construtora);
		entityManager.persist(construtora);	

	}

}
