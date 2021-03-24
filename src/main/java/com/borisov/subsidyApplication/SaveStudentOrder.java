package com.borisov.subsidyApplication;

import com.borisov.subsidyApplication.dmain.StudentOrder;

public class SaveStudentOrder {

    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.sethFirstName("Aleksey");
        so.sethLastName("Petrov");
        so.setwFirstName("Galina");
        so.setwLastName("Petrova");
        
        System.out.println("SaveStudentOrder is running");
        long ans = saveStudentOrder(so);
        System.out.println(ans);

    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder: " + studentOrder.gethFirstName());
        
        return answer;
    }
}
