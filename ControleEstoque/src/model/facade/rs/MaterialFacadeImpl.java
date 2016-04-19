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

import model.dao.MaterialDao;
import model.domain.Material;
import model.facade.MaterialFacade;

@Path("/material")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MaterialFacadeImpl implements MaterialFacade {
	
	@Inject
	private MaterialDao materialDao;

	/* (non-Javadoc)
	 * @see model.facade.rs.MaterialFacade#getMateriais()
	 */
	@Override
	@GET
	public List<Material> getMateriais() {
		return materialDao.getMateriais(new Material());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.MaterialFacade#getMateriais(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Material> getMateriais(@PathParam("codigo") Integer codigo) {
		Material material = new Material();
		material.setCodigo(codigo);
		return materialDao.getMateriais(material);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.MaterialFacade#salvar(model.domain.Material)
	 */
	@Override
	@POST
	public Material salvar(Material material) {
		material = materialDao.salvar(material);
	 	return material;
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.MaterialFacade#atualizar(model.domain.Material)
	 */
	@Override
	@PUT 
	public void atualizar(Material material) {
		materialDao.atualizar(material);

	}

	/* (non-Javadoc)
	 * @see model.facade.rs.MaterialFacade#deletarMaterial(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarMaterial(Integer codigo) {
		Material material = new Material();
		material.setCodigo(codigo);
		materialDao.excluir(material);


	}

}
