package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

//Listeners are used for the Content that is shared among all and only needed once
public class LoadConfigListener implements ServletContextListener {

	 

	    @Override
	    public void contextInitialized(ServletContextEvent sce) {
	        Properties prop = new Properties();
	       
	        ServletContext context = sce.getServletContext();

	        try (InputStream input = context.getResourceAsStream("/WEB-INF/config.properties")) {
	            if (input == null) {
	                throw new RuntimeException("config.properties file not found!");
	            }
	        
//	        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
//	            if (input == null) {
//	                throw new RuntimeException("config.properties file not found!");
//	            }

	            // Load properties
	            prop.load(input);

	            String url = prop.getProperty("url");
	            System.out.println("url:-"+url);
	            String user = prop.getProperty("username");
	            System.out.println("user:-"+user);
	            String password = prop.getProperty("password");
	            String driver = prop.getProperty("driver");
	            System.out.println("Driver:-"+driver);

	            // Load database driver
	            Class.forName(driver);

	            context.setAttribute("url", url);
	            context.setAttribute("username", user);
	            context.setAttribute("password", password);
	          
	            // Create database connection
	            

	          

	        } catch (IOException | ClassNotFoundException ex) {
	            throw new RuntimeException("Database connection failed: " + ex.getMessage(), ex);
	        }
		
		
//		
//		System.out.println("First Piece of code that will be Executed....");
//		System.out.println("Loading...Congig.....Done.....");
//		System.out.println("Creating Database Connection Pools....");
		
//		It only has Access to the ServletContext not req and resp;
//		ServletContext application = sce.getServletContext();
//		System.out.println(application);
	}
	    }
