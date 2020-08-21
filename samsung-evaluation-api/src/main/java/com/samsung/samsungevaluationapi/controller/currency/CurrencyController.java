package com.samsung.samsungevaluationapi.controller.currency;

import java.util.List;
import java.util.stream.Collectors;

import com.samsung.samsungevaluationapi.controller.currency.dto.CurrencyResponseDto;
import com.samsung.samsungevaluationapi.domain.currency.CurrencyClientResponseDto;
import com.samsung.samsungevaluationapi.exception.NoContentException;
import com.samsung.samsungevaluationapi.usecase.GetCurrencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency")
public class CurrencyController {

    @Autowired
    private GetCurrencies getCurrencies;

    @GetMapping
    public ResponseEntity<?> getCurrencies(){

        List<CurrencyClientResponseDto> result = getCurrencies.execute();
        
        if(result.isEmpty())
            throw new NoContentException();
        
        List<CurrencyResponseDto> collect = result.stream()
                                                    .map(CurrencyResponseDto::new)
                                                    .collect(Collectors.toList());
        
        return ResponseEntity.ok(collect);       
                
    }
    
}