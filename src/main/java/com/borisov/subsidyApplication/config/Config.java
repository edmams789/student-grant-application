package com.borisov.subsidyApplication.config;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    private static Properties properties = new Properties(); //частный случай ассоциативного массива

    public synchronized static String getProperty(String name) {
        if (properties.isEmpty()) {
            //мы хотим взять текущий поток байтов, который находится в файле dao.properties       
            try (InputStream is = Config.class.getClassLoader().getResourceAsStream("dao.properties")) {
                
                properties.load(is);
                
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex); //сли файл свойств не загрузился - то запуск приложения 
                //бессмыслен - делаем приложение не работающим
            }
        }
        return properties.getProperty(name);
    }
}
