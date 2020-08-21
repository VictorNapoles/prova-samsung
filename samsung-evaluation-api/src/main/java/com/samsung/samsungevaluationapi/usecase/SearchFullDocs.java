package com.samsung.samsungevaluationapi.usecase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.samsung.samsungevaluationapi.domain.currency.CurrencyClient;
import com.samsung.samsungevaluationapi.domain.currency.CurrencyClientResponseDto;
import com.samsung.samsungevaluationapi.domain.doc.DocClient;
import com.samsung.samsungevaluationapi.domain.doc.DocClientResponseDto;
import com.samsung.samsungevaluationapi.domain.quotation.QuotationClient;
import com.samsung.samsungevaluationapi.domain.quotation.QuotationClientResponseDto;
import com.samsung.samsungevaluationapi.usecase.dto.FullDocDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchFullDocs {

    @Autowired
    private DocClient docClient;

    @Autowired
    private QuotationClient quotationClient; 
    
    @Autowired
    private CurrencyClient currencyClient; 

    public List<FullDocDto> execute(String documentNumber, String currencyCode, LocalDate startDate, LocalDate endDate) {  

        List<CurrencyClientResponseDto> currencies = currencyClient.findAll().orElse(new ArrayList<>());
        List<QuotationClientResponseDto> quotations = quotationClient.findAll().orElse(new ArrayList<>());
        List<DocClientResponseDto> docs = searchDocs(documentNumber, currencyCode, startDate, endDate);

        return docs.stream()
        .map(FullDocDto::new)        
        .map(doc -> {
            
            Map<String, Double> values = getValues(quotations, currencies, doc);
            doc.setValues(values);

            CurrencyClientResponseDto currencyClientResponseDto = currencies.stream().filter(c -> c.getCurrencyCode().equals(doc.getCurrencyCode())).collect(Collectors.toList()).get(0);
            doc.setCurrencyDesc(currencyClientResponseDto.getCurrencyDesc());

            return doc;   
            
        }).collect(Collectors.toList());
    }

    private Map<String, Double> getValues(List<QuotationClientResponseDto> quotations,
            List<CurrencyClientResponseDto> currencies, FullDocDto doc) {
        
        Map<String, Double> values = new HashMap<>();
        
        for (CurrencyClientResponseDto currency : currencies) {
            if(currency.getCurrencyCode().equals(doc.getCurrencyCode())){
                values.put(currency.getCurrencyCode(), doc.getDocumentValue());
            }else{
                QuotationClientResponseDto quotation = getQuotation(quotations, doc, currency);
                values.put(currency.getCurrencyCode(), doc.getDocumentValue() * Double.valueOf(quotation.getCotacao()));
            }
        }
        return values;
    }

    private QuotationClientResponseDto getQuotation(List<QuotationClientResponseDto> quotations, FullDocDto doc, CurrencyClientResponseDto c) {
        
        List<QuotationClientResponseDto> foundQuotations = quotations.stream().filter(q -> 
            (q.getDataHoraCotacao().isBefore(doc.getDocumentDate()) || q.getDataHoraCotacao().equals(doc.getDocumentDate()))  
            && q.getFromCurrencyCode().equals(doc.getCurrencyCode())
            && q.getToCurrencyCode().equals(c.getCurrencyCode()))
        .collect(Collectors.toList());

        
        QuotationClientResponseDto quotation = null;
        
        for (QuotationClientResponseDto foundQuotation : foundQuotations) {
            if(quotation == null || foundQuotation.getDataHoraCotacao().isAfter(quotation.getDataHoraCotacao()))
                quotation = foundQuotation;
        }
        
        return quotation;
    }

    private List<DocClientResponseDto> searchDocs(String documentNumber, String currencyCode, LocalDate startDate,
            LocalDate endDate) {
        List<DocClientResponseDto> docs = docClient.findAll().orElse(new ArrayList<>())
            .stream()
            .filter(doc ->{

                return (documentNumber.isEmpty() || doc.getDocumentNumber().equals(documentNumber))
                        && (currencyCode.isEmpty() || doc.getCurrencyCode().equals(currencyCode))
                        && (startDate == null || (doc.getDocumentDate().isAfter(startDate) || doc.getDocumentDate().equals(startDate)))
                        && (endDate == null || (doc.getDocumentDate().isBefore(endDate) || doc.getDocumentDate().equals(endDate)));

            }).collect(Collectors.toList());

        return docs;
    }
    
}