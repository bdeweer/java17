package certification.chapter15.part9;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException {

        //Call a stored procedure without parameter
        String url = "jdbc:hsqldb:file:zoo";
        String sql = "{call read_e_names()}";
        try (
                Connection conn = DriverManager.getConnection(url); //factory pattern
                CallableStatement cs = conn.prepareCall(sql);
                ResultSet rs = cs.executeQuery();

        ) {
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        }

        //passing an IN parameter
        var sql2 = "{call read_names_by_letter(?)}";
        try (
                Connection conn = DriverManager.getConnection(url); //factory pattern
                CallableStatement cs = conn.prepareCall(sql2)) {

            cs.setString("prefix", "Z");
            //cs.setString(1, "Z");

            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    System.out.println(rs.getString(3));
                }
            }
        }

        //returning an OUT parameter
        var sql3 = "{?= call magic_number(?)}"; //?= is optional
        try (
                Connection conn = DriverManager.getConnection(url); //factory pattern
                CallableStatement cs = conn.prepareCall(sql2)) {
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            System.out.println(cs.getInt("num"));
        }

        //INOUT parameter
        var sql4 = "{call double_number(?)}";
        try (
                Connection conn = DriverManager.getConnection(url); //factory pattern
                CallableStatement cs = conn.prepareCall(sql2)
        )
        {
            cs.setInt(1, 8);
            cs.registerOutParameter(1, Types.INTEGER); //required ??because not ?= in sql??
            cs.execute();
            System.out.println(cs.getInt("num"));

        }
    }
}