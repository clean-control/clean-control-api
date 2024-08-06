package com.example.cleancontrol.api.mapper;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.couponTypeDto.*;
import com.example.cleancontrol.domain.model.CouponType;
import com.example.cleancontrol.domain.repository.CouponTypeRepository;

@Component
@RequiredArgsConstructor
public class CouponTypeMapper {


    private final CouponTypeRepository couponTypeRepository;

    public List<CouponTypeResponse> toResponse(List<CouponType> couponType) {
        return couponType.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public CouponTypeResponse toResponse(CouponType couponType) {
        return CouponTypeResponse.builder()
                .id(couponType.getId())
                .name(couponType.getName())
                .description(couponType.getDescription())
                .active(couponType.getActive())
                .createDate(couponType.getCreateDate())
                .updateDate(couponType.getUpdateDate())
                .build();
    }

    public CouponType toEntity(CouponTypeRequest couponTypeRequest) {
        return CouponType.builder()
                .name(couponTypeRequest.name())
                .description(couponTypeRequest.description())
                .active(couponTypeRequest.active())
                .build();
    }

    public CouponType toEntity(Integer id, CouponTypeRequest couponTypeRequest) {
        CouponType couponType = couponTypeRepository.findById(id).get();
        couponType.setName(couponTypeRequest.name());
        couponType.setDescription(couponTypeRequest.description());
        couponType.setActive(couponTypeRequest.active());
        return couponType;
    }
}
