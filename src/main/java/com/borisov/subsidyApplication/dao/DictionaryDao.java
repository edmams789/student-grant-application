package com.borisov.subsidyApplication.dao;

import com.borisov.subsidyApplication.domain.Street;
import com.borisov.subsidyApplication.exception.DaoException;
import java.util.List;

public interface DictionaryDao {
    
    List<Street> findStreets(String pattern) throws DaoException;
}
