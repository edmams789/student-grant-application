package com.borisov.subsidyApplication;

import com.borisov.subsidyApplication.validator.ChildrenValidator;
import com.borisov.subsidyApplication.validator.CityRegisterValidator;
import com.borisov.subsidyApplication.mail.MailSender;
import com.borisov.subsidyApplication.validator.WeddingValidator;
import com.borisov.subsidyApplication.validator.StudentValidator;
import com.borisov.subsidyApplication.dmain.AnswerStudent;
import com.borisov.subsidyApplication.dmain.AnswerWedding;
import com.borisov.subsidyApplication.dmain.AnswerChildren;
import com.borisov.subsidyApplication.dmain.AnswerCityRegister;
import com.borisov.subsidyApplication.dmain.StudentOrder;
import com.borisov.subsidyApplication.validator.ChildrenValidator;
import com.borisov.subsidyApplication.validator.CityRegisterValidator;
import com.borisov.subsidyApplication.validator.StudentValidator;
import com.borisov.subsidyApplication.validator.StudentValidator;
import com.borisov.subsidyApplication.validator.WeddingValidator;

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

        StudentOrder[] soArray = readStudentOrders();

//        for(int c = 0; c < soArray.length; c++) {
//            System.out.println();
//            checkOneOrder(soArray[c]);
//        }

        for(StudentOrder so : soArray) {
            System.out.println();
            checkOneOrder(so);
        }
    }

    public StudentOrder[] readStudentOrders() {
        StudentOrder[] soArray = new StudentOrder[3];

        for (int c = 0; c < soArray.length; c++) {
            soArray[c] = SaveStudentOrder.buildStudentOrder(c);
        }
        return soArray;
    }
    
    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);

        AnswerWedding wedAnswer = checkWedding(so);
        AnswerChildren childAnswer = checkChildren(so);
        AnswerStudent studentAnswer = checkStudent(so);

        sendMail(so);
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
