package com.example.fillForm.service;

import com.example.fillForm.model.Employee;
import com.example.fillForm.model.EmployeeType;
import com.example.fillForm.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public Iterable<Employee> findAll(){
        return  employeeRepository.findAll();
    }

    public Employee findById(Long id){
       return employeeRepository.findById(id).get();
    }

    public void save(String uploadPath, String firstName, String lastName, String middleName,
                     MultipartFile multipartFile, EmployeeType employeeType, String description,
                     String isActive){
        Employee employee = new Employee();
        boolean active;

        if(multipartFile != null ){
            File uploadDirectory = new File(uploadPath);
            if(!uploadDirectory.exists()) {
                uploadDirectory.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + multipartFile.getOriginalFilename();

            try {
                multipartFile.transferTo(new File(uploadPath+"/"+resultFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            employee.setMediaPath(resultFilename);
        }


        if(isActive.contains("1")){
            active = true;
        }else active = false;

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setMiddleName(middleName);
        employee.setEmployeeType(employeeType);
        employee.setDescription(description);
        employee.setActive(active);
        employeeRepository.save(employee);
    }

}
