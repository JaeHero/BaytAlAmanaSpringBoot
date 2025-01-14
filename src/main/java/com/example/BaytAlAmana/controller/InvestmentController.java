package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.entity.InvestmentEntity;
import com.example.BaytAlAmana.models.InvestmentResponse;
import com.example.BaytAlAmana.repo.InvestmentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investment")
@CrossOrigin(origins = "http://localhost:4200")
public class InvestmentController {

    @Autowired
    InvestmentRepository investmentRepository;

    @GetMapping("/investments")
    public ResponseEntity<List<InvestmentEntity>> getInvestment(){
        //    System.out.println(investmentRepository.findAll());
      return ResponseEntity.ok((investmentRepository.findAll()));
    }

    @GetMapping("/investments/{id}")
    public ResponseEntity<InvestmentEntity> getInvestmentById(@PathVariable Long id) {
        return investmentRepository.findById(String.valueOf(id))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    }



//    @PostMapping("/createInvestment")
//    public ResponseEntity<InvestmentResponse> createInvestment(){
//
//    }


