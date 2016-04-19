package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.AlocacaoDeMaterial;

public class AlocacaoDeMaterialDaoImpl implements AlocacaoDeMaterialDao {
	
	@PersistenceContext(unitName="ControleEstoquePU")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<AlocacaoDeMaterial> getAlocacaoDeMateriais(AlocacaoDeMaterial alocacaoDeMateriais) {
		StringBuffer hql = new StringBuffer("from AlocacaoDeMaterial al"
				+ " where 1 = 1");		
		if (alocacaoDeMateriais.getAlocacaoDeMaterialPK().getCodigoAlmoxarifado() != null) {
			hql.append(" and al.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (alocacaoDeMateriais.getAlocacaoDeMaterialPK().getCodigoAlmoxarifado() != null) {
			query.setParameter("codigo",alocacaoDeMateriais.getAlocacaoDeMaterialPK().getCodigoAlmoxarifado());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(AlocacaoDeMaterial alocacaoDeMateriais) {
		alocacaoDeMateriais = entityManager.merge(alocacaoDeMateriais);
		entityManager.remove(alocacaoDeMateriais);

	}

	@Override
	@Transactional
	public AlocacaoDeMaterial salvar(AlocacaoDeMaterial alocacaoDeMateriais) {
		entityManager.persist(alocacaoDeMateriais);
		return alocacaoDeMateriais;
	}

	@Override
	public void atualizar(AlocacaoDeMaterial alocacaoDeMateriais) {
		alocacaoDeMateriais = entityManager.merge(alocacaoDeMateriais);
		entityManager.persist(alocacaoDeMateriais);	

	}

}
