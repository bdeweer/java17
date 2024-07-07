package certification.chapter15.part3;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:hsqldb:file:zoo";
        String sql = "INSERT INTO names VALUES(?, ?, ?)";
        try(
                Connection conn = DriverManager.getConnection(url); //factory pattern
                PreparedStatement ps = conn.prepareStatement(sql);

        ){
            ps.setInt(1, 15);
            ps.setString(3, "Balou");
            ps.setInt(2, 54);

            //is the same than :
            //ps.setObject(1, 15);
            //ps.setObject(2, 15);
            //ps.setObject(3, "Balou");

            ps.executeUpdate();
        }
    }
}