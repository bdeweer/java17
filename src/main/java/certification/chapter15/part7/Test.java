package certification.chapter15.part7;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:hsqldb:file:zoo";
        String sql = "SELECT id, name FROM exhibits";

        try(
                Connection conn = DriverManager.getConnection(url); //factory pattern
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery() //a ResultSet is required so we use executeQuery

        ){

            while(rs.next()){
                Object idFiled = rs.getObject("id");
                Object nameFiled = rs.getObject("name");

                if(idFiled instanceof Integer id){
                    System.out.println(id);
                }
                if(nameFiled instanceof String name){
                    System.out.println(name);
                }
            }
        }
    }
}
