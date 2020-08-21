package com.samsung.samsungevaluationapi.controller.doc;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.samsung.samsungevaluationapi.controller.doc.dto.DocResponseDto;
import com.samsung.samsungevaluationapi.controller.doc.dto.FullDocResponseDto;
import com.samsung.samsungevaluationapi.domain.doc.DocClientResponseDto;
import com.samsung.samsungevaluationapi.exception.NoContentException;
import com.samsung.samsungevaluationapi.usecase.GetDocs;
import com.samsung.samsungevaluationapi.usecase.SearchFullDocs;
import com.samsung.samsungevaluationapi.usecase.dto.FullDocDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("docs")
public class DocController {

    @Autowired
    private SearchFullDocs searchFullDocs;

    @Autowired
    private GetDocs getDocs;

    @GetMapping
    public ResponseEntity<?> getDocs(){

        List<DocClientResponseDto> result = getDocs.execute();
        
        if(result.isEmpty())
            throw new NoContentException();
        
        List<DocResponseDto> collect = result.stream()
                                                    .map(DocResponseDto::new)
                                                    .collect(Collectors.toList());
        return ResponseEntity.ok(collect);       
                
    }

    @GetMapping("search")
    public ResponseEntity<?> search(@RequestParam(required = false, defaultValue = "") String documentNumber, 
                                    @RequestParam(required = false, defaultValue = "")String currencyCode, 
                                    @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate, 
                                    @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate endDate){

        List<FullDocDto> result = searchFullDocs.execute(documentNumber, currencyCode, startDate, endDate);
        
        if(result.isEmpty())
            throw new NoContentException();
        
        List<FullDocResponseDto> collect = result.stream()
                                                    .map(FullDocResponseDto::new)
                                                    .collect(Collectors.toList());
        
        return ResponseEntity.ok(collect);       
                
    }
    
}