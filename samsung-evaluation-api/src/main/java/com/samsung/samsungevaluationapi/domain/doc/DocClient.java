package com.samsung.samsungevaluationapi.domain.doc;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${feign.doc.name}", url = "${feign.doc.url}")
public interface DocClient {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Optional<List<DocClientResponseDto>> findAll();
    
}