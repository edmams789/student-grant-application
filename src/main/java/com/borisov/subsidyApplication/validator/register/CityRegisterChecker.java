package com.borisov.subsidyApplication.validator.register;

import com.borisov.subsidyApplication.domain.CityRegisterCheckerResponse;
import com.borisov.subsidyApplication.domain.Person;
import com.borisov.subsidyApplication.exception.CityRegisterException;

public interface CityRegisterChecker {
    
    CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException;
}
