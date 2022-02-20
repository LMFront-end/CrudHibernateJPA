package com.exampleJpaHibernate.demoEmployee.repositories;

import com.exampleJpaHibernate.demoEmployee.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleJpaRepository extends JpaRepository<Role, Long> {

    Role findRoleById(Long roleId);

    List<Role> findAllByName(String name);
}
