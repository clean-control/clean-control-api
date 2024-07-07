package com.example.cleancontrol.dto.couponDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.model.CouponType;
import com.example.cleancontrol.model.Enterprise;

import lombok.Builder;

@Builder
public record CouponResponse(Integer id, String name, String description, Double discount, Boolean active,
        Enterprise enterprise, CouponType couponType,
        LocalDateTime createDate, LocalDateTime updateDate) {

}