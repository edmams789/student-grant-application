package com.borisov.subsidyApplication.validator.register;

import com.borisov.subsidyApplication.validator.register.CityRegisterChecker;
import com.borisov.subsidyApplication.dmain.CityRegisterCheckerResponse;
import com.borisov.subsidyApplication.dmain.Person;
import com.borisov.subsidyApplication.exception.CityRegisterException;

public class RealCityRegisterChecker implements CityRegisterChecker{
    
    public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException{
        return null;
    }
}
