package model.facade;

import java.util.List;

import model.domain.Material;

public interface MaterialFacade {
	List<Material> getMateriais();

	List<Material> getMateriais(Integer codigo);

	Material salvar(Material material);

	void atualizar(Material material);

	void deletarMaterial(Integer codigo);

}
