package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlRootElement;

@Transactional
@XmlRootElement
@Entity
@Table(name="TB_OBRA")
public class Obra implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_OBRA")
	private Integer codigo;
	
	@Column(name="NM_OBRA")
	private String nome;
	
	@Column(name="DS_ENDERECO")
	private String endereco;
		
	@Column(name="NUMERO")
	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name="CD_CONSTRUTORA",referencedColumnName="CD_CONSTRUTORA")
	private Construtora construtora;
	
	/*@OneToOne
	@JoinColumn(name="CD_ALMOXARIFADO",referencedColumnName="CD_ALMOXARIFADO")
	private Almoxarifado almoxarifado;
	

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}*/

	public Obra() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Construtora getConstrutora() {
		return construtora;
	}

	public void setConstrutora(Construtora construtora) {
		this.construtora = construtora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Obra other = (Obra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	

}
