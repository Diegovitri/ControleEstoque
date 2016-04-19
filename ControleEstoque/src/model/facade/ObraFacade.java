package model.facade;

import java.util.List;

import model.domain.Obra;

public interface ObraFacade {

	List<Obra> getObras();

	List<Obra> getObras(Integer codigo);

	Obra salvar(Obra obra);

	void atualizar(Obra obra);

	void deletarObra(Integer codigo);
}
