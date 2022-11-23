package mx.org.example.entity.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RolModuloKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ID_MODULO")
	private Long idModulo;
	
	@Column(name="ID_ROL")
	private Long idRol;

	public RolModuloKey() {}
	
	public RolModuloKey(Long idModulo, Long idRol) {
		super();
		this.idModulo = idModulo;
		this.idRol = idRol;
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	
	
}
