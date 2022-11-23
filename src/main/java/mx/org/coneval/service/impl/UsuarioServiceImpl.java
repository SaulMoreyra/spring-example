package mx.org.coneval.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.coneval.dao.UsuarioDao;
import mx.org.coneval.entity.Usuario;
import mx.org.coneval.pojos.Sha256;
import mx.org.coneval.service.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	@Transactional
	public Map<String, Object> paginate(Integer page, Integer limit, String search) {
		return usuarioDao.paginate(page, limit, search);
	}

	@Override
	@Transactional
	public List<Usuario> getAll() {
		return usuarioDao.getAll();
	}

	@Override
	@Transactional
	public Usuario findById(Long idUsuario) {
		return usuarioDao.findById(idUsuario);
	}

	@Override
	@Transactional
	public Usuario findByEmail(String nombre) {
		return usuarioDao.findByEmail(nombre);
	}

	@Override
	@Transactional
	public Usuario create(Usuario usuario) {
		String encryptedPassword = Sha256.encrytp(usuario.getPassword().getBytes());
		usuario.setPassword(encryptedPassword);
		return usuarioDao.create(usuario);
	}

	@Override
	@Transactional
	public Usuario update(Usuario usuario) {
		return usuarioDao.update(usuario);
	}

	@Override
	@Transactional
	public Usuario delete(Long idUsuario) {
		return usuarioDao.delete(idUsuario);
	}

	@Override
	@Transactional
	public boolean exists(Long idUsuario) {
		return usuarioDao.exists(idUsuario);
	}	
	
	@Override
	@Transactional
	public boolean login (String email, String password) {
		Usuario usuario = usuarioDao.findByEmail(email);
		String encryptedPassword = Sha256.encrytp(password.getBytes());
		return usuario.getPassword().equals(encryptedPassword);
	}
		
}
