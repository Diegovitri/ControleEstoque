package model.dao;

import java.util.List;

import model.domain.Construtora;

public interface ConstrutoraDao {
	List<Construtora>  getConstrutoras(Construtora construtora);
	
	public void excluir(Construtora construtora);

	Construtora salvar(Construtora construtora);

	void atualizar(Construtora construtora);

}