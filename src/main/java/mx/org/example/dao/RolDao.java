package mx.org.example.dao;

import java.util.List;
import java.util.Map;

import mx.org.example.entity.Rol;

public interface RolDao {
	public Map<String, Object> paginate(Integer page, Integer limit, String search);
	public List<Rol> getAll();
	public Rol findById(Long idRol);
	public Rol findByName(String nombre);
	public Rol create(Rol rol);
	public Rol update(Rol rol);
	public Rol delete(Long idRol);
	public boolean exists(Long idRol);
}
