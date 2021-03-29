package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.domain.AnswerStudent;
import com.borisov.subsidyApplication.domain.StudentOrder;

public class StudentValidator {

    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Students are running");
        return new AnswerStudent();
    }
}
