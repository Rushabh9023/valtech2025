package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import assignment.servlets.dao.DeptDAO;
import assignment.servlets.dao.DeptDAOImpl;
import assignment.servlets.dao.EmployeeDAO;
import assignment.servlets.dao.EmployeeDAOImpl;
import assignment.servlets.entity.Dept;
import assignment.servlets.entity.Employee;
import assignment.servlets.service.DeptService;
import assignment.servlets.service.DeptServiceImpl;
import assignment.servlets.service.EmployeeService;
import assignment.servlets.service.EmployeeServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/depts")
public class DeptServlet extends HttpServlet {
	
	private DeptDAO deptDAO;
	  List<Employee> empList; 
	  
	  private EmployeeDAO dao;
		private DeptService deptService;
		
		
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String url=(String) config.getServletContext().getAttribute("url");
		String username=(String) config.getServletContext().getAttribute("username");
		String password= (String) config.getServletContext().getAttribute("password");
	
		
		deptDAO = new DeptDAOImpl(url,username,password);
		dao = new EmployeeDAOImpl(url,username,password); 
		deptService = new DeptServiceImpl(dao);
		
//		deptDAO.save(new Dept(1,"HR","Blr"));
//		deptDAO.save(new Dept(2,"HR","Ahm"));
//		deptDAO.save(new Dept(3,"Dev","Blr"));
//		deptDAO.save(new Dept(4,"Dev","Ahm"));
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		
		HttpSession session = req.getSession();
		Dept current =  (Dept) session.getAttribute("current");
		if(current == null) {
			current = deptDAO.first();
		}else {
			if("First".equals(operation)) {
				current = deptDAO.first();
			}else if("Last".equals(operation)) {
				current = deptDAO.last();
			}else if("Previous".equals(operation)) {
				current = deptDAO.previous(current.getId());
			}else if("Next".equals(operation)){
				current = deptDAO.next(current.getId());
			}
		}
		
		if("Cancel".equals(operation)) {
			req.setAttribute("depts", deptDAO.getAll());
		    req.getRequestDispatcher("depts.jsp").forward(req, resp);
		    return; 
		} 
//		
//		
//		
		
		if("Save".equals(operation)) {
			Dept department = Dept.builder()
					.id(Integer.parseInt(req.getParameter("id")))
					.name(req.getParameter("name"))
					.location(req.getParameter("location"))
					.build();
	
			deptDAO.save(department);
			req.setAttribute("dept", deptDAO.getDept(current.getId()));
		    req.getRequestDispatcher("depts.jsp").forward(req, resp);
		    return; 
		}
		if("Update".equals(operation)) {
			Dept department = Dept.builder()
					.id(Integer.parseInt(req.getParameter("id")))
					.name(req.getParameter("name"))
					.location(req.getParameter("location"))
					.build();
			deptDAO.update(department);
			req.setAttribute("dept", deptDAO.getDept(current.getId()));
		    req.getRequestDispatcher("depts.jsp").forward(req, resp);
		    return; 
		}
//		
		
		session.setAttribute("current", current);
		req.setAttribute("emplist", deptDAO.setDept(current.getId()));
		//Expressions in JSP can work with object in session also....
		req.setAttribute("dept", current);
		
		
		Cookie [] cookies = req.getCookies();
		for(int i =0;i<cookies.length;i++) {
			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
		}
		if("Search".equals(operation)) {
		    empList = deptDAO.setDept(current.getId());
		       req.setAttribute("emplist", empList);
			 String name= req.getParameter("name");
        	 String age= req.getParameter("age");
        	 String salary= req.getParameter("salary");
        	 String level= req.getParameter("level");
        	 String experience= req.getParameter("experience");
        	 
//        	 if((age != null && !age.isEmpty() && age.substring(0, 1).equals(">")) 
//        	     || (salary != null && !salary.isEmpty()&& salary.substring(0, 1).contains(">"))
//        			 || level.substring(0, 1).contains(">") || experience.substring(0, 1).contains(">")) {
//        		 String ageG= req.getParameter("age").substring(1);
//            	 String salaryG= req.getParameter("salary").substring(1);
//            	 String levelG= req.getParameter("level").substring(1);
//            	 String experienceG= req.getParameter("experience").substring(1);
//        	     empList = empList
//        				 .stream()
//            			 .filter(e ->  name==null ||name.isEmpty() || e.getName().toLowerCase().contains(name.toLowerCase()))
//            			 .filter(e -> ageG==null || ageG.isEmpty()|| e.getAge()>=Integer.parseInt(ageG))
//            			 .filter(e -> salaryG==null || salaryG.isEmpty()|| e.getSalary()>=Integer.parseInt(salaryG))
//            			 .filter(e -> levelG==null || levelG.isEmpty()|| e.getLevel()>=Integer.parseInt(levelG))
//            			 .filter(e -> experienceG==null || experienceG.isEmpty()|| e.getExperience()>=Integer.parseInt(experienceG))
//            	        .collect(Collectors.toList());
//            	 req.setAttribute("emplist",empList);
//        	 }else {
        		 
        	 empList = deptService.serachEmployees(empList, name, age, salary, level, experience);

        	req.setAttribute("emplist", empList);
        		 
//        	 }
        	 
        	
		}
		resp.addCookie(new Cookie("operation", operation));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("operation");
		 String sortBy = req.getParameter("sortBy");
         String sortOrder = req.getParameter("sortOrder");
         if (sortOrder == null) {
        	    sortOrder = "asc"; // Default sorting order
        	} else {
        	    sortOrder = "asc".equals(sortOrder) ? "desc" : "asc";
        	}

