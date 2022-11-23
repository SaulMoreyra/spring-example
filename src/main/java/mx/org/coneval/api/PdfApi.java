package mx.org.coneval.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import mx.org.coneval.entity.Pdf;
import mx.org.coneval.errors.ApiRequestException;
import mx.org.coneval.service.PdfService;



@Controller
public class PdfApi {
	public static final String NOT_FOUND_MSG = "El identificador no existe";
	public static final String SERVER_ERROR_MSG = "Ha ocurrido un error";
	
	@Autowired
	PdfService pdfService;
	
	@RequestMapping(
			value = "/api/pdfs/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Pdf> getPdf(@PathVariable Long id) {
		try {
			boolean existsId = pdfService.exists(id);
			if(!existsId) {
				throw new ApiRequestException(NOT_FOUND_MSG, HttpStatus.NOT_FOUND);
			}
		    Pdf pdfFinded = pdfService.findById(id);
		    return new ResponseEntity<>(pdfFinded, HttpStatus.OK);
		} catch (ApiRequestException e){
			throw e;
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(
			value = "/api/pdfs/{id}", 
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Pdf> deletePdf(@PathVariable Long id)  {
		try {
			boolean existsId = pdfService.exists(id);
			if(!existsId) {
				throw new ApiRequestException(NOT_FOUND_MSG, HttpStatus.NOT_FOUND);
			}
		    Pdf pdfDeleted = pdfService.delete(id);
		    return new ResponseEntity<>(pdfDeleted, HttpStatus.OK);
		} catch (ApiRequestException e){
			throw e;
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(
			value = "/api/pdfs", 
			method = RequestMethod.POST, 
			consumes= { MediaType.MULTIPART_FORM_DATA_VALUE },
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Pdf> createPdf(
			@RequestParam(value = "file", required=true) MultipartFile file, 
			@RequestParam(value = "nombrePdf", required=true) String nombrePdf) 
	{
		try {
			Pdf pdf = new Pdf();
			pdf.setFile(file);
			pdf.setNombrePdf(nombrePdf);
			
			Pdf pdfSaved = pdfService.create(pdf);
		    return new ResponseEntity<>(pdfSaved, HttpStatus.CREATED);
		} catch (ApiRequestException e){
			throw e;
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(
			value = "/api/pdfs/{id}", 
			method = RequestMethod.POST, 
			consumes= { MediaType.MULTIPART_FORM_DATA_VALUE },
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Pdf> updatePdf(
			@PathVariable Long id, 
			@RequestParam(value = "file", required=false) MultipartFile file, 
			@RequestParam(value = "nombrePdf", required=false) String nombrePdf,
			@RequestParam(value = "activo", required=false, defaultValue="true") boolean activo
		)
	{
		try {
						
			Pdf pdfFound = pdfService.findById(id);
			if(pdfFound == null) throw new ApiRequestException(NOT_FOUND_MSG, HttpStatus.NOT_FOUND);
			
			if(file != null) pdfFound.setFile(file);
			if(nombrePdf != null) pdfFound.setNombrePdf(nombrePdf);
			pdfFound.setActivo(activo);
			
		    Pdf pdfUpdated = pdfService.update(pdfFound);
		    
		    return new ResponseEntity<>(pdfUpdated, HttpStatus.OK);
		} catch (ApiRequestException e){
			throw e;
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
