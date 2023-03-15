package edu.sabanciuniv.validationservice.service;

import edu.sabanciuniv.validationservice.model.CreditCardValidationRequest;
import edu.sabanciuniv.validationservice.model.CreditCardValidationResponse;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    public CreditCardValidationResponse validateCreditCardNumber(CreditCardValidationRequest request) {

        int nDigits = String.valueOf(request.getCardNumber()).length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {
            int d = String.valueOf(request.getCardNumber()).charAt(i) - '0';
            if (isSecond)
                d = d * 2;
            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }

        boolean result = nSum % 10 == 0;
        return new CreditCardValidationResponse(result);
    }

}
