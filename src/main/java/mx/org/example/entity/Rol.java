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
@Table( name = "TC_ROL", schema = "dbo", catalog = "sarcDB" )
@JsonInclude()
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID_ROL", unique = true, nullable = false )
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idRol;
	
	@Column( name = "NOMBRE_ROL", nullable = false, length = 40 )
	private String nombreRol;
	
	@Column( name = "ACTIVO", nullable = false, columnDefinition="DEFAULT 1" )
	private Boolean activo = true;
	
	@JsonIgnore
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "rol" )
    private Set<RolModulo> modulos;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol" )
    private Set<Usuario> usuarios = new HashSet<>();
		
	public Rol(Long idRol, String nombreRol, Boolean activo, Set<RolModulo> modulos, Set<Usuario> usuarios) {
		super();
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.activo = activo;
		this.modulos = modulos;
		this.usuarios = usuarios;
	}

	public Rol(Long idRol, String nombreRol, Boolean activo) {
		super();
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.activo = activo;
	}

	public Rol(String nombreRol, Boolean activo) {
		super();
		this.nombreRol = nombreRol;
		this.activo = activo;
	}
	
	public Rol() {
		super();
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Set<RolModulo> getModulos() {
		return modulos;
	}

	public void setModulos(Set<RolModulo> modulos) {
		this.modulos = modulos;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", nombreRol=" + nombreRol + ", activo=" + activo + ", modulos=" + modulos
				+ ", usuarios=" + usuarios + "]";
	}	
	
	
}
