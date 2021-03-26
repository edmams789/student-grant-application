package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.dmain.CityRegisterCheckerResponse;
import com.borisov.subsidyApplication.dmain.Person;

public interface CityRegisterChecker {
    
    CityRegisterCheckerResponse checkPerson(Person person);
}
