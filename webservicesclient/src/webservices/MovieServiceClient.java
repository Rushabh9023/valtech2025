package webservices;

import java.util.List;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class MovieServiceClient {

	public static void main(String[] args) {
		
		ClientProxyFactoryBean client = new ClientProxyFactoryBean();
		client.setAddress("http://localhost:7777/MovieService");
		MovieService ms = client.create(MovieService.class);
		ms.getAllMovies().forEach(m -> System.out.println(m));
		System.out.println("******************************************");
//		System.out.println(ms.getAllMovies());
		System.out.println(ms.getMovie(1));
		System.out.println(ms.getMovie(4));
		ms.addMovie(new Movie(6, "Day and Knight", "English", "Action", List.of("Tom Cruise")));
		System.out.println("******************************************");
		ms.getAllMovies().forEach(m -> System.out.println(m));
//		System.out.println(ms.getAllMovies());

	}

}
