package com.samsung.samsungevaluationapi.usecase;

import java.util.ArrayList;
import java.util.List;

import com.samsung.samsungevaluationapi.domain.quotation.QuotationClient;
import com.samsung.samsungevaluationapi.domain.quotation.QuotationClientResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetQuotations {

    @Autowired
    private QuotationClient client;

    public List<QuotationClientResponseDto> execute() {  

        return client.findAll().orElse(new ArrayList<>());
    }
    
}