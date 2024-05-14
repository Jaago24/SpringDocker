package com.jagadishGollapalli.springboot_tutorial.service;

import com.jagadishGollapalli.springboot_tutorial.Exceptions.DepartmentNotFound;
import com.jagadishGollapalli.springboot_tutorial.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    List<Department> getDepartmentsList();
    public void deleteDepartmentFromList(Long departmentId);
    public Department updateDepartment(Long departmentId, Department department);
    public Department getDepartmentsListByName(String departmentName);
    public Optional<Department> getDepartmentNameById(Long departmentId) throws DepartmentNotFound;
}
