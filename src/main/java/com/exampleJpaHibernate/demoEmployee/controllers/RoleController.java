package com.exampleJpaHibernate.demoEmployee.controllers;


import com.exampleJpaHibernate.demoEmployee.models.Role;
import com.exampleJpaHibernate.demoEmployee.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/create")
    //http://localhost:8080/api/role/create
    //@RequestBody -> convierte JSON a una instacia de clase
    public Role createRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }



}
