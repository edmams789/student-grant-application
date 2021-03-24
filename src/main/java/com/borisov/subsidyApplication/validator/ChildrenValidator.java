package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.dmain.AnswerChildren;
import com.borisov.subsidyApplication.dmain.StudentOrder;

public class ChildrenValidator {

    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running");
        return new AnswerChildren();
    }
}
