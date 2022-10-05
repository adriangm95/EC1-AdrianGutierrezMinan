package ec1.adrian.services;

import java.util.List;

import ec1.adrian.dao.Malla;

public interface MallaSercive {
	void save(Malla x);
	void update(Malla x);
	void delete(Integer id);
	Malla findbyid(Integer id);
	List<Malla> findall();
}
