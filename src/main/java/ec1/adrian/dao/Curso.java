package ec1.adrian.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	private String curso;
	private String descripcion;
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@ManyToOne
	@JoinColumn(
			name="id_malla",
			nullable = false,
			unique = true,
			foreignKey =  @ForeignKey(foreignKeyDefinition ="foreign key(id_malla) references malla(id_malla)" )
			)
	private Malla malla;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name="cursoprofesor",
			joinColumns=@JoinColumn(
					name="id_curso",
					nullable = false,
					unique = true,
					foreignKey =  @ForeignKey(foreignKeyDefinition ="foreign key(id_curso) references curso(id_curso)" )),
		    inverseJoinColumns= @JoinColumn(
		    		name="id_profesor",
					nullable = false,
					unique = true,
					foreignKey =  @ForeignKey(foreignKeyDefinition ="foreign key(id_profesor) references profesor(id_profesor)" ))
	)
	private List<Profesor> profes= new ArrayList<>();
}
