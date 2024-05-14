package com.jagadishGollapalli.springboot_tutorial.Repository;

import com.jagadishGollapalli.springboot_tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String departmentName);
    //It's important to note that Spring Data JPA automatically recognizes the IgnoreCase
    //keyword in method names and translates it to a case-insensitive comparison in the generated SQL query.
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
