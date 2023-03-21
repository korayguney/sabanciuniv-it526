package edu.sabanci.sabanciexam.initializer;

import edu.sabanci.sabanciexam.model.CurrencyEntity;
import edu.sabanci.sabanciexam.model.CurrencyModel;
import edu.sabanci.sabanciexam.model.CurrencySubModel;
import edu.sabanci.sabanciexam.model.Rate;
import edu.sabanci.sabanciexam.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyExchangeDataLoader implements CommandLineRunner {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CurrencyRepository repository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        CurrencyModel model = restTemplate.getForObject("https://mocki.io/v1/1e26abb9-d48e-42b9-995d-54cddecfbae2",
                CurrencyModel.class);

        for (CurrencySubModel currency : model.getCurrencies()) {
            for (Rate rate : currency.getRates()) {
                CurrencyEntity entity = CurrencyEntity.builder()
                        .source(currency.getSource())
                        .target(rate.getTarget())
                        .rate(rate.getRate())
                        .build();
                repository.save(entity);
            }
        }
    }

    // @Scheduled(fixedDelay = 2000)
    // public void test(){
    //     System.out.println("Test...");
    // }
}
