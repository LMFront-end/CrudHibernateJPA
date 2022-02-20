package com.exampleJpaHibernate.demoEmployee.services;

import com.exampleJpaHibernate.demoEmployee.models.Employee;
import com.exampleJpaHibernate.demoEmployee.repositories.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// TODO: 20/02/2022: Creación de los servicios de un CRUD. ( Crear, Eliminar, Actualizar, Obtener todos y Obtener por ID).
@Service
public class EmployeeService {

    @Autowired
    private IEmployeeJpaRepository iEmployeeJpaRepository;

    // obtener todos los empleados
    public List<Employee> findAll() {
        return iEmployeeJpaRepository.findAll();
    }

    // obtener empleados por id (Long)
    public Optional<Employee> findById(Long id){
        return iEmployeeJpaRepository.findById(id);
    }

    // obtener empleados por id (String)
    public Employee findByEmployeeId(String employeeId){
        return iEmployeeJpaRepository.findByEmployeeId(employeeId);
    }

    // Crear empleado
    public Employee saveEmployee(Employee employee){
        return iEmployeeJpaRepository.save(employee);
    }

    // Obtener por nombre
    public List<Employee> findAllByFirstName(String firstName){
        return iEmployeeJpaRepository.findAllByFirstName(firstName);
    }

    // Actualizar empleado
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeData = iEmployeeJpaRepository.findById(employee.getId());

        if(employeeData.isEmpty()){
            throw new IllegalArgumentException("El empleado no se encuentra en la base de datos");
        }

        return iEmployeeJpaRepository.save(employee);

    }

    // borrar empleado
    public void deleteById(Long id){
        iEmployeeJpaRepository.deleteById(id);
    }



}
