package com.example.cleancontrol.dto.couponTypeDto;

import lombok.Builder;

@Builder
public record CouponTypeRequest(Integer id, String name, String description, Boolean active) {

}
