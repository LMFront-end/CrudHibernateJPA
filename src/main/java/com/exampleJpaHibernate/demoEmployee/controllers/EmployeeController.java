package com.exampleJpaHibernate.demoEmployee.controllers;


import com.exampleJpaHibernate.demoEmployee.models.Employee;
import com.exampleJpaHibernate.demoEmployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    /*
    * GET -> Consultar
    * POST -> Crear
    * PUT -> Modificar
    * DELETE -> Eliminar
    * */

    @Autowired
    EmployeeService employeeService;

    // obtener todos los empleados
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // obtener empleados por id (Long)
    //http://localhost:8080/api/employee/id={id}
    @GetMapping("/id={id}")
    public Optional<Employee> findById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    // obtener empleados por id (String)
    //http://localhost:8080/api/employee/employeeId={employeeId}
    @GetMapping("/employeeId={employeeId}")
    public Employee findByEmployeeId(@PathVariable  String employeeId){
        return employeeService.findByEmployeeId(employeeId);
    }

    // Crear empleado
    // http://localhost:8080/api/employee/save
    @PostMapping("/save")
    //@RequestBody -> convierte JSON a una instacia de clase
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    // Obtener por nombre
    // http://localhost:8080/api/employee/firstName={firstName}
    @GetMapping("/firstName={firstName}")
    public List<Employee> findAllByFirstName(@PathVariable String firstName){
        return employeeService.findAllByFirstName(firstName);
    }

    // Actualizar empleado
    // http://localhost:8080/api/employee/update
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    // borrar empleado
    // http://localhost:8080/api/employee/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
    }



}
