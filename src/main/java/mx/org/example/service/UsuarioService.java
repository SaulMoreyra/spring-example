package mx.org.example.service;

import java.util.List;
import java.util.Map;

import mx.org.example.entity.Usuario;

public interface UsuarioService {
	public Map<String, Object> paginate(Integer page, Integer limit, String search);
	public List<Usuario> getAll();
	public Usuario findById(Long idUsuario);
	public Usuario findByEmail(String email);
	public Usuario create(Usuario usuario);
	public Usuario update(Usuario usuario);
	public Usuario delete(Long idUsuario);
	public boolean exists(Long idUsuario);
	public boolean login(String email, String password);
}
