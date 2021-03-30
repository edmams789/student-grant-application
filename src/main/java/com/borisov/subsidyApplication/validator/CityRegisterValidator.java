package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.validator.register.RealCityRegisterChecker;
import com.borisov.subsidyApplication.validator.register.CityRegisterChecker;
import com.borisov.subsidyApplication.domain.register.AnswerCityRegister;
import com.borisov.subsidyApplication.domain.Child;
import com.borisov.subsidyApplication.domain.Person;
import com.borisov.subsidyApplication.domain.register.CityRegisterResponse;
import com.borisov.subsidyApplication.domain.StudentOrder;
import com.borisov.subsidyApplication.domain.register.AnswerCityRegisterItem;
import com.borisov.subsidyApplication.exception.CityRegisterException;
import java.util.Iterator;
import java.util.List;

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
        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));

        for (Child child : so.getChildren()) {
            ans.addItem(checkPerson(child));
        }
        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        try {
            CityRegisterResponse cans = personChecker.checkPerson(person);
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
