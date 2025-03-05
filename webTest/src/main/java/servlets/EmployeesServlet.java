package servlets;

import java.io.IOException;
import java.util.List;

import assignment.servlets.dao.EmployeeDAO;
import assignment.servlets.dao.EmployeeDAOImpl;
import assignment.servlets.entity.Employee;
import assignment.servlets.entity.Employee.Gender;
import assignment.servlets.service.EmployeeService;
import assignment.servlets.service.EmployeeServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {
	
	private EmployeeDAO dao;
	private EmployeeService empService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		dao = new EmployeeDAOImpl(config.getServletContext());
		 empService = new EmployeeServiceImpl(dao);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
		String operation = req.getParameter("operation");
		if("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
		    req.getRequestDispatcher("employees.jsp").forward(req, resp);
		    return; 
		} 
		
		//Since we want in both save and update so we write outside if
		Employee emp = Employee.builder().id(Integer.parseInt(req.getParameter("id"))) 
				.name(req.getParameter("name"))
				.age(Integer.parseInt(req.getParameter("age")))
				.gender(Gender.valueOf(req.getParameter("gender").toUpperCase()))
				.salary(Integer.parseInt(req.getParameter("salary")))
				.experience(Integer.parseInt(req.getParameter("experience")))
				.level(Integer.parseInt(req.getParameter("level")))
				.deptId(Integer.parseInt(req.getParameter("deptid")))
				.build();
//		
		
		if("Save".equals(operation)) {
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
		    req.getRequestDispatcher("employees.jsp").forward(req, resp);
		    return; 
		}
		if("Update".equals(operation)) {
			dao.update(emp);
			req.setAttribute("emps", dao.getAll());
		    req.getRequestDispatcher("employees.jsp").forward(req, resp);
		    return; 
		}
		

	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String operation = req.getParameter("operation");
         String sortBy = req.getParameter("sortBy");
         String sortOrder = req.getParameter("sortOrder");
         
         if("Update".equals(operation)) {
        	 int id = Integer.parseInt(req.getParameter("id"));
        	 Employee e = dao.get(id);
        	 req.setAttribute("emp", e);
        	 req.setAttribute("mode", "Update");
        	 req.setAttribute("readonly", "readonly");
        	 req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
        	 return;
        	 
         }
         if("Delete".equals(operation)) {
        	 int id = Integer.parseInt(req.getParameter("id"));
        	 dao.delete(id);
        	 req.setAttribute("emps", dao.getAll());
 		    req.getRequestDispatcher("employees.jsp").forward(req, resp);
 		    return; 
         }
         if("new".equals(operation)) {
        	 req.setAttribute("mode", "Save");
        	 req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
        	 return;
         }
//         if("Dept".equals(operation)) {
//        	 req.getRequestDispatcher("depts.jsp").forward(req, resp);
//         }
         if("sort".equals(operation)) {
        	 if(sortOrder==null) {
        		 sortOrder="asc";
        	 }
        	 if(sortBy==null) {
        		 sortBy="id";
        	 }
        	 List<Employee> empsorted = null;
        	 
        	 switch(sortBy) {
        	 
        	 case "id":empsorted = empService.sortEmployeesById(sortOrder);
        	 	break;
        		 
        	 case "name":empsorted = empService.sortEmployeesByName(sortOrder);
        	 	break;
        	     
        	 case "age":empsorted = empService.sortEmployeesByAge(sortOrder);
    		 	break;
    		 
        	 case "gender":empsorted = empService.sortEmployeesByGender(sortOrder);
        	 	break;
        	 	
        	 case "salary":empsorted = empService.sortEmployeesBySalary(sortOrder);
    		 	break;
    		 	
        	 case "experience":empsorted = empService.sortEmployeesByExperience(sortOrder);
    		 	break;
    		 	
        	 case "level":empsorted = empService.sortEmployeesByLevel(sortOrder);
    		 	break;
    		 	
        	 case "deptid":empsorted = empService.sortEmployeesByDeptId(sortOrder);
        	 	break;
        	 
        	 }
        	 req.setAttribute("emps", empsorted);
        	 req.setAttribute("sortOrder", sortOrder);
        	 req.getRequestDispatcher("employees.jsp").forward(req, resp);
        	 return;
         }
         
        
         
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp);
	}

}
