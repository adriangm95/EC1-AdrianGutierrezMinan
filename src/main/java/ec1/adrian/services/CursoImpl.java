package ec1.adrian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.adrian.dao.Curso;
import ec1.adrian.repository.CursoRepo;

@Service
public class CursoImpl implements CursoService {

	@Autowired
	private CursoRepo r;
	
	@Override
	public void save(Curso x) {
		r.save(x);
	}

	@Override
	public void update(Curso x) {
		r.saveAndFlush(x);
	}

	@Override
	public void delete(Integer id) {
		r.deleteById(id);
	}

	@Override
	public Curso findbyid(Integer id) {
		return r.findById(id).orElse(null);
	}

	@Override
	public List<Curso> findall() {
		return r.findAll();
	}

}
