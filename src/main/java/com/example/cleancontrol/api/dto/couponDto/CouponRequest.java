package com.example.cleancontrol.api.dto.couponDto;

import lombok.Builder;

@Builder
public record CouponRequest( String name, String description, Double discount, Boolean active,
        Integer enterpriseId, Integer couponTypeId) {

}
