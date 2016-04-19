package model.dao;

import java.util.List;

import model.domain.AlocacaoDeMaterial;

public interface AlocacaoDeMaterialDao {
	
	List< AlocacaoDeMaterial>  getAlocacaoDeMateriais(AlocacaoDeMaterial alocacaoDeMateriais);
	
	public void excluir(AlocacaoDeMaterial alocacaoDeMateriais);

	AlocacaoDeMaterial salvar(AlocacaoDeMaterial alocacaoDeMateriais);

	void atualizar(AlocacaoDeMaterial alocacaoDeMateriais);

}
