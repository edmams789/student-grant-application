package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.dmain.CityRegisterCheckerResponse;
import com.borisov.subsidyApplication.dmain.Person;
import com.borisov.subsidyApplication.exception.CityRegisterException;

public interface CityRegisterChecker {
    
    CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException;
}
