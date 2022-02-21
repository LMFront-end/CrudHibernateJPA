package com.exampleJpaHibernate.demoEmployee.controllers;

import com.exampleJpaHibernate.demoEmployee.models.Project;
import com.exampleJpaHibernate.demoEmployee.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    // obtener todos los projects
    @GetMapping
    public List<Project> findAll() {
        return projectService.findAll();
    }

    // obtener datos por id
    //http://localhost:8080/api/project/id={id}
    public Optional<Project> findById(@PathVariable Long id){
        return projectService.findById(id);
    }

    // actualizar project
    //http://localhost:8080/api/project/update
    @PutMapping("/update")
    public Project updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }

    @PostMapping("/create")
    //http://localhost:8080/api/project/create
    //@RequestBody -> convierte JSON a una instacia de clase
    public Project createProject(@RequestBody Project project){
        return projectService.saveProject(project);
    }

    // eliminar project
    //http://localhost:8080/api/project/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        projectService.deleteById(id);
    }
}
