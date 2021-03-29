package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.validator.register.RealCityRegisterChecker;
import com.borisov.subsidyApplication.validator.register.CityRegisterChecker;
import com.borisov.subsidyApplication.domain.AnswerCityRegister;
import com.borisov.subsidyApplication.domain.Child;
import com.borisov.subsidyApplication.domain.CityRegisterCheckerResponse;
import com.borisov.subsidyApplication.domain.StudentOrder;
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
        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());
            //1 var
            List<Child> children = so.getChildren();            
            for(int i = 0; i < so.getChildren().size(); i++) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(children.get(i));
            }
            //2 var
            for(Iterator<Child> it = children.iterator(); it.hasNext(); ) {
                Child child = it.next();
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }
            //3 var
            for(Child child : children) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }
            
        } catch(CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }        
        
        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
