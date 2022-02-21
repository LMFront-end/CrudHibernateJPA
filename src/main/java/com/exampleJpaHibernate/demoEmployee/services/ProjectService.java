package com.exampleJpaHibernate.demoEmployee.services;

import com.exampleJpaHibernate.demoEmployee.models.Employee;
import com.exampleJpaHibernate.demoEmployee.models.Project;
import com.exampleJpaHibernate.demoEmployee.repositories.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private IProjectJpaRepository iprojectJpaRepository;

    // obtener todos los proyectos
    public List<Project> findAll() {
        return iprojectJpaRepository.findAll();
    }

    // obtener datos por id
    public Optional<Project> findById(Long projectId){
        return iprojectJpaRepository.findById(projectId);
    }

    //guardar proyecto
    public Project saveProject(Project project){
        return iprojectJpaRepository.save(project);
    }

    // Actualizar proyecto
    public Project updateProject(Project project) {
        Optional<Project> projectData = iprojectJpaRepository.findById(project.getId());

        if(projectData.isEmpty()){
            throw new IllegalArgumentException("El proyecto no se encuentra en la base de datos");
        }

        return iprojectJpaRepository.save(project);

    }

    //borrar proyecto
    public void deleteById(Long id){
        iprojectJpaRepository.deleteById(id);
    }




}
