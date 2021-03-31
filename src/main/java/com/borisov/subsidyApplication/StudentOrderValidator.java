package com.borisov.subsidyApplication;

import com.borisov.subsidyApplication.validator.ChildrenValidator;
import com.borisov.subsidyApplication.validator.CityRegisterValidator;
import com.borisov.subsidyApplication.mail.MailSender;
import com.borisov.subsidyApplication.validator.WeddingValidator;
import com.borisov.subsidyApplication.validator.StudentValidator;
import com.borisov.subsidyApplication.domain.AnswerStudent;
import com.borisov.subsidyApplication.domain.AnswerWedding;
import com.borisov.subsidyApplication.domain.AnswerChildren;
import com.borisov.subsidyApplication.domain.register.AnswerCityRegister;
import com.borisov.subsidyApplication.domain.StudentOrder;
import com.borisov.subsidyApplication.validator.ChildrenValidator;
import com.borisov.subsidyApplication.validator.CityRegisterValidator;
import com.borisov.subsidyApplication.validator.StudentValidator;
import com.borisov.subsidyApplication.validator.StudentValidator;
import com.borisov.subsidyApplication.validator.WeddingValidator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterValidator;
    private WeddingValidator weddingValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterValidator = new CityRegisterValidator();
        weddingValidator = new WeddingValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {

        List<StudentOrder> soList = readStudentOrders();

        for(StudentOrder so : soList) {
            checkOneOrder(so);
        }
    }

    public List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();

        for (int c = 0; c < 5; c++) {
            StudentOrder so= SaveStudentOrder.buildStudentOrder(c);
            soList.add(so);
        }
        return soList;
    }
    
    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);

//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);

//        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterValidator.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingValidator.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenValidator.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentValidator.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}
