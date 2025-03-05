package webservices;

import java.util.List;

import org.apache.cxf.frontend.ServerFactoryBean;

public class MovieServer {
	
	public static void main(String[] args) {
		ServerFactoryBean server = new ServerFactoryBean();
		server.setAddress("http://localhost:7777/MovieService");
		
		MovieServiceImpl impl = new MovieServiceImpl();
		impl.addMovie(new Movie(1, "Topgun", "English", "Action", List.of("Tom Cruise","Jennifer Conley")));
		impl.addMovie(new Movie(2, "De Dhana Dhan", "Hindi", "Comedy", List.of("Akshay Kumar","Sunil Shetty","Katrina Caif")));
		impl.addMovie(new Movie(3, "3 Idiots", "Hindi", "Comedy", List.of("Aamir Khan","Kareena Kapoor","Madhavan")));
		impl.addMovie(new Movie(4, "Alaipaydhey", "Tamil", "Drama", List.of("Madhavan","Shalini")));
		impl.addMovie(new Movie(5, "Nayagan", "Tamil", "Drama", List.of("Kamalahasan","Sharanya")));
		
		server.setServiceBean(impl);
		server.setServiceClass(MovieService.class);
		server.create();
		System.out.println("Movie Service Running... .... .....");
	}

}
