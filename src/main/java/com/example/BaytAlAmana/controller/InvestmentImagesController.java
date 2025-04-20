package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.dto.InvestmentImagesDTO;
import com.example.BaytAlAmana.service.InvestmentImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/baytalamana")
@CrossOrigin(origins = "http://localhost:4200")
public class InvestmentImagesController {

    @Autowired
    InvestmentImagesService investmentImagesService;

    @GetMapping("investment-images")
    public ResponseEntity<List<InvestmentImagesDTO>> getAllInvestmentUpdates(){
        return ResponseEntity.ok().body(investmentImagesService.getAllInvestmentImages());
    }

    @GetMapping("investment-image/{id}")
    public ResponseEntity<InvestmentImagesDTO> getInvestmentUpdateById(@PathVariable int id){
        return ResponseEntity.ok().body(investmentImagesService.getInvestmentImageById(id));
    }

    @PostMapping("investment-image")
    public ResponseEntity<InvestmentImagesDTO> createInvestmentUpdate(@RequestBody InvestmentImagesDTO investmentImagesDto){
        return ResponseEntity.ok().body(investmentImagesService.createInvestmentImage(investmentImagesDto));
    }

    @PutMapping("investment-image/{id}")
    public ResponseEntity<InvestmentImagesDTO> updateInvestmentImages(@PathVariable int id, @RequestBody InvestmentImagesDTO investmentImagesDto){
        return ResponseEntity.ok().body(investmentImagesService.updateInvestmentImage(id, investmentImagesDto));
    }

    @DeleteMapping("investment-image/{id}")
    public ResponseEntity<Boolean> deleteInvestmentUpdate(@PathVariable int id) {
        return ResponseEntity.ok().body(investmentImagesService.deleteInvestmentImage(id));
    }
}
