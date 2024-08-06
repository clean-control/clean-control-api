package com.example.cleancontrol.api.dto.eventServicesEnterpriseDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.EventEnterprise;
import com.example.cleancontrol.domain.model.EventServicesEnterprise;
import com.example.cleancontrol.domain.model.Product;
import com.example.cleancontrol.domain.model.Services;

import lombok.Builder;

@Builder
public record EventServicesEnterpriseResponse(Integer id, EventEnterprise eventEnterprise, Services services, Product product, LocalDateTime createDate, LocalDateTime updateDate) {

}