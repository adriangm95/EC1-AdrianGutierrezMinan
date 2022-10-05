package ec1.adrian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.adrian.dao.Profesor;
import ec1.adrian.repository.ProfesorRepo;

@Service
public class ProfesorImpl implements ProfesorService {

	@Autowired
	private ProfesorRepo r;
	
	@Override
	public void save(Profesor x) {
		r.save(x);

	}

	@Override
	public void update(Profesor x) {
		r.saveAndFlush(x);

	}

	@Override
	public void delete(Integer id) {
		r.deleteById(id);

	}

	@Override
	public Profesor findbyid(Integer id) {
		return r.findById(id).orElse(null);

	}

	@Override
	public List<Profesor> findall() {
		return r.findAll();

	}

}
