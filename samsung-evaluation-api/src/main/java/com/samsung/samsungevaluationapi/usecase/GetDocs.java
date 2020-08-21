package com.samsung.samsungevaluationapi.usecase;

import java.util.ArrayList;
import java.util.List;

import com.samsung.samsungevaluationapi.domain.doc.DocClient;
import com.samsung.samsungevaluationapi.domain.doc.DocClientResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetDocs {

    @Autowired
    private DocClient client;

    public List<DocClientResponseDto> execute() {  

        return client.findAll().orElse(new ArrayList<>());
    }
    
}