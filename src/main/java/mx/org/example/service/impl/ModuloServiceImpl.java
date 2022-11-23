package mx.org.example.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.example.dao.ModuloDao;
import mx.org.example.entity.Modulo;
import mx.org.example.service.ModuloService;

@Service
@Transactional
public class ModuloServiceImpl implements ModuloService{
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private ModuloDao moduloDao;

	@Override
	public Map<String, Object> paginate(Integer page, Integer limit, String search) {
		return moduloDao.paginate(page, limit, search);
	}

	@Override
	public List<Modulo> getAll() {
		return moduloDao.getAll();
	}

	@Override
	public Modulo findById(Long idModulo) {
		return moduloDao.findById(idModulo);
	}

	@Override
	public Modulo findByName(String nombre) {
		return moduloDao.findByName(nombre);
	}

	@Override
	public Modulo create(Modulo modulo) {
		return moduloDao.create(modulo);
	}

	@Override
	public Modulo update(Modulo modulo) {
		return moduloDao.update(modulo);
	}

	@Override
	public Modulo delete(Long idModulo) {
		return moduloDao.delete(idModulo);
	}

	@Override
	public boolean exists(Long idModulo) {
		return moduloDao.exists(idModulo);
	}

}