        	req.setAttribute("sortOrder", sortOrder);
         System.out.println(sortOrder);
         
		 
         
//         
      if("Update".equals(operation)) {
   	 int id = Integer.parseInt(req.getParameter("id"));
   	 Dept d = deptDAO.getDept(id);
   	 req.setAttribute("dept", d);
   	 req.setAttribute("mode", "Update");
   	 req.setAttribute("readonly", "readonly");
   	 req.getRequestDispatcher("editDepartment.jsp").forward(req, resp);
   	 return;
   	 
    }
  
    if("Delete".equals(operation)) {
   	 int id = Integer.parseInt(req.getParameter("id"));
   	 deptDAO.delete(id);
   	
   	 req.setAttribute("depts", deptDAO.getAll());
	    req.getRequestDispatcher("depts.jsp").forward(req, resp);
	    return; 
    }
    if("new".equals(operation)) {
   	 req.setAttribute("mode", "Save");
   	 req.getRequestDispatcher("editDepartment.jsp").forward(req, resp);
   	 return;
    }
		
		
		
         
//         if (sortOrder == null) {
//             Cookie[] cookies = req.getCookies();
//             if (cookies != null) {
//                 for (Cookie cookie : cookies) {
//                     if ("sortOrder".equals(cookie.getName())) {
//                         sortOrder = cookie.getValue();
//                         break;
//                     }
//                 }
//             }
//             if (sortOrder == null) {
//                 sortOrder = "asc"; // Default to ascending order if no cookie exists
//             }
//         } else {
//             // Toggle order
//             sortOrder = "asc".equals(sortOrder) ? "desc" : "asc";
//         }

         // Store the updated sortOrder in a cookie
//         Cookie sortOrderCookie = new Cookie("sortOrder", sortOrder);
//         sortOrderCookie.setMaxAge(60 * 60 * 24 * 7); // 7 days expiration
//         resp.addCookie(sortOrderCookie);
//
//         req.setAttribute("sortOrder", sortOrder);
         
         HttpSession session = req.getSession();
         
         
         Dept current;
         if (operation == null && sortBy == null) {  
        	// Reset to first department
             current = deptDAO.first();  
             session.setAttribute("current", current);
         } else {
             current = (Dept) session.getAttribute("current");
             if (current == null) {
                 current = deptDAO.first();
                 session.setAttribute("current", current);
             }
         }

         
         
         req.setAttribute("dept", current);
//	       System.out.println(deptDAO.first());
	      
//	       session.setAttribute("current", deptDAO.first());
	       
//	       System.out.println(deptDAO.first().getId());
	     
	       empList = deptDAO.setDept(current.getId());
	       req.setAttribute("emplist", empList);
	       
         if("sort".equals(operation)) {
        	 if("name".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
            		empList = deptService.sortEmployeesByNameAsc(empList);
            		 req.setAttribute("emplist", empList);
            		 
            	 } else {
            		 System.out.println("----------------------------------------s");
            		 empList = deptService.sortEmployeesByNameDesc(empList);
            		 req.setAttribute("emplist", empList);
            	 }
             } 
             
             if("id".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
             		empList = deptService.sortEmployeesByIdAsc(empList);
             		 req.setAttribute("emplist", empList);
             		 
             	 } else {
             		 empList = deptService.sortEmployeesByIdDesc(empList);
             		 req.setAttribute("emplist", empList);
             	 }
             }
             
             if("age".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
             		empList = deptService.sortEmployeesByAgeAsc(empList);
             		 req.setAttribute("emplist", empList);
             		 
             	 } else {
             		 empList = deptService.sortEmployeesByAgeDesc(empList);
             		 req.setAttribute("emplist", empList);
             	 }
             }
             
             if("gender".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
             		empList = deptService.sortEmployeesByGenderAsc(empList);
             		 req.setAttribute("emplist", empList);
             		 
             	 } else {
             		 empList = deptService.sortEmployeesByGenderDesc(empList);
             		 req.setAttribute("emplist", empList);
             	 }
             }
             
             if("salary".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
             		empList = deptService.sortEmployeesBySalaryAsc(empList);
             		 req.setAttribute("emplist", empList);
             		 
             	 } else {
             		 empList = deptService.sortEmployeesBySalaryDesc(empList);
             		 req.setAttribute("emplist", empList);
             	 }
             }
             
             if("experience".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
             		empList = deptService.sortEmployeesByExperienceAsc(empList);
             		 req.setAttribute("emplist", empList);
             		 
             	 } else {
             		 empList = deptService.sortEmployeesByExperienceDesc(empList);
             		 req.setAttribute("emplist", empList);
             	 }
             }
             
             if("level".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
             		empList = deptService.sortEmployeesByLevelAsc(empList);
             		 req.setAttribute("emplist", empList);
             		 
             	 } else {
             		 empList = deptService.sortEmployeesByLevelDesc(empList);
             		 req.setAttribute("emplist", empList);
             	 }
             }
         }
//        
//         if("Search".equals(operation)) {
//        	 String name= req.getParameter("name");
//        	 String age= req.getParameter("age");
//        	 String salary= req.getParameter("salary");
//        	 String level= req.getParameter("level");
//        	 String experience= req.getParameter("experience");
//        	 
//        	 List<Employee> search = empList
//        			 .stream()
//        			 .filter(e ->   e.getName().toLowerCase().contains(name.toLowerCase()))
//        	        .collect(Collectors.toList());
//        	 req.setAttribute("emplist", search);
//        	
//        	 
//         }
         
         session.setAttribute("current", current);
    	 req.getRequestDispatcher("depts.jsp").forward(req, resp);
         
//		 System.out.println("This line--------------------------------------------------");       
//		   req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}
}
