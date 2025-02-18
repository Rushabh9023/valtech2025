package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import dao.Employee;
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
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		deptDAO = new DeptDAOImpl(config.getServletContext());
		
//		deptDAO.save(new Dept(1,"HR","Blr"));
//		deptDAO.save(new Dept(2,"HR","Ahm"));
//		deptDAO.save(new Dept(3,"Dev","Blr"));
//		deptDAO.save(new Dept(4,"Dev","Ahm"));
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		
//		if("Cancel".equals(operation)) {
//			req.setAttribute("depts", deptDAO.getAll());
//		    req.getRequestDispatcher("depts.jsp").forward(req, resp);
//		    return; 
//		} 
//		
//		Dept department = Dept.builder()
//				.id(Integer.parseInt(req.getParameter("id")))
//				.name(req.getParameter("name"))
//				.location(req.getParameter("location"))
//				.build();
//		
//		if("Save".equals(operation)) {
//			deptDAO.save(department);
//			req.setAttribute("depts", deptDAO.getAll());
//		    req.getRequestDispatcher("depts.jsp").forward(req, resp);
//		    return; 
//		}
//		if("Update".equals(operation)) {
//			deptDAO.update(department);
//			req.setAttribute("depts", deptDAO.getAll());
//		    req.getRequestDispatcher("depts.jsp").forward(req, resp);
//		    return; 
//		}
//		
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
        		 
        	 empList = empList
        	            .stream()
        	            .filter(e -> name == null || name.isEmpty() || e.getName().toLowerCase().contains(name.toLowerCase()))
        	            .filter(e -> age == null || age.isEmpty()
        	                || (age.startsWith(">") ? e.getAge() >= Integer.parseInt(age.substring(1)) :
        	                (age.startsWith("<") ? e.getAge() < Integer.parseInt(age.substring(1)) : e.getAge() == Integer.parseInt(age))))
        	            .filter(e -> salary == null || salary.isEmpty()
        	                || (salary.startsWith(">") ? e.getSalary() >= Integer.parseInt(salary.substring(1)) :
        	                (salary.startsWith("<") ? e.getSalary() < Integer.parseInt(salary.substring(1)) : e.getSalary() == Integer.parseInt(salary))))
        	            .filter(e -> level == null || level.isEmpty()
        	                || (level.startsWith(">") ? e.getLevel() >= Integer.parseInt(level.substring(1)) :
        	                (level.startsWith("<") ? e.getLevel() < Integer.parseInt(level.substring(1)) : e.getLevel() == Integer.parseInt(level))))
        	            .filter(e -> experience == null || experience.isEmpty()
        	                || (experience.startsWith(">") ? e.getExperience() >= Integer.parseInt(experience.substring(1)) :
        	                (experience.startsWith("<") ? e.getExperience() < Integer.parseInt(experience.substring(1)) : e.getExperience() == Integer.parseInt(experience))))
        	            .collect(Collectors.toList());

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
//      if("Update".equals(operation)) {
//   	 int id = Integer.parseInt(req.getParameter("id"));
//   	 Dept d = deptDAO.getDept(id);
//   	 req.setAttribute("dept", d);
//   	 req.setAttribute("mode", "Update");
//   	 req.setAttribute("readonly", "readonly");
//   	 req.getRequestDispatcher("editDepartment.jsp").forward(req, resp);
//   	 return;
//   	 
//    }
//  
//    if("Delete".equals(operation)) {
//   	 int id = Integer.parseInt(req.getParameter("id"));
//   	 deptDAO.delete(id);
//   	
//   	 req.setAttribute("depts", deptDAO.getAll());
//	    req.getRequestDispatcher("depts.jsp").forward(req, resp);
//	    return; 
//    }
//    if("new".equals(operation)) {
//   	 req.setAttribute("mode", "Save");
//   	 req.getRequestDispatcher("editDepartment.jsp").forward(req, resp);
//   	 return;
//    }
		
		
		
         
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
             current = deptDAO.first();  // Reset to first department
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
            		 List<Employee> sortByNameAsc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> e1.getName()
            				 .compareToIgnoreCase(e2.getName()))
            				 .collect(Collectors.toList());
            		 req.setAttribute("emplist", sortByNameAsc);
            		 
            	 } else {
            		 System.out.println("----------------------------------------s");
            		 List<Employee> sortByNameDesc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> e2.getName()
            				 .compareToIgnoreCase(e1.getName()))
            				 .collect(Collectors.toList());
            		 System.out.println("sortByNameDesc" + sortByNameDesc);
            		 req.setAttribute("emplist", sortByNameDesc);
            	 }
             } 
             
             if("id".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
            		 List<Employee> sortByIdAsc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Long.compare(e1.getId(), e2.getId()))
            				 .collect(Collectors.toList());
            		 req.setAttribute("emplist", sortByIdAsc);
            		 
            	 } else {
            		 System.out.println("----------------------------------------s");
            		 List<Employee> sortByIdDesc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Long.compare(e2.getId(), e1.getId()))
            				 .collect(Collectors.toList());
            		 req.setAttribute("emplist", sortByIdDesc);
            	 }
             }
             
             if("age".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
            		 List<Employee> sortByAgeAsc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Integer.compare(e1.getAge(), e2.getAge()))
            				 .collect(Collectors.toList());
            		 req.setAttribute("emplist", sortByAgeAsc);
            		 
            	 } else {
            		 System.out.println("----------------------------------------s");
            		 List<Employee> sortByAgeDesc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Integer.compare(e2.getAge(), e1.getAge()))
            				 .collect(Collectors.toList());
            		req.setAttribute("emplist", sortByAgeDesc);
            	 }
             }
             
             if("gender".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
            		 List<Employee> sortByGenderAsc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> e1.getGender().compareTo(e2.getGender()))
            				 .collect(Collectors.toList());
            		 req.setAttribute("emplist", sortByGenderAsc);
            		 
            	 } else {
            		 System.out.println("----------------------------------------s");
            		 List<Employee> sortByGenderDesc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> e2.getGender().compareTo(e1.getGender()))
            				 .collect(Collectors.toList());
            		req.setAttribute("emplist", sortByGenderDesc);
            	 }
             }
             
             if("salary".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
            		 List<Employee> sortBySalaryAsc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
            				 .collect(Collectors.toList());
            		 req.setAttribute("emplist", sortBySalaryAsc);
            		 
            	 } else {
            		 System.out.println("----------------------------------------s");
            		 List<Employee> sortBySalaryDesc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
            				 .collect(Collectors.toList());
            		req.setAttribute("emplist", sortBySalaryDesc);
            	 }
             }
             
             if("experience".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
            		 List<Employee> sortByExpAsc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Integer.compare(e1.getExperience(), e2.getExperience()))
            				 .collect(Collectors.toList());
            		 req.setAttribute("emplist", sortByExpAsc);
            		 
            	 } else {
            		 System.out.println("----------------------------------------s");
            		 List<Employee> sortByExpDesc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Integer.compare(e2.getExperience(), e1.getExperience()))
            				 .collect(Collectors.toList());
            		req.setAttribute("emplist", sortByExpDesc);
            	 }
             }
             
             if("level".equals(sortBy)) {
            	 if("asc".equals(sortOrder)) {
            		 List<Employee> sortByLevelAsc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Integer.compare(e1.getLevel(), e2.getLevel()))
            				 .collect(Collectors.toList());
            		 req.setAttribute("emplist", sortByLevelAsc);
            		 
            	 } else {
            		 System.out.println("----------------------------------------s");
            		 List<Employee> sortByLevelDesc = empList
            				 .stream()
            				 .sorted((Employee e1 , Employee e2) -> Integer.compare(e2.getLevel(), e1.getLevel()))
            				 .collect(Collectors.toList());
            		req.setAttribute("emplist", sortByLevelDesc);
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
