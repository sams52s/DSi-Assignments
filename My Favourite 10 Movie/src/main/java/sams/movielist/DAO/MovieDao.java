package sams.movielist.DAO;

import sams.movielist.model.JDBCon;
import sams.movielist.model.Movie;

import java.sql.*;

public class MovieDao {
    public int addMovie(Movie favourite) {
        String INSERT="INSERT INTO list"+"(name,img,type,releaseDate,duration,description) VALUES "+"(?,?,?,?,?,?);";
        int result=0;
        try(Connection connection= JDBCon.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT)){
            preparedStatement.setString(1,favourite.getName());
            preparedStatement.setString(2,favourite.getUrl());
            preparedStatement.setString(3,favourite.getType());
            preparedStatement.setString(4,favourite.getDate());
            preparedStatement.setString(5,favourite.getDuration());
            preparedStatement.setString(6,favourite.getDescription());
            System.out.println(preparedStatement);
            result=preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            JDBCon.printSQLException(e);
        }
        return result;
    }
}
