package com.jagadishGollapalli.springboot_tutorial.controller;

import com.jagadishGollapalli.springboot_tutorial.entity.Department;
import com.jagadishGollapalli.springboot_tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentControllerTest {

    @Mock
    DepartmentService departmentService;

    @InjectMocks
    DepartmentController departmentController;

    Long departmentId = 1L;
    String departmentName ="CSE";
    String departmentAddress ="1121NRD";
    String departmentCode ="CSE-24";
    Department departmentr;
    @BeforeEach
    void setUp() {
         departmentr = new Department(departmentId, departmentName, departmentAddress, departmentCode);
//        departmentId = 1L;
//        departmentName = "ECE";
//        departmentAddress = "1121NRD";
//        departmentCode = "CSE-24";
    }

    @Test
    void saveAllDepartmentsTest() {
        Department department =
                Department.builder()
                        .departmentId(1L)
                        .departmentName("CSE")
                        .departmentAddress("1121NRD")
                        .departmentCode("CSE-24")
                .build();
        Mockito.when(departmentService.saveDepartment(department)).thenReturn(department);

        Department response = departmentController.saveAllDepartments(department);

        // Then

        assertEquals(departmentr, response);
       // assertEquals(department,departmentController.saveAllDepartments(department));
    }
}