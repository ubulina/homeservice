package fi.demot.homeservice.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tehtava {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tehtavaId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tehtava")
	private List<Henkilo> henkilot;
	
	//id luodaan automaattisesti eikä sitä tarvitse olla konstruktorissa
	public Tehtava(String name) {
		
		super();
		this.name = name;
	}
	
	public Tehtava() {
		super();
	}

	public Long getTehtavaId() {
		return tehtavaId;
	}

	public void setTehtavaId(Long tehtavaId) {
		this.tehtavaId = tehtavaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tehtava [tehtavaId=" + tehtavaId + ", name=" + name + "]";
	}
	
	

}
