package sn.ut.set.Controleurs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.ut.set.modeles.RendezVous;
import sn.ut.set.services.ServiceRendezVous;

@RestController
@RequestMapping("/api")
public class RendezVousControleur {
	ServiceRendezVous serviceRendezVous;
	//@GetMapping(value= {"/","/getrvs"})
	
	
	@GetMapping("/")
	public String index() {
		return "Bienvenue sur mon back-end";
	}
	public RendezVousControleur(ServiceRendezVous serviceRendezVous) {
		 this. serviceRendezVous=serviceRendezVous;
	}
	@GetMapping("/getrvs")
	public ResponseEntity<List<RendezVous>>getAllRvs(){
		List<RendezVous> rvs=serviceRendezVous.getAllRV();
		return new ResponseEntity<List<RendezVous>>(rvs,HttpStatus.OK);
	}
	@GetMapping("/chercher/{id}")
	public ResponseEntity<RendezVous>chercherRV(@PathVariable("id") Long id){
   RendezVous rvs=serviceRendezVous.trouverRendezById(id);
		return new ResponseEntity<RendezVous>(rvs,HttpStatus.OK);
	}
	@GetMapping("/supprimer/{id}")
	public void supprimer(@PathVariable("id") Long id){
              serviceRendezVous.supprimerById(id);
		
	}
	@PutMapping("/update")
	public ResponseEntity<RendezVous>update(@RequestBody RendezVous rv){
              RendezVous newRv=serviceRendezVous.updateRV(rv);
              return new ResponseEntity<RendezVous>(rv,HttpStatus.OK);
	}
	@PostMapping("/ajouter")
	public ResponseEntity<RendezVous>ajouterRV(@RequestBody RendezVous rv){
              RendezVous newRv=serviceRendezVous. AjouterRV(rv);
              return new ResponseEntity<RendezVous>(rv,HttpStatus.OK);
	}


}
