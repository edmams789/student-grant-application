package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.dmain.CityRegisterCheckerResponse;
import com.borisov.subsidyApplication.dmain.Person;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    
        public CityRegisterCheckerResponse checkPerson(Person person) {
        return null;
    }
}
