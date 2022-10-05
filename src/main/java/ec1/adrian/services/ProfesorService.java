package ec1.adrian.services;

import java.util.List;

import ec1.adrian.dao.Profesor;

public interface ProfesorService {
	void save(Profesor x);
	void update(Profesor x);
	void delete(Integer id);
	Profesor findbyid(Integer id);
	List<Profesor> findall();
}
