package certification.chapter15.part4;

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

            ps.executeUpdate();

            ps.setInt(1, 16);
            ps.setString(3, "Tigrou");

            //ps.setNull(2, Types.VARCHAR);

            ps.executeUpdate(); //PreparedStatement remember previous parameters

        }
    }
}
