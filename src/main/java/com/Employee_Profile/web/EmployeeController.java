package com.Employee_Profile.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class EmployeeController {

    @RequestMapping("/index")
    public String index() {
        return "Welcome Employee";
    }

}
