package com.valtech.training.jaxwsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaxws.HelloWorld;
import com.valtech.training.jaxws.Movie;
import com.valtech.training.jaxws.webservices.MovieServiceWS;

@SpringBootTest
class JaxwsclientApplicationTests {
	
	@Autowired
	private HelloWorld helloWorld;
	
	@Autowired
	private MovieServiceWS movieServices;

	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello("Rushabh"));
//		movieServices.createMovie(new Movie("Welcome","Comedy", "Hindi", List.of("Akshay Kumar","Nana Patekar")));
//		movieServices.createMovie(new Movie("Yeh Jawani Hai Divani","Comedy", "Hindi", List.of("Ranvir Kapoor","Dipika Padukon")));
		movieServices.getAllMovies().forEach(m -> System.out.println(m));
//		System.out.println(movieServices.getAllMovies());
	}

}
