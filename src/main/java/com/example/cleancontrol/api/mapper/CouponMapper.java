package com.example.cleancontrol.api.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.couponDto.CouponResponse;
import com.example.cleancontrol.domain.model.Coupon;

@Component
public class CouponMapper {
    
    public CouponResponse toResponse(Coupon coupon) {
        return CouponResponse.builder()
                .id(coupon.getId())
                .name(coupon.getName())
                .description(coupon.getDescription())
                .discount(coupon.getDiscount())
                .createDate(coupon.getCreateDate())
                .updateDate(coupon.getUpdateDate())
                .build();
    }

    public List<CouponResponse> toResponse(List<Coupon> coupon) {
        return coupon.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
