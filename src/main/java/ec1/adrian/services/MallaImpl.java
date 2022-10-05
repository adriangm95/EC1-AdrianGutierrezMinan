package ec1.adrian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.adrian.dao.Malla;
import ec1.adrian.repository.MallaRepo;

@Service
public class MallaImpl implements MallaSercive {

	@Autowired
	private MallaRepo r;
	
	@Override
	public void save(Malla x) {
		r.save(x);

	}

	@Override
	public void update(Malla x) {
		r.saveAndFlush(x);

	}

	@Override
	public void delete(Integer id) {
		r.deleteById(id);

	}

	@Override
	public Malla findbyid(Integer id) {
		return r.findById(id).orElse(null);

	}

	@Override
	public List<Malla> findall() {
		return r.findAll();

	}

}
