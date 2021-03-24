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

    public static void main(String[] args) {
        checkAll();
    }

//    static void checkAll() {
//
//        while (true) {
//            StudentOrder so = readStudentOrder();
//
//            if (so == null) {
//                return; // выходим из метода
//            } else {
//
//                AnswerCityRegister cityAnswer = checkCityRegister(so);
//                AnswerWedding wedAnswer = checkWedding(so);
//                AnswerChildren childAnswer = checkChildren(so);
//                AnswerStudent studentAnswer = checkStudent(so);
//
//                sendMail(so);
//            }
//        }
//    }
//    static void checkAll() {
//        StudentOrder so = readStudentOrder();
//        while (so != null) {
//
//                AnswerCityRegister cityAnswer = checkCityRegister(so);
//                AnswerWedding wedAnswer = checkWedding(so);
//                AnswerChildren childAnswer = checkChildren(so);
//                AnswerStudent studentAnswer = checkStudent(so);
//
//                sendMail(so);
//                so = readStudentOrder();            
//        }
//    }
    static void checkAll() {

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

    static StudentOrder readStudentOrder() {
        StudentOrder so = new StudentOrder();
        return so;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        CityRegisterValidator crv1 = new CityRegisterValidator();
//        crv1.hostName = "Host1";
//        crv1.login = "Login1";
//        crv1.password = "Password1";
        AnswerCityRegister acr1 = crv1.checkCityRegister(so);
        return acr1;
    }

    static AnswerWedding checkWedding(StudentOrder so) {
        WeddingValidator wed = new WeddingValidator();
        return wed.checkWedding(so);
    }

    static AnswerChildren checkChildren(StudentOrder so) {
        ChildrenValidator child = new ChildrenValidator();
        return child.checkChildren(so);
    }

    static AnswerStudent checkStudent(StudentOrder so) {
        StudentValidator student = new StudentValidator();
        return student.checkStudent(so);
    }

    static void sendMail(StudentOrder so) {
        new MailSender().sendMail(so);
    }
}
