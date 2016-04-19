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

import model.dao.ObraDao;
import model.domain.Obra;
import model.facade.ObraFacade;

@Path("/obra")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ObraFacadeImpl implements ObraFacade {

	
	@Inject
	private ObraDao obraDao;
	
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ObraFacade#getObras()
	 */
	@Override
	@GET
	public List<Obra> getObras() {
		return obraDao.getObras(new Obra());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ObraFacade#getObras(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Obra> getObras(@PathParam("codigo") Integer codigo) {
		Obra obra = new Obra();
		obra.setCodigo(codigo);
		return obraDao.getObras(obra);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ObraFacade#salvar(model.domain.Obra)
	 */
	@Override
	@POST 
	public Obra salvar(Obra obra) {
		obra = obraDao.salvar(obra);
	 	return obra;
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ObraFacade#atualizar(model.domain.Obra)
	 */
	@Override
	@PUT 
	public void atualizar(Obra obra) {
		obraDao.atualizar(obra);

	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ObraFacade#deletarObra(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarObra(Integer codigo) {
		Obra obra = new Obra();
		obra.setCodigo(codigo);
		obraDao.excluir(obra);

	}

}
