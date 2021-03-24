package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.dmain.AnswerStudent;
import com.borisov.subsidyApplication.dmain.StudentOrder;

public class StudentValidator {

    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Students are running");
        return new AnswerStudent();
    }
}
