package com.borisov.subsidyApplication.dao;

import com.borisov.subsidyApplication.domain.CountryArea;
import com.borisov.subsidyApplication.domain.PassportOffice;
import com.borisov.subsidyApplication.domain.RegisterOffice;
import com.borisov.subsidyApplication.domain.Street;
import com.borisov.subsidyApplication.exception.DaoException;
import java.util.List;

public interface DictionaryDao {
    
    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffices(String areaId) throws DaoException;
    List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException;
    List<CountryArea> findAreas(String areaId) throws DaoException;
}
