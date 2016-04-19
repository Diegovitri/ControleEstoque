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

import model.dao.AlmoxarifadoDao;
import model.domain.Almoxarifado;
import model.facade.AlmoxarifadoFacade;

@Path("/almoxarifado")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AlmoxarifadoFacadeImpl implements AlmoxarifadoFacade {
	
	@Inject
	private AlmoxarifadoDao almoxarifadoDao;

	/* (non-Javadoc)
	 * @see model.facade.rs.AlmoxarifadoFacade#getAlmoxarifados()
	 */

	@GET
	@Override
	public List<Almoxarifado> getAlmoxarifados() {
		return almoxarifadoDao.getAlmoxarifados(new Almoxarifado());
	}


	/* (non-Javadoc)
	 * @see model.facade.rs.AlmoxarifadoFacade#getAlmoxarifados(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Almoxarifado> getAlmoxarifados(@PathParam("codigo") Integer codigo) {
		Almoxarifado almoxarifado = new Almoxarifado();
		almoxarifado.setCodigo(codigo);
		return almoxarifadoDao.getAlmoxarifados(almoxarifado);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.AlmoxarifadoFacade#salvar(model.domain.Almoxarifado)
	 */
	@Override
	@POST 
	public Almoxarifado salvar(Almoxarifado almoxarifado) {
		almoxarifado = almoxarifadoDao.salvar(almoxarifado);
	 	return almoxarifado;
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.AlmoxarifadoFacade#atualizar(model.domain.Almoxarifado)
	 */
	@Override
	@PUT 
	public void atualizar(Almoxarifado almoxarifado) {
		almoxarifadoDao.atualizar(almoxarifado);

	}

	/* (non-Javadoc)
	 * @see model.facade.rs.AlmoxarifadoFacade#deletarAlmoxarifado(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAlmoxarifado(Integer codigo) {
		Almoxarifado almoxarifado = new Almoxarifado();
		almoxarifado.setCodigo(codigo);
		almoxarifadoDao.excluir(almoxarifado);

	}

}
