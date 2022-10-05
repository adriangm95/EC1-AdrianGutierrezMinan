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

import ec1.adrian.dao.Curso;
import ec1.adrian.services.CursoService;


@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> get() {
		return new ResponseEntity<List<Curso>>(service.findall(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Curso> findbyid(@PathVariable Integer id) {	
		Curso curso = service.findbyid(id);
		if (curso!=null) {
			return new ResponseEntity<Curso>(curso,HttpStatus.OK);
		}else {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Curso> create(@RequestBody Curso c) {
		service.save(c);	
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<?> update(@RequestBody Curso p, @PathVariable Integer id) {
		 Curso curso= service.findbyid(id);
		if (curso!=null) {
			p.setIdCurso(id);
			service.update(p);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
			
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		Curso curso= service.findbyid(id);
		if (curso!=null) {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
