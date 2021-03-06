package com.allstate.services;


import com.allstate.entities.Driver;
import com.allstate.enums.Gender;
import com.allstate.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverService {
    private IDriverRepository driverRepository;

    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver create(Driver driver){
        return this.driverRepository.save(driver);
    }

    public Driver findById(int id){
        return this.driverRepository.findOne(id);
    }

    public Driver findByName(String name){
        return this.driverRepository.findByName(name);
    }

    public List<Driver> findByGender(Gender gender){
        return this.driverRepository.findByGender(gender);
    }

    void deleteById(int id){
        this.driverRepository.delete(id);
    }

    public Driver addVoliation(Driver driver){

        driver.setViolation(driver.getViolation()+1);

        if(driver.getViolation() > 3){
            driver.setEligible(false);
        }

        return this.driverRepository.save(driver);

    }
}
