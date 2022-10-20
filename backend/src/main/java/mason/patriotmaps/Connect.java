package mason.patriotmaps;
import java.sql.*;
import java.util.Properties;
public class Connect {
        private String userName = "postgres", password = "nebvon-kujXun-4kaddi";
        private int portNumber = 5432;
        private String serverName = "pmap.cbo83nt50yog.us-east-1.rds.amazonaws.com";
        private String dbms = "postgres";

        public Connection getConnection() throws SQLException {

            Connection conn = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user", this.userName);
            connectionProps.put("password", this.password);

            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://" +
                            this.serverName +
                            ":" + this.portNumber + "/",
                    connectionProps);

            System.out.println("Connected to database");
            return conn;
        }

        public static void main(String[] args) {
            try {
                new Connect().getConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
}
