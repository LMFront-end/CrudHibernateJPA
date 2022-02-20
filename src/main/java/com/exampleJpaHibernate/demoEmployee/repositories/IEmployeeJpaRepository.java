package com.exampleJpaHibernate.demoEmployee.repositories;

import com.exampleJpaHibernate.demoEmployee.models.Employee;
import com.exampleJpaHibernate.demoEmployee.models.Project;
import com.exampleJpaHibernate.demoEmployee.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeId(String employeeId);


    List<Employee> findAllByFirstName(String firstName);
    List<Employee> findAllByLastName(String lastName);
    List<Employee> findAllByRole(Role role);
    List<Employee> findAllByProject(Project project);


}
