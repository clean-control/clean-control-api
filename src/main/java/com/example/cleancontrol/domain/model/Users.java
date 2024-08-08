package com.example.cleancontrol.domain.model;

import java.sql.Date;
import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class Users {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String lastname;

    private String nickname;

    private String email;

    private String password;

    private String cpf;

    private String phone;

    private Date dateBirth;

    private String imgUrl;

    private Boolean active;

    
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;
}
