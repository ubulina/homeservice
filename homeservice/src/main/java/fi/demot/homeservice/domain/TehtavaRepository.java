package fi.demot.homeservice.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TehtavaRepository extends CrudRepository <Tehtava, Long> {
	
	List<Tehtava> findByName(String name);
	

}
