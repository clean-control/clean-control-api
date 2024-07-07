package com.example.cleancontrol.api.dto.couponTypeDto;

import lombok.Builder;

@Builder
public record CouponTypeRequest(Integer id, String name, String description, Boolean active) {

}
