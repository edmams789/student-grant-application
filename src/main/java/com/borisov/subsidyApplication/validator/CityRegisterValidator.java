package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.dmain.AnswerCityRegister;
import com.borisov.subsidyApplication.dmain.StudentOrder;

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
        personChecker.checkPerson(so.getHusband());
        personChecker.checkPerson(so.getWife());
        personChecker.checkPerson(so.getChild());
        
        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
