package com.example.examiasfaptech.controller;

import com.example.examiasfaptech.entity.Employee;
import com.example.examiasfaptech.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/home")
    public String home(Model model){
        List<Employee> employees = employeeService.findAllEmployee();
        model.addAttribute("data",employees);
        return "home";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "create";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute("createEmployee") Employee employee){
        employeeService.createEmployee(employee);
        return "redirect:/home";
    }
}
