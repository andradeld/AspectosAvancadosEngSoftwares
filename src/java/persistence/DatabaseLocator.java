/*
 * Padrão de projeto Singleton.
 * Este padrão garante a existência de apenas uma instância de uma classe, 
 * mantendo um ponto global de acesso ao seu objeto.
 * exemplo: priavate static, public static getInstance
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anderson
 */
public class DatabaseLocator {
    private static DatabaseLocator instance = new DatabaseLocator();
    public static DatabaseLocator getInstance(){
        return instance;
    }
    public Connection getConection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn =
                DriverManager.getConnection("jdbc:mysql://172.18.10.31/201276049", "201276049", "201276049");
        Statement st = conn.createStatement();
        return conn;
    }
    
}
