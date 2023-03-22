package nl.topicus.topiconfbackend.rest;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import nl.topicus.topiconfbackend.domain.Evenement;
import nl.topicus.topiconfbackend.domain.security.User;
import nl.topicus.topiconfbackend.persistence.EvenementService;
import nl.topicus.topiconfbackend.persistence.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import nl.topicus.topiconfbackend.domain.Persoon;
import nl.topicus.topiconfbackend.persistence.PersoonService;


@RestController
public class PersoonEndpoint {

	@Autowired
	EvenementService evenementService;

	@Autowired
	PersoonService persoonService;

	@Autowired
	UserService userService;
	
	//add request to database
	//fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("persoon/slaPersoonOp")
	public void slaPersoonOp(@RequestBody Persoon persoon) {
		persoonService.slaPersoonOp(persoon);
	}
	
	@GetMapping("persoon/geefAllePersonen")
	public Iterable<Persoon> geefAllePersonen() {
		return persoonService.geefAllePersonen();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("persoon/updatePersoon/{id}")
	public void updatePersoon(@PathVariable long id, @RequestBody Persoon persoon) {
		persoonService.slaPersoonOp(persoon);
	}

	@CrossOrigin
	@GetMapping("persoon/geefPersoonPerId/{id}")
	public Persoon geefPersoonPerId(@PathVariable long id){
		return persoonService.findById(id);
	}

	@GetMapping("persoon/geefEvenementenPerPersoon/{persoonid}")
	public List<Evenement> geefEvenementenPerPersoon(@PathVariable("persoonid") int persoonid){
		Persoon huidigPersoon = persoonService.findById(persoonid);
		return huidigPersoon.getEvenementenLijst();
	}

	@PostMapping("/user/checkUserCredentials")
	public boolean checkUserCredentials(@RequestBody User user){
		User currentUser = userService.findByUsername(user.getUsername());
		if(BCrypt.checkpw(user.getInput(), currentUser.getPassword())){
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("user/createNewUser")
	public String createNewUser(@RequestBody User user){
		User newUser = new User();
		String randomPassword = generateRandomPassword(8);
		String hashedPW = BCrypt.hashpw(randomPassword, BCrypt.gensalt());
		newUser.setPassword(hashedPW);
		newUser.setUsername(user.getUsername());
		userService.saveUser(newUser);
		return randomPassword;
	}

	public String generateRandomPassword(int lengte){
		String randomPassword = "";
		for(int i = 0; i < lengte; i++){
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			randomPassword += c;
		}
		return randomPassword;
	}
}