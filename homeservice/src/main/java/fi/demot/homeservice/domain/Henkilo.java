package fi.demot.homeservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Henkilo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String etunimi;
	private String sukunimi;
	private String puhelin;
	private String email;
	private int syntymaVuosi;
	private int tuntipalkka;

	@ManyToOne
	@JoinColumn(name = "tehtavaId")
	private Tehtava tehtava;

	// id luodaan automaattisesti eikä sitä laiteta konstruktoriin
	public Henkilo(String etunimi, String sukunimi, String puhelin, String email, int syntymaVuosi, int tuntipalkka) {
		super();

		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhelin = puhelin;
		this.email = email;
		this.syntymaVuosi = syntymaVuosi;
		this.tuntipalkka = tuntipalkka;
	}

	public Henkilo(String etunimi, String sukunimi, String puhelin, String email, int syntymaVuosi, int tuntipalkka,
			Tehtava tehtava) {
		super();

		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhelin = puhelin;
		this.email = email;
		this.syntymaVuosi = syntymaVuosi;
		this.tuntipalkka = tuntipalkka;
		this.tehtava = tehtava;
	}

	public Henkilo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getPuhelin() {
		return puhelin;
	}

	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSyntymaVuosi() {
		return syntymaVuosi;
	}

	public void setSyntymaVuosi(int syntymaVuosi) {
		this.syntymaVuosi = syntymaVuosi;
	}

	public int getTuntipalkka() {
		return tuntipalkka;
	}

	public void setTuntipalkka(int tuntipalkka) {
		this.tuntipalkka = tuntipalkka;
	}

	public Tehtava getTehtava() {
		return tehtava;
	}

	public void setTehtava(Tehtava tehtava) {
		this.tehtava = tehtava;
	}

	@Override
	public String toString() {
		return "Henkilo [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", puhelin=" + puhelin
				+ ", email=" + email + ", syntymaVuosi=" + syntymaVuosi + ", tuntipalkka=" + tuntipalkka + ", tehtava="
				+ tehtava + "]";
	}

}
