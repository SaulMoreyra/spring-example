package mx.org.coneval.dto;

public class UsuarioDto {
	private String nickName;
	private String nombre;
	private String apellidoPaterno;
	private String correo;
	private String password;
	private Long idRol;
	private Boolean activo;
	
	public UsuarioDto() {}
	
	public UsuarioDto(String nickName, String nombre, String apellidoPaterno, String correo, String password,
			Long idRol, Boolean activo) {
		super();
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.correo = correo;
		this.password = password;
		this.idRol = idRol;
		this.activo = activo;
	}
	
	public UsuarioDto(String nickName, String nombre, String apellidoPaterno, String correo, String password,
			Long idRol) {
		super();
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.correo = correo;
		this.password = password;
		this.idRol = idRol;
	}
	
	public UsuarioDto (String correo, String password) {
		this.correo = correo;
		this.password = password;
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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "UsuarioDto [nickName=" + nickName + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", correo=" + correo + ", password=" + password + ", idRol=" + idRol + "]";
	}
	
	
}
