package com.jagadishGollapalli.springboot_tutorial.service;

import com.jagadishGollapalli.springboot_tutorial.Repository.DepartmentRepository;
import com.jagadishGollapalli.springboot_tutorial.entity.Department;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @InjectMocks
    DepartmentServiceImp departmentService;
    @Mock
    DepartmentRepository departmentRepository;
    String departmentName;
    @BeforeEach
    void setUp() {
        departmentName = "ACS";
    }

    @Test
    public void getDepartmentsListByNameTest(){
        Department department =
                Department.builder()
                        .departmentName("ACS").build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("ACS")).thenReturn(department);
        assertEquals(departmentName, departmentService.getDepartmentsListByName("ACS").getDepartmentName());
    }

}