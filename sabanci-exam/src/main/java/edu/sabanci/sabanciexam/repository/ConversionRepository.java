package edu.sabanci.sabanciexam.repository;

import edu.sabanci.sabanciexam.model.ConversionEntity;
import edu.sabanci.sabanciexam.model.ConversionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversionRepository extends JpaRepository<ConversionEntity, Long> {

    ConversionEntity findByTransactionId(String transactionId);

}
