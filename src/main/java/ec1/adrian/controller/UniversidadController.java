package ec1.adrian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec1.adrian.dao.Profesor;
import ec1.adrian.dao.Universidad;
import ec1.adrian.services.UniversidadService;

@RestController
@RequestMapping("/uni")
public class UniversidadController {
	@Autowired
	private UniversidadService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Universidad>> get() {
		return new ResponseEntity<List<Universidad>>(service.findall(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Universidad> findbyid(@PathVariable Integer id) {	
		Universidad p = service.findbyid(id);
		if (p!=null) {
			return new ResponseEntity<Universidad>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Profesor> create(@RequestBody Universidad c) {
		service.save(c);	
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<?> update(@RequestBody Universidad p, @PathVariable Integer id) {
		Universidad curso= service.findbyid(id);
		if (curso!=null) {
			p.setIdUni(id);
			service.update(p);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
			
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		Universidad curso= service.findbyid(id);
		if (curso!=null) {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
