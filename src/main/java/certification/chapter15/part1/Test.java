package certification.chapter15.part1;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException { //checked SQLException

        String url = "jdbc:hsqldb:file:zoo";
        try(
                Connection conn = DriverManager.getConnection(url); //factory pattern
                PreparedStatement ps = conn.prepareStatement("SELECT name FROM exhibits");
                ResultSet rs = ps.executeQuery()
        ){
            while (rs.next())
                System.out.println(rs.getString(1));
        }
    }
}