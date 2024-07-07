package certification.chapter15.part5;

import java.sql.*;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:hsqldb:file:zoo";
        String sql = "SELECT id, name FROM exhibits";
        var idToNameMap = new HashMap<Integer, String>();

        try(
                Connection conn = DriverManager.getConnection(url); //factory pattern
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery() //a ResultSet is required so we use executeQuery

        ){
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");

                //it's also possible to get the data with an index (Start by 1 not 0)
                //rs.getInt(1);
                //rs.getString(2);

                idToNameMap.put(id, name);
            }
            System.out.println(idToNameMap);
        }
    }
}
