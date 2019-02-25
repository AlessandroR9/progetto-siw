package it.uniroma3;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.model.Utente;
import it.uniroma3.service.AllievoService;
import it.uniroma3.service.UserService;

@SpringBootApplication
public class ProgettoSiwAvanzatoApplication {
	
	@Autowired
	private UserService userService;
	private AllievoService allievoService;

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSiwAvanzatoApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		Utente utente = new Utente("admin","password","RESPONSABILE");
		userService.save(utente);
	}
}
