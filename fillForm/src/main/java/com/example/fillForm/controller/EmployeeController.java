package com.example.fillForm.controller;

import com.example.fillForm.model.EmployeeType;
import com.example.fillForm.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("")
    public String getWelcomePage(Model model){
        model.addAttribute("type", EmployeeType.values());
        model.addAttribute("employee",employeeService.findAll());
        return "addEmployeePage";
    }

    @PostMapping("")
    public String saveEmployee(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String middleName,
                               @RequestParam ("multipartFile") MultipartFile multipartFile,
                               @RequestParam EmployeeType employeeType,
                               @RequestParam String description,
                               @RequestParam String isActive,
                               Model model){
        employeeService.save(uploadPath,firstName,lastName,
                middleName,multipartFile,employeeType,
                description,isActive);
        return "redirect:/";
    }

    @GetMapping("/employee")
    public String getEmployees(Model model){
        model.addAttribute("employee",employeeService.findAll());
        return "employeesPage";
    }
}

