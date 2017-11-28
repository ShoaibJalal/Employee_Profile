package com.Employee_Profile.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Employee_Profile.domain.*;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository erepository;

	@RequestMapping(value="/employeelist")
    public String employeelist(Model model) {	
        model.addAttribute("employees", erepository.findAll());
        return "employeelist";
    }
  
    @RequestMapping(value = "/add")
    public String addEmployee(Model model){
    	model.addAttribute("employee", new Employee());
        return "addemployee";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Employee employee){
        erepository.save(employee);
        return "redirect:employeelist";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editEmployee(@PathVariable("id") Long employeeId,Model model){
    	model.addAttribute("employee", erepository.findOne(employeeId));
        return "editemployee";
    }     

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long employeeId, Model model) {
    	erepository.delete(employeeId);
        return "redirect:../employeelist";
    }     
}
