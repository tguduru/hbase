package org.bigtech.hbase.rest;

/**
 * REST Application which bootstraps REST resources
 * @author Thirupathi Reddy Guduru
 * @date May 20, 2015
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);

		System.out.println("*****  REST App Started  ******");

	}

}
