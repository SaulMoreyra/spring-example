package mx.org.coneval.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import mx.org.coneval.entity.keys.RolModuloKey;

@Entity
@Table( name = "TC_MODULO_ROL", schema = "dbo", catalog = "sarcDB" )
public class RolModulo implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    RolModuloKey rolModuloKey;
    
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_MODULO", nullable = false, insertable=false, updatable=false)
    private Modulo modulo;
    
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_ROL", nullable = false, insertable=false, updatable=false)
    private Rol rol;
    
    @Column( name = "ACTIVO", nullable = false, columnDefinition="DEFAULT 1" )
	private Boolean activo = true;

	public RolModulo(RolModuloKey rolModuloKey, Modulo modulo, Rol rol, Boolean activo) {
		super();
		this.rolModuloKey = rolModuloKey;
		this.modulo = modulo;
		this.rol = rol;
		this.activo = activo;
	}
	
	public RolModulo() {}

	public RolModuloKey getRolModuloKey() {
		return rolModuloKey;
	}

	public void setRolModuloKey(RolModuloKey rolModuloKey) {
		this.rolModuloKey = rolModuloKey;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "RolModulo [rolModuloKey=" + rolModuloKey + ", modulo=" + modulo + ", rol=" + rol + ", activo=" + activo + "]";
	}
	
	
}
