package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.AlmoxarifadoDao;
import model.domain.Almoxarifado;
import model.facade.AlmoxarifadoFacade;

@WebService(serviceName="ws/almoxarifado")
public class AlmoxarifadoFacadeImpl implements AlmoxarifadoFacade {
	
	@Inject
	private AlmoxarifadoDao almoxarifadoDao;

	@WebMethod
	public List<Almoxarifado> getAlmoxarifados() {
		return almoxarifadoDao.getAlmoxarifados(new Almoxarifado());
	}

	@Override
	@WebMethod(operationName="getAlmoxarifadoCodigo")
	public List<Almoxarifado> getAlmoxarifados(@WebParam(name="codigoAlmoxarifado") Integer codigo) {
		Almoxarifado almoxarifado = new Almoxarifado();
		almoxarifado.setCodigo(codigo);
		return almoxarifadoDao.getAlmoxarifados(almoxarifado);
	}

	@WebMethod
	public Almoxarifado salvar(@WebParam(name="almoxarifado") Almoxarifado almoxarifado) {
		return almoxarifadoDao.salvar(almoxarifado);
	}

	@WebMethod
	public void atualizar(@WebParam(name="almoxarifado") Almoxarifado almoxarifado) {
		almoxarifadoDao.atualizar(almoxarifado);

	}

	@WebMethod
	public void deletarAlmoxarifado(@WebParam(name="codigoAlmoxarifado") Integer codigo) {
		Almoxarifado almoxarifado = new Almoxarifado();
		almoxarifado.setCodigo(codigo);
		almoxarifadoDao.excluir(almoxarifado);

	}

}
