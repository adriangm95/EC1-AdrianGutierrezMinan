package ec1.adrian.services;

import java.util.List;

import ec1.adrian.dao.Curso;


public interface CursoService {
	void save(Curso x);
	void update(Curso x);
	void delete(Integer id);
	Curso findbyid(Integer id);
	List<Curso> findall();
}
