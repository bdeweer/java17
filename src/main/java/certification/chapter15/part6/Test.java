package certification.chapter15.part6;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:hsqldb:file:zoo";
        String sql = "SELECT count(*) FROM exhibits";

        try(
                Connection conn = DriverManager.getConnection(url); //factory pattern
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery() //a ResultSet is required so we use executeQuery

        ){

            if(rs.next()){ //For only one raw, use a if statement instead of a while
                int count = rs.getInt(1);

                //or
                //rs.getInt("count");

                System.out.println(count);

                //trying to read a column that doesn't exist throws a SQLException (column not found : total)
                rs.getInt("total");
            }
        }
    }
}
