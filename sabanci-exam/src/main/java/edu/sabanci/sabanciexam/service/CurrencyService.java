package edu.sabanci.sabanciexam.service;

import edu.sabanci.sabanciexam.model.ConversionEntity;
import edu.sabanci.sabanciexam.model.ConversionRequest;
import edu.sabanci.sabanciexam.model.ConversionResponse;
import edu.sabanci.sabanciexam.model.CurrencyEntity;
import edu.sabanci.sabanciexam.repository.ConversionRepository;
import edu.sabanci.sabanciexam.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ConversionRepository conversionRepository;

    public double getRate(String source, String target) {
        CurrencyEntity entity = currencyRepository.findBySourceAndTarget(source, target);

        //List<CurrencyEntity> rates = repository.findAll();

        //for (CurrencyEntity rate : rates) {
        //    if (rate.getSource().equals(source) && rate.getTarget().equals(target)) {
        //        return rate.getRate();
        //    }
        //}
        return entity.getRate();
    }

    public ConversionResponse convertCurrencies(ConversionRequest request) {
        CurrencyEntity entity = currencyRepository.findBySourceAndTarget(request.getSource(), request.getTarget());

        double calculatedAmount = request.getAmount() * entity.getRate();

        ConversionEntity conversionEntity = ConversionEntity.builder()
                .amount(request.getAmount())
                .calculatedAmount(calculatedAmount)
                .transactionId(UUID.randomUUID().toString())
                .transactionDate(LocalDateTime.now())
                .entity(entity)
                .build();

        conversionEntity = conversionRepository.save(conversionEntity);

        ConversionResponse response = ConversionResponse.builder()
                .amount(calculatedAmount)
                .target(request.getTarget())
                .transactionId(conversionEntity.getTransactionId())
                .build();

        return response;

    }

    public List<ConversionResponse> getConversionList(String transactionId, Date transactionDate) {
        ConversionEntity entity = conversionRepository.findByTransactionId(transactionId);
        List<ConversionResponse> responseList = new ArrayList<>();
        responseList.add(ConversionResponse.builder()
                .amount(entity.getCalculatedAmount())
                .target(entity.getEntity().getTarget())
                .transactionId(entity.getTransactionId())
                .build());
        return responseList;
    }
}
