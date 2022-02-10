package sams.movielist.Controller;
import sams.movielist.DAO.MovieDao;
import sams.movielist.model.Movie;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addFavouriteMovie")
public class MovieController extends HttpServlet {
    private static final long serialVersionUID= 1L;
    private MovieDao movieDao;
    public void init(){
        movieDao=new MovieDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addFavouriteMovie(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("addFavouriteMovie/addFavouriteMovie.jsp");
    }
    private void addFavouriteMovie(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
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
    }

}
