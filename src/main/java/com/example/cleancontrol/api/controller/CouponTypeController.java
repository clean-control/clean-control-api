package com.example.cleancontrol.api.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancontrol.api.service.CouponTypeService;

import com.example.cleancontrol.api.dto.couponTypeDto.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/couponType")
@RequiredArgsConstructor
public class CouponTypeController {

    private final CouponTypeService couponTypeService;

    @GetMapping
    public ResponseEntity<List<CouponTypeResponse>> getAllCouponType(){

          try {
            List<CouponTypeResponse> couponType = couponTypeService.findAll();
            return ResponseEntity.ok(couponType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponTypeResponse> getCouponType(@PathVariable Integer id){
        try {
            CouponTypeResponse couponType = couponTypeService.findById(id);
            return ResponseEntity.ok(couponType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<CouponTypeResponse> saveCouponType(@RequestBody CouponTypeRequest data){
        try {
            CouponTypeResponse couponType = couponTypeService.save(data);
            return ResponseEntity.ok(couponType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouponTypeResponse> updateCouponType(@PathVariable Integer id, @RequestBody CouponTypeRequest data){
        try {
            CouponTypeResponse couponType = couponTypeService.update(id, data);
            return ResponseEntity.ok(couponType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCouponType(@PathVariable Integer id){
        try {
            couponTypeService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}