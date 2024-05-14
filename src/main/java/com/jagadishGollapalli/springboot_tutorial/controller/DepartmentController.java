package com.jagadishGollapalli.springboot_tutorial.controller;

import com.jagadishGollapalli.springboot_tutorial.Exceptions.DepartmentNotFound;
import com.jagadishGollapalli.springboot_tutorial.entity.Department;
import com.jagadishGollapalli.springboot_tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*TO MAKE THIS CLASS A COMPONENT OF SPRING, to add it to container*/
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    /**@RequestMapping(value = "/", method = RequestMethod.GET)*/

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    //@Valid is to let SB check for validation for particular object key in entity
    public Department saveAllDepartments(@Valid @RequestBody Department department) {
        logger.info("Data saved in Database successfully");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartmentsList();
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentId){
         departmentService.deleteDepartmentFromList(departmentId);
    }
    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,  @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFound {
        return departmentService.getDepartmentNameById(departmentId).get();
    }

    @GetMapping("/getDepartmentByName/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentsListByName(departmentName);
    }
}
