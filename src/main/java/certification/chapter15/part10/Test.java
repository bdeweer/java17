package certification.chapter15.part10;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:hsqldb:file:zoo";
        try (
                Connection conn = DriverManager.getConnection(url); //factory pattern

        ) {
            conn.setAutoCommit(false);

        }
    }
}
