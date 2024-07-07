package certification.chapter15.part2;

import java.sql.*;

public class Test{

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:hsqldb:file:zoo";
        try(
                Connection conn = DriverManager.getConnection(url); //factory pattern
                PreparedStatement ps = conn.prepareStatement("SELECT name FROM exhibits");
        ){
            boolean isResultSet = ps.execute();
            if(isResultSet){
                try(ResultSet rs = ps.getResultSet()){
                    System.out.println("Ran a query");
                }
            }
            else {
                int result = ps.getUpdateCount();
                System.out.println("Ran an update");
            }
        }
    }
}
