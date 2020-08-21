package com.samsung.samsungevaluationapi.usecase;

import java.util.ArrayList;
import java.util.List;

import com.samsung.samsungevaluationapi.domain.currency.CurrencyClient;
import com.samsung.samsungevaluationapi.domain.currency.CurrencyClientResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCurrencies {

    @Autowired
    private CurrencyClient client;

    public List<CurrencyClientResponseDto> execute() {  

        return client.findAll().orElse(new ArrayList<>());
    }    
}