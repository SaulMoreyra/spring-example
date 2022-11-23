package mx.org.coneval.service.impl;

import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.coneval.dao.RolDao;
import mx.org.coneval.entity.Rol;
import mx.org.coneval.service.RolService;

@Service
@Transactional
public class RolServiceImpl implements RolService{
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private RolDao rolDao;

	@Override
	@Transactional
	public Map<String, Object> paginate(Integer page, Integer limit, String search) {
		return rolDao.paginate(page, limit, search);
	}

	@Override
	@Transactional
	public List<Rol> getAll() {
		return rolDao.getAll();
	}

	@Override
	@Transactional
	public Rol findById(Long idRol) {
		return rolDao.findById(idRol);
	}

	@Override
	@Transactional
	public Rol findByName(String nombre) {
		return rolDao.findByName(nombre);
	}

	@Override
	@Transactional
	public Rol create(Rol rol) {
		return rolDao.create(rol);
	}

	@Override
	@Transactional
	public Rol update(Rol rol) {
		return rolDao.update(rol);
	}

	@Override
	@Transactional
	public Rol delete(Long idRol) {
		return rolDao.delete(idRol);
	}

	@Override
	@Transactional
	public boolean exists(Long idRol) {
		return rolDao.exists(idRol);
	}
}
