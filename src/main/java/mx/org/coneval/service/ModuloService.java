package mx.org.coneval.service;

import java.util.List;
import java.util.Map;

import mx.org.coneval.entity.Modulo;

public interface ModuloService {
	public Map<String, Object> paginate(Integer page, Integer limit, String search);
	public List<Modulo> getAll();
	public Modulo findById(Long idModulo);
	public Modulo findByName(String nombre);
	public Modulo create(Modulo modulo);
	public Modulo update(Modulo modulo);
	public Modulo delete(Long idModulo);
	public boolean exists(Long idModulo);
}
