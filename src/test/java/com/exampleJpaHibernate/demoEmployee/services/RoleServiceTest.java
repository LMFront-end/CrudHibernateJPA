package com.exampleJpaHibernate.demoEmployee.services;


import com.exampleJpaHibernate.demoEmployee.models.Role;
import com.exampleJpaHibernate.demoEmployee.repositories.IRoleJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Optional;

@SpringBootTest
class RoleServiceTest {

    @MockBean
    IRoleJpaRepository iroleJpaRepository;
    @Autowired
    private RoleService roleService;

    @Test
    void saveRole() {
        Role role = new Role("Developer");
        Mockito.when(iroleJpaRepository.save(Mockito.any())).thenReturn(role);
        Role role1 = roleService.saveRole(role);

        Assertions.assertEquals(role, role1);
    }

    @Test
    void findById(){
        Role role = new Role("Developer");
        Long id = 12345L;
        Mockito.when(iroleJpaRepository.findById(Mockito.any())).thenReturn(Optional.of(role));
        Optional<Role> role1 = roleService.findById(id);

        Assertions.assertEquals(Optional.of(role), role1);
    }
}