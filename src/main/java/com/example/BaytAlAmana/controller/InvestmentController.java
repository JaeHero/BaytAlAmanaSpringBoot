package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.entity.InvestmentEntity;
import com.example.BaytAlAmana.models.InvestmentResponse;
import com.example.BaytAlAmana.repo.InvestmentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/investment")
@CrossOrigin(origins = "http://localhost:4200")
public class InvestmentController {

    @Autowired
    InvestmentRepository investmentRepository;

    @GetMapping("/investments")
    public ResponseEntity<List<InvestmentEntity>> getInvestment(){
        List<InvestmentEntity> investments = new ArrayList<InvestmentEntity>();
        Date date = new Date(2025,1,30);

        InvestmentEntity investment = new InvestmentEntity(1,"Indiana University Kokomo","New","2300 S Washington St", 3500, 10000, date, date,6);
        for(int i = 0; i < 9; i++){
            investments.add(investment);
        }
      return ResponseEntity.ok((investments));
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


