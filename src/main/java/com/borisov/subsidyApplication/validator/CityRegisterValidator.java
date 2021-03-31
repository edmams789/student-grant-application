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
import com.borisov.subsidyApplication.exception.TransportException;
import java.util.Iterator;
import java.util.List;

public class CityRegisterValidator {

    public static final String IN_CODE = "NO_GRN";

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
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting() ? AnswerCityRegisterItem.CityStatus.YES : AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException | TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            if (ex instanceof CityRegisterException) {
                CityRegisterException e = (CityRegisterException) ex;
                error = new AnswerCityRegisterItem.CityError(e.getCode(), ex.getMessage());
            }
            if (ex instanceof TransportException) {
                TransportException e = (TransportException) ex;
                error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
            }
        }
        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status, person, error);

        return ans;
    }
}
