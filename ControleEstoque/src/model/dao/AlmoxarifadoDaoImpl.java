package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Almoxarifado;

public class AlmoxarifadoDaoImpl implements AlmoxarifadoDao {
	
	@PersistenceContext(unitName="ControleEstoquePU")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Almoxarifado> getAlmoxarifados(Almoxarifado almoxarifado) {
		StringBuffer hql = new StringBuffer("from Almoxarifado a"
				+ " where 1 = 1");		
		if (almoxarifado.getCodigo() != null) {
			hql.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (almoxarifado.getCodigo() != null) {
			query.setParameter("codigo",almoxarifado.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Almoxarifado almoxarifado) {
		almoxarifado = entityManager.merge(almoxarifado);
		entityManager.remove(almoxarifado);

	}

	@Override
	@Transactional
	public Almoxarifado salvar(Almoxarifado almoxarifado) {
		entityManager.persist(almoxarifado);
		return almoxarifado;
	}

	@Override
	public void atualizar(Almoxarifado almoxarifado) {
		almoxarifado = entityManager.merge(almoxarifado);
		entityManager.persist(almoxarifado);	

	}

}
