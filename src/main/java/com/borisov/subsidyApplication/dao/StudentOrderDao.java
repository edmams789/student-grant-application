package com.borisov.subsidyApplication.dao;

import com.borisov.subsidyApplication.domain.StudentOrder;
import com.borisov.subsidyApplication.exception.DaoException;

public interface StudentOrderDao {
    
    Long saveStudentOrder(StudentOrder so) throws DaoException;
}
