package com.exampleJpaHibernate.demoEmployee.controllers;

import com.exampleJpaHibernate.demoEmployee.models.Project;
import com.exampleJpaHibernate.demoEmployee.models.Role;
import com.exampleJpaHibernate.demoEmployee.services.ProjectService;
import com.exampleJpaHibernate.demoEmployee.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/create")
    //http://localhost:8080/api/project/create
    //@RequestBody -> convierte JSON a una instacia de clase
    public Project createProject(@RequestBody Project project){
        return projectService.saveProject(project);
    }
}
