package com.borisov.subsidyApplication.dao;

import com.borisov.subsidyApplication.config.Config;
import com.borisov.subsidyApplication.domain.PassportOffice;
import com.borisov.subsidyApplication.domain.RegisterOffice;
import com.borisov.subsidyApplication.domain.Street;
import com.borisov.subsidyApplication.exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {

            private static final String GET_STREET = 
                "SELECT street_code, street_name FROM jc_street WHERE UPPER(street_name) LIKE UPPER( ? )";
            
            private static final String GET_PASSPORT = 
                "SELECT * FROM jc_passport_office WHERE p_office_area_id = ?";
            
            private static final String GET_REGISTER = 
                "SELECT * FROM jc_register_office WHERE r_office_area_id = ?";
    
    private Connection getConnection() throws SQLException {
        //Подключаемся к базе
        Connection con = DriverManager.getConnection(
                    Config.getProperty(Config.DB_URL), 
                    Config.getProperty(Config.DB_LOGIN), 
                    Config.getProperty(Config.DB_PASSWORD));
        return con;
    }
            @Override
    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> result = new LinkedList<>();
        
        try (Connection con = getConnection();          
            //Создаём запрос
                    //более лучший вариант
  //PreparedStatement - обладает свойством котор. позволяют ему устанавливать параметры                        
            PreparedStatement stmt = con.prepareStatement(GET_STREET)) {  
    
 
            stmt.setString(1, "%" + pattern + "%"); // в запросе (GET_STREET) на 1-й параметр (?) устанавлив. паттерн
            
            //Выполняем запрос
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<PassportOffice> findPassportOffices(String areaId) throws DaoException {
               List<PassportOffice> result = new LinkedList<>();
        
        try (Connection con = getConnection();                             
            PreparedStatement stmt = con.prepareStatement(GET_PASSPORT)) {      
 
            stmt.setString(1, areaId);
            
            //Выполняем запрос
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PassportOffice str = new PassportOffice(rs.getLong("p_office_id"), 
                                                                        rs.getString("p_office_area_id"), 
                                                                        rs.getString("p_office_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException {
                       List<RegisterOffice> result = new LinkedList<>();
        
        try (Connection con = getConnection();                             
            PreparedStatement stmt = con.prepareStatement(GET_REGISTER)) {      
 
            stmt.setString(1, areaId);
            
            //Выполняем запрос
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RegisterOffice str = new RegisterOffice(rs.getLong("r_office_id"), 
                                                                        rs.getString("r_office_area_id"), 
                                                                        rs.getString("r_office_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }
}
