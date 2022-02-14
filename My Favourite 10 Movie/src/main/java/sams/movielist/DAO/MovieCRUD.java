package sams.movielist.DAO;

import sams.movielist.model.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieCRUD {
    void insertMovie(Movie movie) throws SQLException;
    Movie selectMovie(long movieId);
    List<Movie> selectAllMovies();
    boolean deleteMovie(int id)throws SQLException;
    boolean updateMovie(Movie movie)throws SQLException;
}
