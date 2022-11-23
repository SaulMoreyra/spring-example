package mx.org.example.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table( name = "TC_MODULO", schema = "dbo", catalog = "sarcDB" )
@JsonInclude()
public class Modulo  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID_MODULO", unique = true, nullable = false )
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idModulo;
	
	@Column( name = "NOMBRE_MODULO", nullable = false, length = 40 )
	private String nombreModulo;
	
	@Column( name = "ACTIVO", nullable = false, columnDefinition="DEFAULT 1" )
	private Boolean activo = true;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "modulo" )
    private Set<RolModulo> activos = new HashSet<>();
   
	public Modulo(Long idModulo, String nombreModulo, Boolean activo, Set<RolModulo> activos) {
		super();
		this.idModulo = idModulo;
		this.nombreModulo = nombreModulo;
		this.activo = activo;
		this.activos = activos;
	}
	
	public Modulo(Long idModulo, String nombreModulo, Boolean activo) {
		super();
		this.idModulo = idModulo;
		this.nombreModulo = nombreModulo;
		this.activo = activo;
	}

	public Modulo(String nombreModulo, Boolean activo) {
		super();
		this.nombreModulo = nombreModulo;
		this.activo = activo;
	}

	public Modulo() {
		super();
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombreModulo() {
		return nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	public Set<RolModulo> getActivos() {
		return activos;
	}

	public void setActivos(Set<RolModulo> activos) {
		this.activos = activos;
	}

	@Override
	public String toString() {
		return "Modulo [idModulo=" + idModulo + ", nombreModulo=" + nombreModulo + ", activo=" + activo + ", activos="
				+ activos + "]";
	}
	
	
}
