package com.dbs.springmvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbs.springmvcapp.model.Address;
import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.service.EmployeeService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	//@RequestMapping(value="/login",method = RequestMethod.GET)
	@RequestMapping("/")
	public String  dashboard(Model model)
	{
		model.addAttribute("comingFirst",true);
		//List<Employee> listOfAllEmployees  = employeeService.listAll();
       // listOfAllEmployees.forEach(employee ->  System.out.println(employee));
		
		return "dashboard";
		
	}
	
	@RequestMapping("/loginPage")
	public String loginPage(Model model)
	{
		return "login";
	}
	
	@RequestMapping("/login")
	@PostMapping
    public String loginUser(
    		@RequestParam("name")String username, 
    		@RequestParam("password") String password,
    		Model model){
		
        System.out.println("Inside the POST method of login user");
        System.out.println("Username is "+username + " password is "+ password);
        
        if(username.equals(password))
        {
        	model.addAttribute("user",username);
        	return "success";
        }
        model.addAttribute("comingFirst",false);	
        return "login";
    }
	
	@RequestMapping("/listAll")
	public String listAll(Model model)
	{	
		List<Employee> listOfAllEmployees  = employeeService.listAll();
        listOfAllEmployees.forEach(employee ->  System.out.println(employee));
		//List<String> emp_list = Arrays.asList("ajay","vijay","Ramesh");
		model.addAttribute("list",listOfAllEmployees);
		return "list";
	}
	@RequestMapping("/delUser")
	public String showDelUserPage()
	{
		return "delUser";
	}
	
	@RequestMapping("/delById")
	public String delById(HttpServletRequest req)
	{
		employeeService.deleteEmployee(Integer.parseInt(req.getParameter("id")));
		return "dashboard";
	}
	
//	@RequestMapping("/register")
//    public String showRegistrationForm(Model model){
//        model.addAttribute("employee", new Employee());
//        return "register";
//    }
//	@RequestMapping("/registerUser")
//    public String registerUser( @Valid @ModelAttribute("employee") Employee employee,
//                                BindingResult bindingResult) throws IOException {
//        if(bindingResult.hasErrors()){
//            System.out.println("Error "+bindingResult.toString());
//            return "register";
//            //throw  new ArithmeticException("Exception occurred");
//				throw new IOException("Exception while registering Employee");
//        }
//
//        this.employeeService.saveEmployee(employee);
//        return "dashboard";
//    }
	
	@RequestMapping("/register")
	public String register(Model model)
	{
		return "register";
	}
	
	@RequestMapping("/registerUser")
	public String registerUser(HttpServletRequest req)
	{
		
		String name = req.getParameter("name");
		String deptName = req.getParameter("deptName");
		String city = req.getParameter("city");
		String state= req.getParameter("state");
		String street= req.getParameter("street");
		String zipcode= req.getParameter("zip");
		String DOB =req.getParameter("DOB");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDateObj = LocalDate.parse(DOB, dateTimeFormatter);
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		LocalDate localDate = LocalDate.parse(DOB);
		Employee e1 = new Employee();
		e1.setName(name);
		e1.setDepartmentName(deptName);
		e1.setDateOfBirth(localDateObj);
		Address address = new Address();
		address.setCity(city);
		address.setEmployee(e1);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zipcode);
		
		
		e1.setAddress(address);
		employeeService.saveEmployee(e1);
		return "dashboard";
	}
	@RequestMapping("/updatePage")
	public String updatePage()
	{
		return "update";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest req)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String deptName = req.getParameter("deptName");
		String city = req.getParameter("city");
		String state= req.getParameter("state");
		String street= req.getParameter("street");
		String zipcode= req.getParameter("zip");
		String DOB = req.getParameter("DOB");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDateObj = LocalDate.parse(DOB, dateTimeFormatter);
		Employee e1 = new Employee();
		e1.setId(id);
		e1.setName(name);
		e1.setDepartmentName(deptName);
		e1.setDateOfBirth(localDateObj);
		Address address = new Address();
		address.setCity(city);
		address.setEmployee(e1);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zipcode);
		
		e1.setAddress(address);
		
		employeeService.saveEmployee(e1);
		return "dashboard";
	}
	
	@ExceptionHandler(IOException.class)
	public String handleException(HttpServletRequest request,Exception ex) {return "login";}
	
	
}
