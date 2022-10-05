package ec1.adrian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec1.adrian.dao.Malla;

@Repository
public interface MallaRepo extends JpaRepository<Malla, Integer>{

}
