package model.dao;

import model.ConfigDataBase;
import java.sql.*;

public class ConnectionSingleton {

    private static Connection connection;

    private ConnectionSingleton() {}

    public static Connection getInstance(ConfigDataBase config) throws SQLException{
        if (connection == null) {
            connection = DriverManager.getConnection(
                config.getURL(),
                config.getUser(),
                config.getPassword()
            );
        }
        return connection;
    }
}
