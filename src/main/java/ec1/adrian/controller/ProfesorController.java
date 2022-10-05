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
import ec1.adrian.services.ProfesorService;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
	@Autowired
	private ProfesorService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> get() {
		return new ResponseEntity<List<Profesor>>(service.findall(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Profesor> findbyid(@PathVariable Integer id) {	
		Profesor p = service.findbyid(id);
		if (p!=null) {
			return new ResponseEntity<Profesor>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Profesor> create(@RequestBody Profesor c) {
		service.save(c);	
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<?> update(@RequestBody Profesor p, @PathVariable Integer id) {
		Profesor curso= service.findbyid(id);
		if (curso!=null) {
			p.setIdProfesor(id);
			service.update(p);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
			
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		Profesor curso= service.findbyid(id);
		if (curso!=null) {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
