package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.AlocacaoDeMaterialDao;
import model.domain.AlocacaoDeMaterial;
import model.facade.AlocacaoDeMaterialFacade;

@Path("/alocacaodematerial")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AlocacaoDeMaterialFacadeImpl implements AlocacaoDeMaterialFacade {
	
	@Inject
	private AlocacaoDeMaterialDao alocacaoDeMaterialDao;
	/* (non-Javadoc)
	 * @see model.facade.rs.AlocacaoDeMaterialFacade#getAlocacaoDeMateriais()
	 */
	@Override
	@GET
	public List<AlocacaoDeMaterial> getAlocacaoDeMateriais() {
		return alocacaoDeMaterialDao.getAlocacaoDeMateriais(new AlocacaoDeMaterial());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.AlocacaoDeMaterialFacade#getAlocacaoDeMateriais(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<AlocacaoDeMaterial> getAlocacaoDeMateriais(@PathParam("codigo") Integer codigo) {
		
		AlocacaoDeMaterial alocacaoDeMaterial = new AlocacaoDeMaterial();

		//Dúvida sobre este metodo, pois no banco de dados é uma tabela onde tem duas chaves primarias que são estrangeiras tbm
		//alocacaoDeMaterial.getAlocacaoDeMaterialPK().setCodigoAlmoxarifado(codigo);
		alocacaoDeMaterial.setCodAlocacao(codigo);
		return alocacaoDeMaterialDao.getAlocacaoDeMateriais(alocacaoDeMaterial);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.AlocacaoDeMaterialFacade#salvar(model.domain.AlocacaoDeMaterial)
	 */
	@Override
	@POST 
	public AlocacaoDeMaterial salvar(AlocacaoDeMaterial alocacaoDeMaterial) {
		alocacaoDeMaterial = alocacaoDeMaterialDao.salvar(alocacaoDeMaterial);
	 	return alocacaoDeMaterial;
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.AlocacaoDeMaterialFacade#atualizar(model.domain.AlocacaoDeMaterial)
	 */
	@Override
	@PUT
	public void atualizar(AlocacaoDeMaterial alocacaoDeMaterial) {
		alocacaoDeMaterialDao.atualizar(alocacaoDeMaterial);

	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ConstrutoraFacade#deletarConstutora(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAlocacaoDeMaterial(Integer codigo) {
		AlocacaoDeMaterial alocacaoDeMaterial = new AlocacaoDeMaterial();
		
		//Dúvida sobre este metodo, pois no banco de dados é uma tabela onde tem duas chaves primarias que são estrangeiras tbm
		alocacaoDeMaterial.setCodAlocacao(codigo);
		alocacaoDeMaterialDao.excluir(alocacaoDeMaterial);

	}

}
