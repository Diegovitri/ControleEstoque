package model.facade;

import java.util.List;

import model.domain.AlocacaoDeMaterial;

public interface AlocacaoDeMaterialFacade {
	List<AlocacaoDeMaterial> getAlocacaoDeMateriais();

	List<AlocacaoDeMaterial> getAlocacaoDeMateriais(Integer codigo);

	AlocacaoDeMaterial salvar(AlocacaoDeMaterial alocacaoDeMaterial);

	void atualizar(AlocacaoDeMaterial alocacaoDeMaterial);

	void deletarAlocacaoDeMaterial(Integer codigo);

}
