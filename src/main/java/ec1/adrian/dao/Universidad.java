package ec1.adrian.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="universidad")
public class Universidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUni;
	private String universidad;
	public Integer getIdUni() {
		return idUni;
	}
	public void setIdUni(Integer idUni) {
		this.idUni = idUni;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	@OneToOne
	private Malla malla;
}
