package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.CouponType;

@Repository
public interface CouponTypeRepository extends JpaRepository<CouponType, Integer>{

}
