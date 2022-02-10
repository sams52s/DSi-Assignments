package sams.movielist.model;
import java.sql.*;
import java.time.LocalDate;

public class JDBCon {
    /*
<jdbc-url>jdbc:postgresql://localhost:5432/movie</jdbc-url>
<user-name>postgres</user-name>
*/

    private static final String jdbcUrl ="jdbc:postgresql://localhost:5432/movie";
    private static final String jdbcUserName="postgres";
    private static final String jdbcPassword="121psql52dsi";
    public static Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.postgresql.jdbc.Driver");
            connection=DriverManager.getConnection(jdbcUrl,jdbcUserName,jdbcPassword);
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void printSQLException(SQLException ex){
        for (Throwable e: ex){
            if (e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: "+((SQLException) e).getSQLState());
                System.err.println("Error Code: "+((SQLException) e).getErrorCode());
                System.err.println("Message: "+e.getMessage());
                Throwable throwable= ex.getCause();
                while (throwable!=null){
                    System.out.println("Cause: "+ throwable);
                    throwable=throwable.getCause();
                }
            }
        }
    }
    public static Date getSQLDate(LocalDate date){
        return java.sql.Date.valueOf(date);
    }
    public static LocalDate getUtiDate(Date sqlDate){
        return sqlDate.toLocalDate();
    }

}
