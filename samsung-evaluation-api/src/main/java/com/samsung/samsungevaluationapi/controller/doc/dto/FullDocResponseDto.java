package com.samsung.samsungevaluationapi.controller.doc.dto;

import java.time.LocalDate;
import java.util.Map;

import com.samsung.samsungevaluationapi.usecase.dto.FullDocDto;

import org.springframework.beans.BeanUtils;

public class FullDocResponseDto {

    private String documentNumber;    
    
    private LocalDate documentDate;

    private String currencyCode;
    
    private String currencyDesc;
    
    private  Double documentValue;

    private Map<String, Double> values;   

    public FullDocResponseDto(FullDocDto fullDocDto){
        
        if(fullDocDto != null){
            BeanUtils.copyProperties(fullDocDto, this);
        }        
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyDesc() {
        return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }

    public Double getDocumentValue() {
        return documentValue;
    }

    public void setDocumentValue(Double documentValue) {
        this.documentValue = documentValue;
    }

    public Map<String, Double> getValues() {
        return values;
    }

    public void setValues(Map<String, Double> values) {
        this.values = values;
    }

    /*
    public Double getValueUsd() {
        return valueUsd;
    }

    public void setValueUsd(Double valueUsd) {
        this.valueUsd = valueUsd;
    }

    public Double getValuePen() {
        return valuePen;
    }

    public void setValuePen(Double valuePen) {
        this.valuePen = valuePen;
    }

    public Double getValueBrl() {
        return valueBrl;
    }

    public void setValueBrl(Double valueBrl) {
        this.valueBrl = valueBrl;
    }  
    */ 
    
}

