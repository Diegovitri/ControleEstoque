package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Obra;

public class ObraDaoImpl implements ObraDao {
	
	@PersistenceContext(unitName="ControleEstoquePU")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Obra> getObras(Obra obra) {
		StringBuffer hql = new StringBuffer("from Obra c"
				+ " where 1 = 1");		
		if (obra.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (obra.getCodigo() != null) {
			query.setParameter("codigo",obra.getCodigo());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Obra obra) {
		obra = entityManager.merge(obra);
		entityManager.remove(obra);

	}

	@Override
	@Transactional
	public Obra salvar(Obra obra) {
		entityManager.persist(obra);
		return obra;
	}

	@Override
	public void atualizar(Obra obra) {
		obra = entityManager.merge(obra);
		entityManager.persist(obra);

	}

}
