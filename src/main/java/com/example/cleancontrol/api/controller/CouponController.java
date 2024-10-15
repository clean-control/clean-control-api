package com.example.cleancontrol.api.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancontrol.api.service.CouponService;

import com.example.cleancontrol.api.dto.couponDto.*;
import com.example.cleancontrol.api.mapper.CouponMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;
        private final CouponMapper couponMapper;


    @GetMapping
    public ResponseEntity<List<CouponResponse>> getAllCoupon(){

          try {
            List<CouponResponse> coupon = couponService.findAll().stream().map(couponMapper::toResponse).collect(Collectors.toList());
            return ResponseEntity.ok(coupon);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponResponse> getCoupon(@PathVariable Integer id){
        try {
            CouponResponse coupon = couponMapper.toResponse(couponService.findById(id));
            return ResponseEntity.ok(coupon);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<CouponResponse> saveCoupon(@RequestBody CouponRequest data){
        try {
            CouponResponse coupon = couponMapper.toResponse(couponService.save(data));
            return ResponseEntity.ok(coupon);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouponResponse> updateCoupon(@PathVariable Integer id, @RequestBody CouponRequest data){
        try {
            CouponResponse coupon = couponMapper.toResponse(couponService.update(id, data));
            return ResponseEntity.ok(coupon);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Integer id){
        try {
            couponService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }
}
