package model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="ALOCACAO_DE_MATERIAL")
public class AlocacaoDeMaterial implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlocacaoDeMaterialPK alocacaoDeMaterialPK;
	
	@Column(name="QT_SOLICITADA")
	private Integer quantidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_SOLICITACAO")
	private Date data;
	
	@Column(name="NM_SOLICITANTE")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CD_MATERIAL",referencedColumnName="CD_MATERIAL",
	insertable=false,updatable=false)
	private Material material;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CD_OBRA",referencedColumnName="CD_OBRA",
			insertable=false,updatable=false)
	private Obra obra;


	public AlocacaoDeMaterial() {

	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	/*public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}*/

	public AlocacaoDeMaterialPK getAlocacaoDeMaterialPK() {
		return alocacaoDeMaterialPK;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public void setAlocacaoDeMaterialPK(AlocacaoDeMaterialPK alocacaoDeMaterialPK) {
		this.alocacaoDeMaterialPK = alocacaoDeMaterialPK;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alocacaoDeMaterialPK == null) ? 0 : alocacaoDeMaterialPK.hashCode());
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
		AlocacaoDeMaterial other = (AlocacaoDeMaterial) obj;
		if (alocacaoDeMaterialPK == null) {
			if (other.alocacaoDeMaterialPK != null)
				return false;
		} else if (!alocacaoDeMaterialPK.equals(other.alocacaoDeMaterialPK))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
