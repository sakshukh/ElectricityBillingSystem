package electricity.billing.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    Connection connection;
    Statement statement;

    Database () {
        try {
//            System.out.println("dbname" + System.getenv("db_username"));
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system", "root", "root@123");
            statement = connection.createStatement();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}