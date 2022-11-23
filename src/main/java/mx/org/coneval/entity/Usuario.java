package mx.org.coneval.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import mx.org.coneval.dto.UsuarioDto;

@Entity
@Table( name = "TC_USUARIO", schema = "dbo", catalog = "sarcDB" )
@JsonInclude()
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID_USUARIO", unique = true, nullable = false )
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsuario;
	
	@Column( name = "USUARIO_NICK", nullable = false, length = 40 )
	private String nickName;
	
	@Column( name = "NOMBRE", nullable = false, length = 40 )
	private String nombre;
	
	@Column( name = "APELLIDO_PATERNO", nullable = false, length = 40 )
	private String apellidoPaterno;
	
	@Column( name = "CORREO", nullable = false, length = 40 )
	private String correo;
	
	@JsonIgnore
	@Column( name = "PASSWORD", nullable = false, length = 40 )
	private String password;
	
	@Column( name = "ID_ROL", nullable = false )
	private Long idRol;
	
	@Column( name = "ACTIVO", nullable = false, columnDefinition="DEFAULT 1" )
	private Boolean activo = true;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_ROL", nullable = false, insertable=false, updatable=false)
	private Rol rol;

	public Usuario(Long idUsuario, String nickName, String nombre, String apellidoPaterno, String correo,
			String password, Rol rol) {
		super();
		this.idUsuario = idUsuario;
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
	}
	
	public Usuario(String nickName, String nombre, String apellidoPaterno, String correo, String password, Rol rol) {
		super();
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
	}
	
	public Usuario(Long idUsuario, String nickName, String nombre, String apellidoPaterno, String correo,
			String password, Long idRol) {
		super();
		this.idUsuario = idUsuario;
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.correo = correo;
		this.password = password;
		this.idRol = idRol;
	}
	
	public Usuario(String nickName, String nombre, String apellidoPaterno, String correo, String password, Long idRol) {
		super();
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.correo = correo;
		this.password = password;
		this.idRol = idRol;
	}

	public Usuario(UsuarioDto usuario) {
		super();
		this.nickName = usuario.getNickName();
		this.nombre = usuario.getNombre();
		this.apellidoPaterno = usuario.getApellidoPaterno();
		this.correo = usuario.getCorreo();
		this.password = usuario.getPassword();
		this.idRol = usuario.getIdRol() ;
	}
	
	public Usuario() {}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nickName=" + nickName + ", nombre=" + nombre
				+ ", apellidoPaterno=" + apellidoPaterno + ", correo=" + correo + ", password=" + password + ", rol="
				+ rol + "]";
	}
	
	
}
