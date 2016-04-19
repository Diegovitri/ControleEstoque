package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.MaterialDao;
import model.domain.Material;
import model.facade.MaterialFacade;

@WebService(serviceName="ws/material")
public class MaterialFacadeImpl implements MaterialFacade {
	
	@Inject
	private MaterialDao materialDao;

	@WebMethod
	public List<Material> getMateriais() {
		return materialDao.getMateriais(new Material());
	}

	@Override
	@WebMethod(operationName="getMaterialCodigo")
	public List<Material> getMateriais(@WebParam(name="codigoMaterial") Integer codigo) {
		Material material = new Material();
		material.setCodigo(codigo);
		return materialDao.getMateriais(material);
	}

	@WebMethod
	public Material salvar(@WebParam(name="material") Material material) {
		return materialDao.salvar(material);
	}

	@WebMethod
	public void atualizar(@WebParam(name="material") Material material) {
		materialDao.atualizar(material);

	}

	@WebMethod
	public void deletarMaterial(@WebParam(name="codigoMaterial") Integer codigo) {
		Material material = new Material();
		material.setCodigo(codigo);
		materialDao.excluir(material);

	}

}
