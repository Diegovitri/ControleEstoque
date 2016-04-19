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

import model.dao.ConstrutoraDao;
import model.domain.Construtora;
import model.facade.ConstrutoraFacade;

@Path("/construtora")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ConstrutoraFacadeImpl implements ConstrutoraFacade {
	
	@Inject
	private ConstrutoraDao construtoraDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ConstrutoraFacade#getConstrutoras()
	 */
	@Override
	@GET
	public List<Construtora> getConstrutoras() {
		return construtoraDao.getConstrutoras(new Construtora());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ConstrutoraFacade#getConstrutoras(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Construtora> getConstrutoras(@PathParam("codigo") Integer codigo) {
		Construtora construtora = new Construtora();
		construtora.setCodigo(codigo);
		return construtoraDao.getConstrutoras(construtora);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ConstrutoraFacade#salvar(model.domain.Construtora)
	 */
	@Override
	@POST 
	public Construtora salvar(Construtora construtora) {
		construtora = construtoraDao.salvar(construtora);
	 	return construtora;
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ConstrutoraFacade#atualizar(model.domain.Construtora)
	 */
	@Override
	@PUT 
	public void atualizar(Construtora construtora) {
		construtoraDao.atualizar(construtora);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ConstrutoraFacade#deletarConstutora(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarConstrutora(Integer codigo) {
		Construtora construtora = new Construtora();
		construtora.setCodigo(codigo);
		construtoraDao.excluir(construtora);

	}

}
