package com.borisov.subsidyApplication.dao;

import com.borisov.subsidyApplication.config.Config;
import com.borisov.subsidyApplication.domain.Address;
import com.borisov.subsidyApplication.domain.Adult;
import com.borisov.subsidyApplication.domain.Street;
import com.borisov.subsidyApplication.domain.StudentOrder;
import com.borisov.subsidyApplication.domain.StudentOrderStatus;
import com.borisov.subsidyApplication.exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class StudentOrderDaoImpl implements StudentOrderDao{
    
    //скрипт для вставки данных
    public static final String INSERT_ORDER = "INSERT INTO jc_student_order(\n" +
"	student_order_status, student_order_date, h_sur_name, "
                + "h_given_name, h_patronymic, h_date_of_birth, h_passport_seria, "
                + "h_passport_number, h_passport_date, h_passport_office_id, h_post_index, "
                + "h_street_code, h_building, h_extension, h_apartment, w_sur_name, "
                + "w_given_name, w_patronymic, w_date_of_birth, w_passport_seria, "
                + "w_passport_number, w_passport_date, w_passport_office_id, w_post_index, "
                + "w_street_code, w_building, w_extension, w_apartment, certificate_id, "
                + "register_office_id, marriage_date)\n" +
"	VALUES (?, ?, ?, "
                + "?, ?, ?, ?, "
                + "?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, "
                + "?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, "
                + "?, ?);";
    
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

        Long result = -1L;
        
        try (Connection con = getConnection();
                    //Создаём запрос     
            PreparedStatement stmt = con.prepareStatement(INSERT_ORDER, new String[] {"student_order_id"})) {
            //Header
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            //Husband and Wife
            setParamsForAdult(stmt, 3, so.getHusband());
            setParamsForAdult(stmt, 16, so.getWife());
            //Wife
            Adult wife = so.getWife();
            stmt.setString(16, wife.getSurname());
            stmt.setString(17, wife.getGivenName());
            stmt.setString(18, wife.getPatronymic());
            stmt.setDate(19, java.sql.Date.valueOf(wife.getDateOfBirth()));
            stmt.setString(20, wife.getPassportSeria());
            stmt.setString(21, wife.getPassportNumber());
            stmt.setDate(22, java.sql.Date.valueOf(wife.getIssueDate()));
            stmt.setLong(23, wife.getIssueDepartment().getOfficeId());
            Address w_address = wife.getAddress();
            stmt.setString(24, w_address.getPostCode());
            stmt.setLong(25, w_address.getStreet().getStreetCode());
            stmt.setString(26, w_address.getBuilding());
            stmt.setString(27, w_address.getExtension());
            stmt.setString(28, w_address.getApartment());
            //Marrage
            stmt.setString(29, so.getMarriageCertificateId());
            stmt.setLong(30, so.getMarriageOffice().getOfficeId());
            stmt.setDate(31, java.sql.Date.valueOf(so.getMarriageDate()));
            
            stmt.executeUpdate(); //возвращает кол-во измененных записей
            
            ResultSet gkRs = stmt.getGeneratedKeys();
            if (gkRs.next()) {
                result = gkRs.getLong(1);
            }
            gkRs.close();
            
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }    

    private void setParamsForAdult(final PreparedStatement stmt, int start, Adult adult) throws SQLException {
        stmt.setString(start, adult.getSurname());
        stmt.setString(start + 1, adult.getGivenName());
        stmt.setString(start + 2, adult.getPatronymic());
        stmt.setDate(start +3, java.sql.Date.valueOf(adult.getDateOfBirth()));
        stmt.setString(start + 4, adult.getPassportSeria());
        stmt.setString(start + 5, adult.getPassportNumber());
        stmt.setDate(start + 6, java.sql.Date.valueOf(adult.getIssueDate()));
        stmt.setLong(start + 7, adult.getIssueDepartment().getOfficeId());
        Address h_address = adult.getAddress();
        stmt.setString(start + 8, h_address.getPostCode());
        stmt.setLong(start + 9, h_address.getStreet().getStreetCode());
        stmt.setString(start + 10, h_address.getBuilding());
        stmt.setString(start + 11, h_address.getExtension());
        stmt.setString(start + 12, h_address.getApartment());
    }
}
