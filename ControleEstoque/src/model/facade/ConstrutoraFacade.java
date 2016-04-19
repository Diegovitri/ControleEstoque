package model.facade;

import java.util.List;

import model.domain.Construtora;


public interface ConstrutoraFacade {
	
	List<Construtora> getConstrutoras();

	List<Construtora> getConstrutoras(Integer codigo);

	Construtora salvar(Construtora construtora);

	void atualizar(Construtora construtora);

	void deletarConstrutora(Integer codigo);

}
