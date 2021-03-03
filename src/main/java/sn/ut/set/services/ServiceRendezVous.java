package sn.ut.set.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.ut.set.exception.RendezVousException;
import sn.ut.set.modeles.RendezVous;
import sn.ut.set.repos.RendezVousRepo;
@Service
public class ServiceRendezVous {
	private RendezVousRepo rendezVousRepo;
    @Autowired
	public ServiceRendezVous(RendezVousRepo rvrepo) {
		// TODO Auto-generated constructor stub
		rendezVousRepo=rvrepo;
	}
	public RendezVous AjouterRV(RendezVous rv) {
		rv.setCodeRV(UUID.randomUUID().toString());
		return rendezVousRepo.save(rv);
	}
	public List<RendezVous>getAllRV() {
		
		return rendezVousRepo.findAll();
	}
	
  public void supprimerById(Long id) {
	rendezVousRepo.deleteById(id);
		
	}
  public RendezVous trouverRendezById(Long id) {
		return rendezVousRepo.findById(id).orElseThrow(()->new RendezVousException("Un RV avec l'id"+id+"n'existe pas"));
			
	}
  public RendezVous updateRV(RendezVous rv) {
		return rendezVousRepo.save(rv);
			
	}
  
  


}
