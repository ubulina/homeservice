package fi.demot.homeservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.demot.homeservice.domain.Henkilo;
import fi.demot.homeservice.domain.HenkiloRepository;
import fi.demot.homeservice.domain.TehtavaRepository;

@Controller
public class HenkiloController {
	
	//tuodaan repositoriot ja metodit controllerin käyttöön
	@Autowired
	private HenkiloRepository repository;
	@Autowired
	private TehtavaRepository tehtavarepository;
	
	
	@RequestMapping(value = {"/", "/kotipalvelu"})
	public String henkilolist(Model model) {
		
		model.addAttribute("henkilot", repository.findAll());
				
		return "henkilolist";
	}
	
	@RequestMapping(value = "/add")
	public String addHenkilo(Model model) {
		
		model.addAttribute("henkilo", new Henkilo());
		model.addAttribute("tehtavat", tehtavarepository.findAll());
		
		return "addhenkilo";
	}
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String saveHenkilo(Henkilo henkilo) {
		
		repository.save(henkilo);
		return "redirect:kotipalvelu";
		
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteHenkilo(@PathVariable("id") Long id, Model model) {
		
		repository.deleteById(id);
		
		return "redirect:../kotipalvelu";
		
		
	}
	
	@RequestMapping (value = "edit/{id}", method = RequestMethod.GET)
	public String editHenkilo (@PathVariable("id") Long id, Model model)  {
		
		model.addAttribute("edithlo", repository.findById(id));
		model.addAttribute("tehtavat", tehtavarepository.findAll());
		
		
		return "edithenkilo";
	}
	

}
