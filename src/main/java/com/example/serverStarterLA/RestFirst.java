package com.example.serverStarterLA;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * La classe RestFirst è un esempio base di utilizzo di request mapping
 * 
 * @author Jacopo Favaro
 *
 */
@RestController
public class RestFirst {
	@RequestMapping("")
	String hello() {
		return "Hello World, LiftApp here!";
	}
	

}