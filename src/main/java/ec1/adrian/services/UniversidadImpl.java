package ec1.adrian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.adrian.dao.Universidad;
import ec1.adrian.repository.UniversidadRepo;
@Service
public class UniversidadImpl implements UniversidadService {

	@Autowired
	private UniversidadRepo r;
	
	@Override
	public void save(Universidad x) {
		r.save(x);

	}

	@Override
	public void update(Universidad x) {
		r.saveAndFlush(x);

	}

	@Override
	public void delete(Integer id) {
		r.deleteById(id);

	}

	@Override
	public Universidad findbyid(Integer id) {
		return r.findById(id).orElse(null);

	}

	@Override
	public List<Universidad> findall() {
		return r.findAll();

	}

}
