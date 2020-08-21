package com.samsung.samsungevaluationapi.domain.currency;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${feign.currency.name}", url = "${feign.currency.url}")
public interface CurrencyClient {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Optional<List<CurrencyClientResponseDto>> findAll();
    
}