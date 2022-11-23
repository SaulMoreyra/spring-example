package mx.org.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.org.example.entity.Usuario;
import mx.org.example.errors.ApiRequestException;
import mx.org.example.service.UsuarioService;
import mx.org.example.dto.UsuarioDto;

@Controller
public class ModuloRolApi {
	public static final String NOT_FOUND_MSG = "El identificador no existe";
	public static final String SERVER_ERROR_MSG = "Ha ocurrido un error";
	public static final String UNAUTHORIZED_MSG = "Error de credenciales";

	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(
			value = "/api/usuario", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<Usuario>> getModulos() {
		try {
		    List<Usuario> usuarioFinded = usuarioService.getAll();
		    return new ResponseEntity<List<Usuario>>(usuarioFinded, HttpStatus.OK);
		} catch (ApiRequestException e){
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(
			value = "/api/usuario/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
		try {
			Usuario usuarioFinded = usuarioService.findById(id);
			if(usuarioFinded == null) {
				throw new ApiRequestException(NOT_FOUND_MSG, HttpStatus.NOT_FOUND);
			}
		    return new ResponseEntity<>(usuarioFinded, HttpStatus.OK);
		} catch (ApiRequestException e){
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(
			value = "/api/usuario", 
			method = RequestMethod.POST, 
			consumes= { MediaType.MULTIPART_FORM_DATA_VALUE },
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Usuario> createUsuario(UsuarioDto usuarioDto) {
		try {
			Usuario usuarioSaved = usuarioService.create(new Usuario(usuarioDto));
		    return new ResponseEntity<>(usuarioSaved, HttpStatus.CREATED);
		} catch (ApiRequestException e){
			throw e;
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(
			value = "/api/usuario/login", 
			method = RequestMethod.POST, 
			consumes= { MediaType.MULTIPART_FORM_DATA_VALUE },
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Usuario> loginUser(UsuarioDto usuarioDto) {
		try {
			boolean isUserLogged = usuarioService.login(usuarioDto.getCorreo(), usuarioDto.getPassword());
			if(isUserLogged) {
				Usuario usuarioFinded = usuarioService.findByEmail(usuarioDto.getCorreo());
				return new ResponseEntity<>(usuarioFinded, HttpStatus.CREATED);
			}
			throw new ApiRequestException(UNAUTHORIZED_MSG, HttpStatus.UNAUTHORIZED);
		} catch (ApiRequestException e){
			throw e;
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
