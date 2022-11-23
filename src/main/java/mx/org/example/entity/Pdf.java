package mx.org.example.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;




@Entity
@Table( name = "TC_PDF", schema = "dbo", catalog = "sarcDB" )
@JsonInclude()
public class Pdf implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String RESOURCES_FOLDER = "resources";
	public static final String FILES_FOLDER = "files";
	
	@Id
	@Column( name = "ID_PDF", unique = true, nullable = false )
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPdf;
	
	@Column( name = "NOMBRE_PDF", nullable = false, length = 100 )
	private String nombrePdf;
	
	@Column( name = "URL_PDF", nullable = false, length = 100 )
	private String urlPdf;
	
	@Column( name = "FECHA_CREACION", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
	private String fechaCreacion = LocalDateTime.now().toString();

	@Column( name = "ACTIVO", nullable = false, columnDefinition="DEFAULT 1" )
	private Boolean activo = true;
	
	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private MultipartFile file;
	
	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String formatedUrl;

	
	public Pdf(Long idPdf, String nombrePdf, String urlPdf, String fechaCreacion, Boolean activo) {
		super();
		this.idPdf = idPdf;
		this.nombrePdf = nombrePdf;
		this.urlPdf = urlPdf;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
		
	}
	
	public Pdf(String nombrePdf, MultipartFile file) {
		super();
		this.nombrePdf = nombrePdf;
		this.file = file;
	}
	
	public Pdf() {
		super();
	}
	
	public void createUrl() {
		this.formatedUrl = String.join("/", RESOURCES_FOLDER, FILES_FOLDER, this.urlPdf);
	}
	
	public String getFormatedUrl() {
		return this.formatedUrl;
	}

	public Long getIdPdf() {
		return idPdf;
	}

	public void setIdPdf(Long idPdf) {
		this.idPdf = idPdf;
	}

	public String getNombrePdf() {
		return nombrePdf;
	}

	public void setNombrePdf(String nombrePdf) {
		this.nombrePdf = nombrePdf;
	}

	public String getUrlPdf() {
		return urlPdf;
	}

	public void setUrlPdf(String urlPdf) {
		this.urlPdf = urlPdf;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}


	@Override
	public String toString() {
		return "PDFModel [idPdf=" + idPdf + ", nombrePdf=" + nombrePdf + ", urlPdf=" + urlPdf + ", fechaCreacion="
				+ fechaCreacion + ", activo=" + activo + "]";
	}

}
