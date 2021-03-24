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

        while (true) {
            StudentOrder so = readStudentOrder();
//            System.out.println("Start");
            if (so == null) {
                break;
            }
//            System.out.println("Finish");

            AnswerCityRegister cityAnswer = checkCityRegister(so);
            if (!cityAnswer.success) {
//                continue;
                break;
            }
            AnswerWedding wedAnswer = checkWedding(so);
            AnswerChildren childAnswer = checkChildren(so);
            AnswerStudent studentAnswer = checkStudent(so);

            sendMail(so);
        }
//        System.out.println("Finish 2");
    }

    public StudentOrder readStudentOrder() {
        StudentOrder so = new StudentOrder();
        return so;
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
