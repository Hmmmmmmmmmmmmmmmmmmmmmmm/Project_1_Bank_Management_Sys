package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionTrial {
    Connection connection;
    Statement statement;

    public ConnectionTrial(){
        try{
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankSystem",
                    "root","WhatisAi?Ai*=Love"
            );
            statement = connection.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
