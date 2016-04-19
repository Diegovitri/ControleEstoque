package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Material;

public class MaterialDaoImpl implements MaterialDao {
	
	@PersistenceContext(unitName="ControleEstoquePU")
	private EntityManager entityManager;


	@Override
	@SuppressWarnings("unchecked")
	public List<Material> getMateriais(Material material) {
		StringBuffer hql = new StringBuffer("from Material m"
				+ " where 1 = 1");		
		if (material.getCodigo() != null) {
			hql.append(" and m.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (material.getCodigo() != null) {
			query.setParameter("codigo",material.getCodigo());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Material material) {
		material = entityManager.merge(material);
		entityManager.remove(material);

	}

	@Override
	@Transactional
	public Material salvar(Material material) {
		entityManager.persist(material);
		return material;
	}

	@Override
	public void atualizar(Material material) {
		material = entityManager.merge(material);
		entityManager.persist(material);	

	}

}
