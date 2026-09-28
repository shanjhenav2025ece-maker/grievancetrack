package com.example.grievancetrack.department.service;

import com.example.grievancetrack.department.entit.Department;
import com.example.grievancetrack.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department updateDepartment(Long id, Department department) {
        Department existingDepartment = getDepartmentById(id);

        existingDepartment.setName(department.getName());

        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(Long id) {
        Department existingDepartment = getDepartmentById(id);
        departmentRepository.delete(existingDepartment);
    }
}
