package com.samsung.samsungevaluationapi.domain.quotation;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${feign.quotation.name}", url = "${feign.quotation.url}")
public interface QuotationClient {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Optional<List<QuotationClientResponseDto>> findAll();
    
}