package ec1.adrian.services;

import java.util.List;

import ec1.adrian.dao.Universidad;

public interface UniversidadService {
	void save(Universidad x);
	void update(Universidad x);
	void delete(Integer id);
	Universidad findbyid(Integer id);
	List<Universidad> findall();
}
