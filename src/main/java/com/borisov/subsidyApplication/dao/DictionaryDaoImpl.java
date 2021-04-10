package com.borisov.subsidyApplication.dao;

import com.borisov.subsidyApplication.domain.Street;
import com.borisov.subsidyApplication.exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {

            private final static String GET_STREET = 
                "SELECT street_code, street_name FROM jc_street WHERE UPPER (street_name) LIKE UPPER(?)";
    
    private Connection getConnection() throws SQLException {
        //Подключаемся к базе
//Class.forName("org.postgresql.Driver"); //регистрация драйвера в подсистеме jdbc - до 4 версии
        Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jc_student", "postgres", "password");
        return con;
    }

            @Override
    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> result = new LinkedList<>();
        
        try (Connection con = getConnection();          
            //Создаём запрос
//            Statement stmt = con.createStatement()) {  
                    PreparedStatement stmt = con.prepareStatement(GET_STREET)) {  //более лучший вариант
 //PreparedStatement - обладает свойством котор. позволяют ему устанавливать параметры         
 
            stmt.setString(1, "%" + pattern + "%");// в запросе (GET_STREET) на 1-й параметр (?) устанавлив. паттерн
            
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
}
