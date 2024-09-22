package com.example.cleancontrol.domain.model;


import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employeeType;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

 
}

