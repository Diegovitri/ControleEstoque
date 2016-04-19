package model.dao;

import java.util.List;

import model.domain.Material;

public interface MaterialDao {
	List< Material>  getMateriais(Material material);
	
	public void excluir(Material material);

	Material salvar(Material material);

	void atualizar(Material material);

}
