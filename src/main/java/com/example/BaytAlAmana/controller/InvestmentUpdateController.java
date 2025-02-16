package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.dto.InvestmentUpdateDto;
import com.example.BaytAlAmana.service.InvestmentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/baytalamana")
@CrossOrigin(origins = "http://localhost:4200")
public class InvestmentUpdateController {

    @Autowired
    InvestmentUpdateService investmentUpdateService;

    @GetMapping("investment-updates")
    public ResponseEntity<List<InvestmentUpdateDto>> getAllInvestmentUpdates(){
        return ResponseEntity.ok().body(investmentUpdateService.getAllInvestmentUpdates());
    }
    @GetMapping("investment-update/{id}")
    public ResponseEntity<InvestmentUpdateDto> getInvestmentUpdateById(@PathVariable int id){
        return ResponseEntity.ok().body(investmentUpdateService.getInvestmentUpdateById(id));
    }
    @PostMapping("investment-update")
    public ResponseEntity<InvestmentUpdateDto> createInvestmentUpdate(@RequestBody InvestmentUpdateDto investmentUpdateDto){
        return ResponseEntity.ok().body(investmentUpdateService.createInvestmentUpdate(investmentUpdateDto));
    }
    @PutMapping("investment-update/{id}")
    public ResponseEntity<InvestmentUpdateDto> updateInvestmentUpdate(@PathVariable int id, @RequestBody InvestmentUpdateDto investmentUpdateDto){
        return ResponseEntity.ok().body(investmentUpdateService.updateInvestmentUpdate(id, investmentUpdateDto));
    }
    @DeleteMapping("investment-update/{id}")
    public ResponseEntity<Boolean> deleteInvestmentUpdate(@PathVariable int id){
        return ResponseEntity.ok().body(investmentUpdateService.deleteInvestmentUpdate(id));
    }
}
