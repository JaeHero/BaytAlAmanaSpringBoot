package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.dto.InvestmentDTO;
import com.example.BaytAlAmana.entity.InvestmentEntity;
import com.example.BaytAlAmana.mapper.InvestmentMapper;
import com.example.BaytAlAmana.models.InvestmentResponse;
import com.example.BaytAlAmana.repo.InvestmentRepository;
import com.example.BaytAlAmana.service.InvestmentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/baytalamana")
@CrossOrigin(origins = "http://localhost:4200")
public class InvestmentController {

    @Autowired
    InvestmentService investmentService;

    @GetMapping("investments")
    public ResponseEntity<List<InvestmentDTO>> getAllInvestments(){
        return ResponseEntity.ok().body(investmentService.getAllInvestments());
    }

    @PostMapping("investment")
    public ResponseEntity<InvestmentDTO> createInvestment(@RequestBody InvestmentDTO investmentDTO){
        return ResponseEntity.ok().body(investmentService.createInvestment(investmentDTO));
    }

    @GetMapping("investment/{id}")
    public ResponseEntity<InvestmentDTO> getInvestmentById(@PathVariable int id){
        return ResponseEntity.ok().body(investmentService.getInvestmentById(id));
    }

    @PutMapping("investment/{id}")
    public ResponseEntity<InvestmentDTO> updateInvestment(@PathVariable int id, @RequestBody InvestmentDTO investmentDTO){
        return ResponseEntity.ok().body(investmentService.updateInvestment(id, investmentDTO));
    }

    @DeleteMapping("investment/{id}")
    public ResponseEntity<Boolean> deleteInvestment(@PathVariable int id){
        return ResponseEntity.ok().body(investmentService.deleteInvestment(id));
    }



    }


