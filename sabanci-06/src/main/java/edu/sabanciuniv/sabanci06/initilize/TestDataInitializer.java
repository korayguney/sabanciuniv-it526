package edu.sabanciuniv.sabanci06.initilize;

import edu.sabanciuniv.sabanci06.model.*;
import edu.sabanciuniv.sabanci06.repository.AccidentRepository;
import edu.sabanciuniv.sabanci06.repository.CustomerRepository;
import edu.sabanciuniv.sabanci06.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.accessibility.AccessibleRelation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestDataInitializer implements CommandLineRunner {

 //   private final static Logger logger = LoggerFactory.getLogger(TestDataInitializer.class);

    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;
    private final AccidentRepository accidentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 0) {
            Customer customer1 = new Customer("Koray Guney", "Istanbul", 321562365123L, "111111111");
            Customer customer2 = new Customer("Ali Veli", "Ankara", 32132143246L, "2222222222");
            Customer customer3 = new Customer("Ayse Simsek", "Edirne", 6452533241L, "3333333333");

            Vehicle car1 = new Car("Porsche Cayenne", 2020, "34VG5677", "Red");
            Vehicle car2 = new Car("Toyota Corolla", 2017, "08HG234", "Black");
            Vehicle moto1 = new Motorcycle("Suzuki", 2020, "65NN322", 120.0);
            Vehicle moto2 = new Motorcycle("Yamaha", 2017, "08TT122", 340.0);
            Vehicle moto3 = new Motorcycle("Harley Davidson", 2013, "34VG111", 420.0);

            car1.setCustomer(customer1);
            car2.setCustomer(customer2);
            moto1.setCustomer(customer3);
            moto2.setCustomer(customer3);
            moto3.setCustomer(customer1);

            Accident accident1 = new Accident(LocalDate.of(2021, Month.AUGUST, 12));
            Accident accident2 = new Accident(LocalDate.of(2020, Month.JUNE, 24));
            Accident accident3 = new Accident(LocalDate.of(2019, Month.MARCH, 4));

            car1.getAccidentList().add(accident1);
            car2.getAccidentList().add(accident1);
            moto1.getAccidentList().add(accident2);
            moto1.getAccidentList().add(accident3);
            moto3.getAccidentList().add(accident2);

            vehicleRepository.save(car1);
            vehicleRepository.save(car2);
            vehicleRepository.save(moto1);
            vehicleRepository.save(moto2);
            vehicleRepository.save(moto3);

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);

            accidentRepository.save(accident1);
            accidentRepository.save(accident2);
            accidentRepository.save(accident3);

            log.info("All data saved!");

        }
    }
}
