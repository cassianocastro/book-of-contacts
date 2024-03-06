package model.dao;

import model.DBConfig;
import java.sql.*;

/**
 *
 */
public class ConnectionSingleton
{

    static private Connection connection;

    private ConnectionSingleton() {}

    static public Connection getInstance(DBConfig config) throws SQLException
    {
        if ( connection == null )
        {
            connection = DriverManager.getConnection(
                config.getURL(),
                config.getUser(),
                config.getPassword()
            );
        }

        return connection;
    }
}