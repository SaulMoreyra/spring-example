package mx.org.example.models;

import java.time.LocalDate;

public class PdfModel {
	private Long id;
	private String nombre;
	private String url;
	private LocalDate fechaCreacion;

	public PdfModel(Long id, String nombre, String url, LocalDate fechaCreacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.url = url;
		this.fechaCreacion = fechaCreacion;
	}

	public PdfModel(String nombre, String url, LocalDate fechaCreacion) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.fechaCreacion = fechaCreacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "PDFModel [" + "id=" + id + ", " + "nombre=" + nombre + ", " + "url=" + url + ", " + "fechaCreacion="
				+ fechaCreacion + "]";
	}

}
