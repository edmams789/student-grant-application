package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.dmain.CityRegisterCheckerResponse;
import com.borisov.subsidyApplication.dmain.Person;
import com.borisov.subsidyApplication.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    
        public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException{
        return null;
    }
}
