package model.dao;

import java.util.List;

import model.domain.Obra;

public interface ObraDao {
	List<Obra>  getObras(Obra obra);
	
	public void excluir(Obra obra);

	Obra salvar(Obra obra);

	void atualizar(Obra obra);
}
