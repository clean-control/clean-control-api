package com.example.cleancontrol.domain.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
public class IntegrationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    @CreationTimestamp
    private String createDate;

    @UpdateTimestamp
    private String updateDate;

    private Integer statusCode;

    private String message;

    private String className;

    private String methodName;

    private String url;

    private String responseBody;

    private String requestBody;

    private String methodHttp;

    private String entity;

    private Integer entityId;

}
