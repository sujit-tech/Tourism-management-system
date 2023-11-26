package tours_travel.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//register the driver
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourismmanagementsystem", "root", "root12");//connecting to SQL
            s = c.createStatement();//calling the queries
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}