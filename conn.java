package bankmanagementsystem;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement", "root", "Madhuri@90");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
