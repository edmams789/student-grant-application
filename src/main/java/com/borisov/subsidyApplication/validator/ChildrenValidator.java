package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.domain.AnswerChildren;
import com.borisov.subsidyApplication.domain.StudentOrder;

public class ChildrenValidator {

    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running");
        return new AnswerChildren();
    }
}
