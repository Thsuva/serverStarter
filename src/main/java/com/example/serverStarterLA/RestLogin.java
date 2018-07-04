package com.example.serverStarterLA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverStarterLA.POJO.Supervisore;
import com.example.serverStarterLA.POJO.supervisoreRepository;

/**
 * La classe RestLogin raccoglie le funzioni relative alle query da eseguire per il login della app
 * 
 * @author Jacopo Favaro
 *
 */
@RestController
public class RestLogin {

	@Autowired
	supervisoreRepository sr;

	/**
	 * Verifica le credenziali inserite dal supervisore per effettuare il login
	 * 
	 * @param username
	 * @param password
	 * @return oggetto supervisore
	 */
	@RequestMapping("/doLogin")
	Supervisore checkUserLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		List<Supervisore> supervisore =  sr.findByMatricola(username);
		if(!supervisore.isEmpty() && supervisore.get(0).getPassword().equals(password)) {
			
			return supervisore.get(0);
			
		}else {
			return null;
		}
	}
	

}