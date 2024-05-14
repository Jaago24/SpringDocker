package com.jagadishGollapalli.springboot_tutorial.service;

import com.jagadishGollapalli.springboot_tutorial.Exceptions.DepartmentNotFound;
import com.jagadishGollapalli.springboot_tutorial.Repository.DepartmentRepository;
import com.jagadishGollapalli.springboot_tutorial.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp  implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentsList() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartmentFromList(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department DeptDB = departmentRepository.findById(departmentId).get();
        System.out.println("DeptDB" + DeptDB);

        if(department.getDepartmentName() != null && !"".equalsIgnoreCase(department.getDepartmentName())){
            //System.out.println("get department" + department.getDepartmentName());
            DeptDB.setDepartmentName(department.getDepartmentName());
        }

        /**if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            System.out.println("get department" + department.getDepartmentName());
            DeptDB.setDepartmentName(department.getDepartmentName());
        }**/
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            DeptDB.setDepartmentName(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            DeptDB.setDepartmentName(department.getDepartmentCode());
        }
        return departmentRepository.save(DeptDB);
    }

    @Override
    public Department getDepartmentsListByName(String departmentName) {
        // we don't have a default method to retrieve the list of departments by the name, so we create one in the department repository
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public Optional<Department> getDepartmentNameById(Long departmentId) throws DepartmentNotFound {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFound("Department Not found in the list");
        }
        return department;
    }

}
