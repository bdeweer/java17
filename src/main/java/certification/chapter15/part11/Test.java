package certification.chapter15.part11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Test {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:hsqldb:file:zoo";
        try (
                Connection conn = DriverManager.getConnection(url); //factory pattern

        ) {
            conn.setAutoCommit(false); //You can ony use Savepoint when controlling the transaction.

            Savepoint sp1 = conn.setSavepoint();
            Savepoint sp2 = conn.setSavepoint("second savepoint"); //Optional name

            //database code

            conn.rollback(sp2); //order matters. An Exception will be thrown if the savepoint are inversed.

            //database code
            conn.rollback(sp1);
        }
    }
}
