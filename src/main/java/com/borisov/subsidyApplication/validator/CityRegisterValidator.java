package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.dmain.AnswerCityRegister;
import com.borisov.subsidyApplication.dmain.CityRegisterCheckerResponse;
import com.borisov.subsidyApplication.dmain.StudentOrder;
import com.borisov.subsidyApplication.exception.CityRegisterException;

public class CityRegisterValidator {
    
    private String hostName;
    private int port;
    private String login;
    private String password;
    
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new RealCityRegisterChecker();
    }    

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());
            CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getChild());
        } catch(CityRegisterException ex) {
            ex.printStackTrace();
        }        
        
        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
