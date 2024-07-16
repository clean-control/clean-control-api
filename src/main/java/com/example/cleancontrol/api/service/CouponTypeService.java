package com.example.cleancontrol.api.service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.couponTypeDto.CouponTypeRequest;
import com.example.cleancontrol.api.dto.couponTypeDto.CouponTypeResponse;
import com.example.cleancontrol.api.mapper.CouponTypeMapper;
import com.example.cleancontrol.domain.model.CouponType;
import com.example.cleancontrol.domain.repository.CouponTypeRepository;

@Service
@RequiredArgsConstructor
public class CouponTypeService {

    private final CouponTypeRepository couponTypeRepository;
    private final CouponTypeMapper couponTypeMapper;

    public List<CouponTypeResponse> findAll() {
        try {
            return couponTypeMapper.toResponse(couponTypeRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Error to get coupon types");
        }
    }

    public CouponTypeResponse findById(Integer id) {
        try {
            return couponTypeMapper.toResponse(couponTypeRepository.findById(id).get());
        } catch (Exception e) {
            throw new RuntimeException("Error to get coupon type");
        }
    }

    public CouponTypeResponse save(CouponTypeRequest couponTypeRequest) {
        try {
            CouponType couponType = couponTypeMapper.toEntity(couponTypeRequest);
            return couponTypeMapper.toResponse(couponTypeRepository.save(couponType));
        } catch (Exception e) {
            throw new RuntimeException("Error to save coupon type");
        }
    }

    public CouponTypeResponse update(Integer id, CouponTypeRequest couponTypeRequest) {
        try {
            CouponType couponType = couponTypeMapper.toEntity(id, couponTypeRequest);
            return couponTypeMapper.toResponse(couponTypeRepository.save(couponType));
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
