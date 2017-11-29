package com.Employee_Profile.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Employee_Profile.domain.*;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository erepository;
	
	@Autowired
	private DepartmentRepository drepository;
	
	// Will show all employees
	@RequestMapping(value="/employeelist")
    public String employeelist(Model model) {	
        model.addAttribute("employees", erepository.findAll());
        return "employeelist";
    }
	
	//RESTful service for all employees 
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public @ResponseBody List<Employee> employeeListRest() {
		return (List<Employee>) erepository.findAll();
	}
	
	//RESTful service for employee by id
	@RequestMapping(value="/employee/{id}", method = RequestMethod.GET)
    public @ResponseBody Employee findEmployeeRest(@PathVariable("id") Long employeeId) {	
    	return erepository.findOne(employeeId);
} 
	
	//Will add new employee
    @RequestMapping(value = "/add")
    public String addEmployee(Model model){
    	model.addAttribute("employee", new Employee());
    	model.addAttribute("departments", drepository.findAll());
        return "addemployee";
    }     
    
    //save the employee
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Employee employee){
        erepository.save(employee);
        return "redirect:employeelist";
    }
    
    //for editing the employee
    @RequestMapping(value = "/edit/{id}")
    public String editEmployee(@PathVariable("id") Long employeeId,Model model){
    	model.addAttribute("employee", erepository.findOne(employeeId));
    	model.addAttribute("departments",drepository.findAll());
        return "editemployee";
    }     
    
    //for deleting the employee
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long employeeId, Model model) {
    	erepository.delete(employeeId);
        return "redirect:../employeelist";
    }     
}
