package com.borisov.subsidyApplication.dao;

import com.borisov.subsidyApplication.domain.Street;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DirectoryDAO {
    
    private Connection getConnection() throws SQLException{
        //Подключаемся к базе
//        Class.forName("org.postgresql.Driver"); //регистрация драйвера в подсистеме jdbc - до 4 версии
        Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jc_student", "postgres", "password");        
        return con;
    }
    
    public List<Street> findStreets(String pattern) throws Exception{
        List<Street> result = new LinkedList<>();
        Connection con = getConnection();
        //Создаём запрос
        Statement stmt = con.createStatement();
//        String sql = "SELECT street_code, street_name FROM jc_street WHERE UPPER (street_name) LIKE UPPER('%firs%')";
        String sql = "SELECT street_code, street_name FROM jc_street WHERE UPPER (street_name) LIKE UPPER('%" + pattern + "%')";
        //Выполняем запрос
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
//            new Street(rs.getLong(1) , rs.getString(2));
            Street str = new Street(rs.getLong("street_code") , rs.getString("street_name"));
            result.add(str);
        }
        return result;
    }
}
