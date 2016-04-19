package model.dao;

import java.util.List;

import model.domain.Almoxarifado;

public interface AlmoxarifadoDao {
List< Almoxarifado>  getAlmoxarifados(Almoxarifado almoxarifado);
	
	public void excluir(Almoxarifado almoxarifado);

	Almoxarifado salvar(Almoxarifado almoxarifado);

	void atualizar(Almoxarifado almoxarifado);

}
