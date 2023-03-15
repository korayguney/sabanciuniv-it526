package edu.sabanciuniv.validationservice.controller;

import edu.sabanciuniv.validationservice.model.CreditCardValidationRequest;
import edu.sabanciuniv.validationservice.model.CreditCardValidationResponse;
import edu.sabanciuniv.validationservice.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardService service;

    @PostMapping("/creditcards/validate")
    private CreditCardValidationResponse validateCreditCardNumber(@RequestBody CreditCardValidationRequest request) {
        return service.validateCreditCardNumber(request);
    }

}
