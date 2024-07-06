package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer>{

}
