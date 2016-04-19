package model.facade;

import java.util.List;

import model.domain.Almoxarifado;

public interface AlmoxarifadoFacade {
	
	List<Almoxarifado> getAlmoxarifados();

	List<Almoxarifado> getAlmoxarifados(Integer codigo);

	Almoxarifado salvar(Almoxarifado almoxarifado);

	void atualizar(Almoxarifado almoxarifado);

	void deletarAlmoxarifado(Integer codigo);

}
