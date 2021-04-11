package com.borisov.subsidyApplication.dao;

import com.borisov.subsidyApplication.config.Config;
import com.borisov.subsidyApplication.domain.Street;
import com.borisov.subsidyApplication.domain.StudentOrder;
import com.borisov.subsidyApplication.domain.StudentOrderStatus;
import com.borisov.subsidyApplication.exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentOrderDaoImpl implements StudentOrderDao{
    
    //скрипт для вставки данных
    public static final String INSERT_ORDER = "INSERT INTO jc_student_order(\n" +
"	student_order_status, student_order_date, h_sur_name, h_given_name, h_patronymic, h_date_of_birth, h_passport_seria, h_passport_number, h_passport_date, h_passport_office_id, h_post_index, h_street_code, h_building, h_extension, h_apartment, h_university_id, h_student_number, w_sur_name, w_given_name, w_patronymic, w_date_of_birth, w_passport_seria, w_passport_number, w_passport_date, w_passport_office_id, w_post_index, w_street_code, w_building, w_extension, w_apartment, w_university_id, w_student_number, certificate_id, register_office_id, marriage_date)\n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    // TODO refactoring - make one method
    private Connection getConnection() throws SQLException {
        //Подключаемся к базе
        Connection con = DriverManager.getConnection(
                    Config.getProperty(Config.DB_URL),
                    Config.getProperty(Config.DB_LOGIN),
                    Config.getProperty(Config.DB_PASSWORD));
        return con;
    }
    
    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {

        try (Connection con = getConnection();
                    //Создаём запрос     
            PreparedStatement stmt = con.prepareStatement(INSERT_ORDER)) {
            
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(so.getStudentOrderDate()));
            stmt.setString(3, so.getHusband().getSurname());
            stmt.setString(4, so.getHusband().getGivenName());
            stmt.setString(5, so.getHusband().getPatronymic());
            stmt.setDate(6, java.sql.Date.valueOf(so.getHusband().getDateOfBirth()));

            
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return 0L;
    }    
}
