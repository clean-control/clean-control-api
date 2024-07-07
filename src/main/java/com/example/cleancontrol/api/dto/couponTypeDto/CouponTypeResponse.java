package com.example.cleancontrol.api.dto.couponTypeDto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record CouponTypeResponse(Integer id, String name, String description, Boolean active, LocalDateTime createDate,
        LocalDateTime updateDate) {

}
