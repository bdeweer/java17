package certification.chapter15.part8;

import java.sql.*;

public class Test {

    //Two levels of try with resources

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:hsqldb:file:zoo";
        String sql = "SELECT id FROM exhibits WHERE name = ?";
        try(
                Connection conn = DriverManager.getConnection(url); //factory pattern
                PreparedStatement ps = conn.prepareStatement(sql);

        ){
            ps.setString(1, "Balou");

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    System.out.println(id);
                }
            }
        }
    }
}
