package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.ObraDao;
import model.domain.Obra;
import model.facade.ObraFacade;

@WebService(serviceName="ws/obra")
public class ObraFacadeImpl implements ObraFacade {
	
	@Inject
	private ObraDao obraDao;

	@WebMethod
	public List<Obra> getObras() {
		return obraDao.getObras(new Obra());
	}

	@Override
	@WebMethod(operationName="getObraCodigo")
	public List<Obra> getObras(@WebParam(name="codigoObra") Integer codigo) {
		Obra obra = new Obra();
		obra.setCodigo(codigo);
		return obraDao.getObras(obra);
	}

	@WebMethod
	public Obra salvar(@WebParam(name="obra") Obra obra) {
		return obraDao.salvar(obra);
	}

	@WebMethod
	public void atualizar(@WebParam(name="obra") Obra obra) {
		obraDao.atualizar(obra);

	}

	@WebMethod
	public void deletarObra(@WebParam(name="codigoObra") Integer codigo) {
		Obra obra = new Obra();
		obra.setCodigo(codigo);
		obraDao.excluir(obra);

	}

}
