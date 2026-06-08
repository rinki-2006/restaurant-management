import java.sql.*;
public class Database {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "your password";
    public Connection con;
    public Statement stm;
    public Database(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            con = DriverManager.getConnection(url, username, password);
            stm = con.createStatement();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
