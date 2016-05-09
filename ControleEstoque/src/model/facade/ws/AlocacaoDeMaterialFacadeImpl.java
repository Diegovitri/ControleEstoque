package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.AlocacaoDeMaterialDao;
import model.domain.AlocacaoDeMaterial;
import model.facade.AlocacaoDeMaterialFacade;

@WebService(serviceName="ws/alocacaodematerial")
public class AlocacaoDeMaterialFacadeImpl implements AlocacaoDeMaterialFacade {
	
	@Inject
	private AlocacaoDeMaterialDao alocacaoDeMaterialDao;

	@WebMethod
	public List<AlocacaoDeMaterial> getAlocacaoDeMateriais() {
		return alocacaoDeMaterialDao.getAlocacaoDeMateriais(new AlocacaoDeMaterial());
	}

	@Override
	@WebMethod(operationName="getAlocacaoDeMaterialCodigo")
	public List<AlocacaoDeMaterial> getAlocacaoDeMateriais(@WebParam(name="codigoAlocacaoDeMaterialCodigo") Integer codigo) {
		AlocacaoDeMaterial alocacaoDeMaterial = new AlocacaoDeMaterial();
		
		alocacaoDeMaterial.setCodAlocacao(codigo);
		return alocacaoDeMaterialDao.getAlocacaoDeMateriais(alocacaoDeMaterial);
	}

	@WebMethod
	public AlocacaoDeMaterial salvar(@WebParam(name="alocacaoDeMaterial") AlocacaoDeMaterial alocacaoDeMaterial) {
		return alocacaoDeMaterialDao.salvar(alocacaoDeMaterial);
	}

	@WebMethod
	public void atualizar(@WebParam(name="alocacaoDeMaterial") AlocacaoDeMaterial alocacaoDeMaterial) {
		alocacaoDeMaterialDao.atualizar(alocacaoDeMaterial);

	}

	@WebMethod
	public void deletarAlocacaoDeMaterial(@WebParam(name="codigoAlocacaoDeMaterialCodigo") Integer codigo) {
		AlocacaoDeMaterial alocacaoDeMaterial = new AlocacaoDeMaterial();
		
		
		//Dúvida sobre este metodo, pois no banco de dados é uma tabela onde tem duas chaves primarias que são estrangeiras tbm
		alocacaoDeMaterial.setCodAlocacao(codigo);
		
		alocacaoDeMaterialDao.excluir(alocacaoDeMaterial);

	}

}
