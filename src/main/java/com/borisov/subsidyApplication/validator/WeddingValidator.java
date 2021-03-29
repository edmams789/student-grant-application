package com.borisov.subsidyApplication.validator;

import com.borisov.subsidyApplication.domain.AnswerWedding;
import com.borisov.subsidyApplication.domain.StudentOrder;

public class WeddingValidator {

    public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding started");
        return new AnswerWedding();
    }
}
