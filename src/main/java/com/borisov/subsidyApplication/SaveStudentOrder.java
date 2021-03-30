package com.borisov.subsidyApplication;

import com.borisov.subsidyApplication.domain.Address;
import com.borisov.subsidyApplication.domain.Adult;
import com.borisov.subsidyApplication.domain.Child;
import com.borisov.subsidyApplication.domain.StudentOrder;
import java.time.LocalDate;

public class SaveStudentOrder {

    public static void main(String[] args) {
        buildStudentOrder(10);
        
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

    static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);          
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        so.setMarriageOffice("Отдел ЗАГС");
        
        Address address = new Address("195000", "Заневский пр.", "12", "", "142");
        
        //Муж
        Adult husband = new Adult("Petrov", "Viktor", "Sergeevich", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment("Office police № " + id);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        //Жена
        Adult wife = new Adult("Petrova", "Veronika", "Alekseevna", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        wife.setIssueDepartment("Office police № " + id);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        //Ребёнок
        Child child1 = new Child("Petrova", "Irina", "Viktorovna", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + 300000 + id);
        child1.setIssueDate(LocalDate.of(2018, 7, 19));        
        child1.setIssueDepartment("Отдел ЗАГС № " + id);
        child1.setAddress(address);
        //Ребёнок
        Child child2 = new Child("Petrov", "Evgeniy", "Viktorovich", LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + 400000 + id);
        child2.setIssueDate(LocalDate.of(2018, 7, 19));        
        child2.setIssueDepartment("Отдел ЗАГС № " + id);
        child2.setAddress(address);
        
        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        
        return so;
    }
    
    static void printStudentOrder(StudentOrder stOr) {
        System.out.println(stOr.getStudentOrderId());        
    }
}
