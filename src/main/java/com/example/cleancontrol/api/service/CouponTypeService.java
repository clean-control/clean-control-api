package com.example.cleancontrol.api.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.couponTypeDto.CouponTypeRequest;
import com.example.cleancontrol.api.mapper.CouponTypeMapper;
import com.example.cleancontrol.domain.model.CouponType;
import com.example.cleancontrol.domain.repository.CouponTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CouponTypeService {

    private final CouponTypeRepository couponTypeRepository;
    private final CouponTypeMapper couponTypeMapper;

    public List<CouponType> findAll() {
        try {
            return couponTypeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error to get coupon types");
        }
    }

    public CouponType findById(Integer id) {
        try {
            return couponTypeRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Error to get coupon type");
        }
    }

    public CouponType save(CouponTypeRequest couponTypeRequest) {
        try {
            CouponType couponType = couponTypeMapper.toEntity(couponTypeRequest);
            return couponTypeRepository.save(couponType);
        } catch (Exception e) {
            throw new RuntimeException("Error to save coupon type");
        }
    }

    public CouponType update(Integer id, CouponTypeRequest couponTypeRequest) {
        try {
            CouponType couponType = couponTypeMapper.toEntity(id, couponTypeRequest);
            return couponTypeRepository.save(couponType);
        } catch (Exception e) {
            throw new RuntimeException("Error to update coupon type");
        }
    }

    public void delete(Integer id) {
        try {
            couponTypeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error to delete coupon type");
        }
    }

}
