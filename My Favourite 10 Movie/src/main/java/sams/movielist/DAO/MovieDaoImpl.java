package sams.movielist.DAO;

import sams.movielist.model.JDBCon;
import sams.movielist.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//This DAO class provides CRUDE database operations for the table Movie in the database...
public class MovieDaoImpl implements MovieCRUD {
    private static final String INSERT_MOVIE_SQL ="INSERT INTO list"+"(name,img,type,releaseDate,duration,description) VALUES "+"(?,?,?,?,?,?);";
    private static final String SELECT_MOVIE_BY_NAME="select name,img,type,releaseDate,duration,description from list where name=?";
    private static final String SELECT_MOVIE_BY_ID="select name,img,type,releaseDate,duration,description from list where id=?";
    private static final String SELECT_ALL_MOVIE="select * from list";
    private static final String DELETE_MOVIE_BY_ID = "delete from todos where id = ?;";
    private static final String UPDATE_MOVIE = "update list set name = ?, img= ?, type =?, releaseDate =?, duration = ? description = ? where id = ?;";

    public MovieDaoImpl(){}
    @Override
    public void insertMovie(Movie movie) throws SQLException {
        System.out.println(INSERT_MOVIE_SQL);
        // try-with-resource statement will auto close the connection.
        try(Connection connection = JDBCon.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE_SQL)){
            MovieDao.INSERT(movie, preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            JDBCon.printSQLException(exception);
        }

    }

    @Override
    public Movie selectMovie(long movieId) {
        Movie movie=null;
        try(Connection connection=JDBCon.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(SELECT_MOVIE_BY_ID);) {
            preparedStatement.setLong(1,movieId);
            System.out.println(preparedStatement);
            ResultSet resultSet= preparedStatement.executeQuery();
            //Process the ResultSet object.
            while (resultSet.next()){
                long id=resultSet.getLong("id");
                String name=resultSet.getString("name");
                String img=resultSet.getString("img");
                String type=resultSet.getString("type");
                String releaseDate=resultSet.getString("releaseDate");
                String duration=resultSet.getString("duration");
                String description=resultSet.getString("description");
                movie=new Movie(id,name,releaseDate,type,duration,description,img);
            }
        }catch (SQLException exception) {
            JDBCon.printSQLException(exception);
        }
        return movie;
    }

    @Override
    public List<Movie>selectAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = JDBCon.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIE);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            //Process the ResultSet object.
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name=resultSet.getString("name");
                String img=resultSet.getString("img");
                String type=resultSet.getString("type");
                String releaseDate=resultSet.getString("releaseDate");
                String duration=resultSet.getString("duration");
                String description=resultSet.getString("description");
                movies.add(new Movie(id,name,releaseDate,type,duration,description,img));

            }
        } catch (SQLException exception) {
            JDBCon.printSQLException(exception);
        }
        return movies;
    }

    @Override
    public boolean deleteMovie(int id) throws SQLException {
            boolean rowDeleted;
            try (Connection connection = JDBCon.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_MOVIE_BY_ID);) {
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
            return rowDeleted;
    }

    @Override
    public boolean updateMovie(Movie movie) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = JDBCon.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_MOVIE);) {
            statement.setString(1, movie.getName());
            statement.setString(2, movie.getUrl());
            statement.setString(3, movie.getType());
            statement.setString(4, movie.getDate());
            statement.setString(5, movie.getDuration());
            statement.setString(6, movie.getDescription());
            statement.setLong(7, movie.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
