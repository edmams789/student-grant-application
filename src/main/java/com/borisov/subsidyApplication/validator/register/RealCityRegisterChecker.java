package com.borisov.subsidyApplication.validator.register;

import com.borisov.subsidyApplication.validator.register.CityRegisterChecker;
import com.borisov.subsidyApplication.domain.CityRegisterCheckerResponse;
import com.borisov.subsidyApplication.domain.Person;
import com.borisov.subsidyApplication.exception.CityRegisterException;

public class RealCityRegisterChecker implements CityRegisterChecker{
    
    public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException{
        return null;
    }
}
