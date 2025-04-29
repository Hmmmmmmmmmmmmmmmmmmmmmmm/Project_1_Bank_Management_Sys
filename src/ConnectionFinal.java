import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class ConnectionFinal {
        Connection connection;
        Statement statement;

        public ConnectionFinal(){
            try{
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/BankSystemMain",
                        "root","WhatisAi?Ai*=Love"
                );
                statement = connection.createStatement();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
}
