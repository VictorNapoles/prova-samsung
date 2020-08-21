package com.samsung.samsungevaluationapi.controller.currency.dto;

import com.samsung.samsungevaluationapi.domain.currency.CurrencyClientResponseDto;

import org.springframework.beans.BeanUtils;

public class CurrencyResponseDto {
    
    private Long currencyId;
    private String currencyCode;
    private String currencyDesc;

    public CurrencyResponseDto(CurrencyClientResponseDto clientResponseDto){
        
        if(clientResponseDto != null){
            BeanUtils.copyProperties(clientResponseDto, this);
        }
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
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
    
}