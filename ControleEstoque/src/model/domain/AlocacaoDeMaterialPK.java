package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlocacaoDeMaterialPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="CD_ALMOXARIFADO")
	private Integer codigoAlmoxarifado;
	
	@Column(name="CD_MATERIAL")
	private Integer codigoMaterial;

	public AlocacaoDeMaterialPK() {
	}

	public Integer getCodigoMaterial() {
		return codigoMaterial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoAlmoxarifado == null) ? 0 : codigoAlmoxarifado.hashCode());
		result = prime * result + ((codigoMaterial == null) ? 0 : codigoMaterial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlocacaoDeMaterialPK other = (AlocacaoDeMaterialPK) obj;
		if (codigoAlmoxarifado == null) {
			if (other.codigoAlmoxarifado != null)
				return false;
		} else if (!codigoAlmoxarifado.equals(other.codigoAlmoxarifado))
			return false;
		if (codigoMaterial == null) {
			if (other.codigoMaterial != null)
				return false;
		} else if (!codigoMaterial.equals(other.codigoMaterial))
			return false;
		return true;
	}

	public void setCodigoMaterial(Integer codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	public Integer getCodigoAlmoxarifado() {
		return codigoAlmoxarifado;
	}

	public void setCodigoAlmoxarifado(Integer codigoAlmoxarifado) {
		this.codigoAlmoxarifado = codigoAlmoxarifado;
	}

	

}
