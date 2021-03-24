package com.borisov.subsidyApplication;

import com.borisov.subsidyApplication.dmain.Adult;
import com.borisov.subsidyApplication.dmain.StudentOrder;

public class SaveStudentOrder {

    public static void main(String[] args) {
        buildStudentOrder();
        
//        StudentOrder so = new StudentOrder();
//        System.out.println("SaveStudentOrder is running");
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder");

        return answer;
    }

    static StudentOrder buildStudentOrder() {
        StudentOrder so = new StudentOrder();
        
        Adult husband = new Adult();
        
//        husband.setGivenName("Андрей");
//        husband.setSurname("Petrov");
//        husband.setPassportNumber("123456");
//        so.setHusband(husband);
//        
//        String ans = husband.getPersonString();
//        System.out.println(ans);

        return so;
    }
}
