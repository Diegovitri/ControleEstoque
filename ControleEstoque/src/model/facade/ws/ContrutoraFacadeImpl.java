package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.ConstrutoraDao;
import model.domain.Construtora;
import model.facade.ConstrutoraFacade;

@WebService(serviceName="ws/construtora")
public class ContrutoraFacadeImpl implements ConstrutoraFacade{
	
	@Inject
	private ConstrutoraDao construtoraDao;
			
	@WebMethod
	public List<Construtora> getConstrutoras() {
		return construtoraDao.getConstrutoras(new Construtora());
	}
	
	@Override
	@WebMethod(operationName="getConstrutoraCodigo")
	public List<Construtora> getConstrutoras(@WebParam(name="codigoConstrutora") 
							Integer codigo) {
		Construtora construtora = new Construtora();
		construtora.setCodigo(codigo);
		return construtoraDao.getConstrutoras(construtora);
	}
	
	@WebMethod
	public Construtora salvar(@WebParam(name="construtora") Construtora construtora) {
		return construtoraDao.salvar(construtora);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="construtora") Construtora construtora) {
		construtoraDao.atualizar(construtora);
	}
	
	@WebMethod
	public void deletarConstrutora(@WebParam(name="codigoConstrutora") Integer codigo) {
		Construtora construtora = new Construtora();
		construtora.setCodigo(codigo);
		construtoraDao.excluir(construtora);
	}

}
