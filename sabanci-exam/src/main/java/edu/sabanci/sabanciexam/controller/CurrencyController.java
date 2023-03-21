package edu.sabanci.sabanciexam.controller;

import edu.sabanci.sabanciexam.model.ConversionRequest;
import edu.sabanci.sabanciexam.model.ConversionResponse;
import edu.sabanci.sabanciexam.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CurrencyController {
    @Autowired
    CurrencyService service;

    @GetMapping("/currencies/exchange-rate")
    public double getRate(@RequestParam String source,@RequestParam String target){
        return service.getRate(source, target);
    }

    @PostMapping("/currencies/convert-currency")
    public ConversionResponse convertCurrencies(@RequestBody ConversionRequest request){
        return service.convertCurrencies(request);
    }

    @GetMapping("/currencies")
    public List<ConversionResponse> getConversionList(@RequestParam(required = false) String transactionId,
                                                      @RequestParam(required = false) @DateTimeFormat(pattern = "YYYY/MM/dd") Date transactionDate){
        return service.getConversionList(transactionId, transactionDate);
    }
}
