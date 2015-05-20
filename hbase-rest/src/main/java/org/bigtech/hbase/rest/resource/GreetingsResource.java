package org.bigtech.hbase.rest.resource;

/**
 * A simple greetings resource for demo
 * @author Thirupathi Reddy Guduru
 * @date May 20, 2015
 */
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GreetingsResource {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
