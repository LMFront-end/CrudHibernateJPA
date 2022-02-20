package com.exampleJpaHibernate.demoEmployee.repositories;

import com.exampleJpaHibernate.demoEmployee.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectJpaRepository extends JpaRepository <Project, Long> {

    Project findProjectById(Long projectId);

    List<Project> findAllByName(String name);

}
