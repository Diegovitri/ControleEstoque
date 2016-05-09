package model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_ALOCACAO")
	private Integer codAlocacao;


	@Column(name="QT_SOLICITADA")
	private Integer quantidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_SOLICITACAO")
	private Date data;
	
	@Column(name="NM_SOLICITANTE")
	private String name;
	
	@OneToOne
	@JoinColumn(name= "CD_OBRA")
	private Obra obra;
	
	@OneToMany(mappedBy="alocacao")
	private List<Material> materiais;
	
	public AlocacaoDeMaterial() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}



	public Integer getCodAlocacao() {
		return codAlocacao;
	}



	public void setCodAlocacao(Integer codAlocacao) {
		this.codAlocacao = codAlocacao;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAlocacao == null) ? 0 : codAlocacao.hashCode());
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
		if (codAlocacao == null) {
			if (other.codAlocacao != null)
				return false;
		} else if (!codAlocacao.equals(other.codAlocacao))
			return false;
		return true;
	}

	


	
}
