package com.borisov.subsidyApplication.validator.register;

import com.borisov.subsidyApplication.validator.register.CityRegisterChecker;
import com.borisov.subsidyApplication.domain.register.CityRegisterResponse;
import com.borisov.subsidyApplication.domain.Person;
import com.borisov.subsidyApplication.exception.CityRegisterException;
import com.borisov.subsidyApplication.exception.TransportException;

public class RealCityRegisterChecker implements CityRegisterChecker{
    
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {
        return null;
    }
}
