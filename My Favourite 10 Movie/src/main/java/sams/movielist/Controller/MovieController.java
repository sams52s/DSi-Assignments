package sams.movielist.Controller;
import sams.movielist.DAO.MovieCRUD;
import sams.movielist.DAO.MovieDao;
import sams.movielist.DAO.MovieDaoImpl;
import sams.movielist.model.Movie;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MovieController extends HttpServlet {
    private static final long serialVersionUID= 1L;
    private MovieDao movieDao;
    private MovieCRUD movieCRUD;
    public void CRUDInit(){
        movieCRUD=new MovieDaoImpl();
    }
    public void init(){
        movieDao=new MovieDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insert(request, response);
                    break;
                case "/delete":
                    deleteMovie(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateMovie(request, response);
                    break;
                case "/list":
                    listMovie(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 /*   private void addFavouriteMovie(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String Url=request.getParameter("Url");
        String type=request.getParameter("type");
        String releaseDate=request.getParameter("releaseDate");
        String duration=request.getParameter("duration");
        String description=request.getParameter("description");
        Movie favourite=new Movie();
        favourite.setName(name);
        favourite.setUrl(Url);
        favourite.setType(type);
        favourite.setDate(releaseDate);
        favourite.setDuration(duration);
        favourite.setDescription(description);
        try {
            int result =movieDao.addMovie(favourite);
            if (result ==1){
                request.setAttribute("NOTIFICATION","Movie added Successfully!");
            }
        }catch (Exception e){
            //Auto generated catch block
            e.printStackTrace();
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher("view/addFavouriteMovie.jsp");
        dispatcher.forward(request,response);
    }*/
    private void listMovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Movie> listMovie = movieCRUD.selectAllMovies();
        request.setAttribute("movie", listMovie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie/addFavouriteMovie.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie/addFavouriteMovie.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie existingTodo = movieCRUD.selectMovie(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie/addFavouriteMovie.jsp");
        request.setAttribute("todo", existingTodo);
        dispatcher.forward(request, response);

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name=request.getParameter("name");
        String img=request.getParameter("img");
        String type=request.getParameter("type");
        String releaseDate=request.getParameter("releaseDate");
        String duration=request.getParameter("duration");
        String description=request.getParameter("description");
        Movie insertMovie= new Movie(name,releaseDate,type,duration,description,img);
        movieCRUD.insertMovie(insertMovie);
        response.sendRedirect("list");
    }

    private void updateMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String img=request.getParameter("img");
        String type=request.getParameter("type");
        String releaseDate=request.getParameter("releaseDate");
        String duration=request.getParameter("duration");
        String description=request.getParameter("description");
        Movie updateMovie =  new Movie(name,releaseDate,type,duration,description,img);
        movieCRUD.updateMovie(updateMovie);
        response.sendRedirect("list");
    }

    private void deleteMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        movieCRUD.deleteMovie(id);
        response.sendRedirect("list");
    }

}
