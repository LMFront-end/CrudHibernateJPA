package com.exampleJpaHibernate.demoEmployee.services;



import com.exampleJpaHibernate.demoEmployee.models.Role;
import com.exampleJpaHibernate.demoEmployee.repositories.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private IRoleJpaRepository iroleJpaRepository;

    // obtener todos los proyectos
    public List<Role> findAll() {
        return iroleJpaRepository.findAll();
    }

    // obtener datos por id
    public Optional<Role> findById(Long projectId){
        return iroleJpaRepository.findById(projectId);
    }

    //guardar proyecto
    public Role saveRole(Role role){
        return iroleJpaRepository.save(role);
    }

    // Actualizar proyecto
    public Role updateRole(Role role) {
        Optional<Role> roleData = iroleJpaRepository.findById(role.getId());

        if(roleData.isEmpty()){
            throw new IllegalArgumentException("El role no se encuentra en la base de datos");
        }

        return iroleJpaRepository.save(role);

    }

    //borrar proyecto
    public void deleteById(Long id){
        iroleJpaRepository.deleteById(id);
    }

}
