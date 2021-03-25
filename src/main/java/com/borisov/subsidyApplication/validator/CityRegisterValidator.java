package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.dmain.AnswerCityRegister;
import com.borisov.subsidyApplication.dmain.StudentOrder;

public class CityRegisterValidator {
    
    String hostName;
    protected int port;
    String login;
    String password;

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        System.out.println("CityRegister is running: " + hostName + ", " + login + ", " + password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
