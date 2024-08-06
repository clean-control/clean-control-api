package com.example.cleancontrol.api.service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.couponDto.CouponRequest;
import com.example.cleancontrol.api.dto.couponDto.CouponResponse;
import com.example.cleancontrol.api.mapper.CouponMapper;
import com.example.cleancontrol.domain.model.Coupon;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.repository.CouponRepository;
import com.example.cleancontrol.domain.repository.CouponTypeRepository;
import com.example.cleancontrol.domain.repository.EnterpriseRepository;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;
    private final EnterpriseRepository enterpriseRepository;
    private final CouponTypeRepository couponTypeRepository;

    public List<CouponResponse> findAll() {
        try {
            return couponMapper.toResponse(couponRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Error to get coupons");
        }
    }

    public CouponResponse findById(Integer id) {
       try {
            return couponMapper.toResponse(couponRepository.findById(id).get());
        } catch (Exception e) {
            throw new RuntimeException("Error to get coupon");
        }
    }


    public CouponResponse save(CouponRequest couponRequest) {
        try {
            Enterprise enterprise = enterpriseRepository.findById(couponRequest.enterpriseId()).get();
            Coupon coupon = Coupon.builder()
                    .name(couponRequest.name())
                    .description(couponRequest.description())
                    .discount(couponRequest.discount())
                    .active(couponRequest.active())
                    .enterprise(enterprise)
                    .couponType(couponTypeRepository.findById(couponRequest.couponTypeId()).get())
                    .build();
            return couponMapper.toResponse(couponRepository.save(coupon));
        } catch (Exception e) {
            throw new RuntimeException("Error to save coupon");
        }
    }

    public CouponResponse update(Integer id, CouponRequest couponRequest) {
        try {
            Enterprise enterprise = enterpriseRepository.findById(couponRequest.enterpriseId()).get();
            Coupon coupon = couponRepository.findById(id).get();
            coupon.setName(couponRequest.name() != null ? couponRequest.name() : coupon.getName());
            coupon.setDescription(couponRequest.description() != null ? couponRequest.description() : coupon.getDescription());
            coupon.setDiscount(couponRequest.discount() != null ? couponRequest.discount() : coupon.getDiscount());
            coupon.setActive(couponRequest.active()    != null ? couponRequest.active() : coupon.getActive());
            coupon.setEnterprise(enterprise != null ? enterprise : coupon.getEnterprise());
            coupon.setCouponType(couponTypeRepository.findById(couponRequest.couponTypeId()).get() != null ? couponTypeRepository.findById(couponRequest.couponTypeId()).get() : coupon.getCouponType());
            return couponMapper.toResponse(couponRepository.save(coupon));
        } catch (Exception e) {
            throw new RuntimeException("Error to update coupon");
        }
    }


    

    public void delete(Integer id) {
        couponRepository.deleteById(id);
    }

}
