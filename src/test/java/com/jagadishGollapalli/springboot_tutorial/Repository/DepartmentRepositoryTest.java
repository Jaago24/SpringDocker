package com.jagadishGollapalli.springboot_tutorial.Repository;

import com.jagadishGollapalli.springboot_tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("ACS")
                        .departmentAddress("1121N")
                        .departmentCode("ACS67-24")
                        .build();

        entityManager.persist(department);
    }
    @Test
    public  void WhenFindById_thenReturnDepartment(){
        Department departments = departmentRepository.findByDepartmentName("ACS");
        assertEquals(departments.getDepartmentCode(), "ACS67-24");
    }
}