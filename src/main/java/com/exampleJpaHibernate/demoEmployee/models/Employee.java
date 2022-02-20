package com.exampleJpaHibernate.demoEmployee.models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25, nullable = false)
    private String firstName;

    @Column(length = 25, nullable = false)
    private String lastName;

    @Column(length = 25, nullable = false, unique = true)
    private String employeeId;

    /*
    * @ManyToOne :Es una de las anotaciones mas habituales a nivel de JPA y se encarga de generar una relación de muchos a uno .
    * @JoinColumn:Esta anotación sirve en JPA para hacer referencia a la columna que es clave externa en la tabla y que se encarga de definir la relación .
    * */

    // Role
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_role")
    private Role role;

    // project
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_project")
    private Project project;

    /*
    * Las relaciones Mucho a Muchos (@ManyToMany) se caracterízan por Entidades que están relacionadas con a muchos elementos de un tipo determinado
    * */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private List<Project> projects = new ArrayList<>();



}
