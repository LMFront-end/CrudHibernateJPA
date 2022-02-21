package com.exampleJpaHibernate.demoEmployee.controllers;


import com.exampleJpaHibernate.demoEmployee.models.Employee;
import com.exampleJpaHibernate.demoEmployee.models.Role;
import com.exampleJpaHibernate.demoEmployee.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    // obtener todos los roles
    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    // obtener datos por id
    //http://localhost:8080/api/role/id={id}
    public Optional<Role> findById(@PathVariable Long id){
        return roleService.findById(id);
    }

    // actualizar role
    //http://localhost:8080/api/role/update
    @PutMapping("/update")
    public Role updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    // crear role
    @PostMapping("/create")
    //http://localhost:8080/api/role/create
    //@RequestBody -> convierte JSON a una instacia de clase
    public Role createRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }

    // eliminar role
    //http://localhost:8080/api/role/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        roleService.deleteById(id);
    }


}
