package webapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import beans.Rating;
import model.RatingDao;
import model.TitleDao;
import model.UserDao;

/**
 * Servlet implementation class RatingApi
 */
@WebServlet("/RatingApi")
public class RatingApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RatingApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RatingDao ratingDao = new RatingDao();
			Rating rating = (Rating) ratingDao.find(Integer.parseInt(request.getParameter("id")));

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(rating.toJson());
			out.flush();
		} catch (JSONException | NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().append("Houve um erro, não foi possível buscar a review!");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Rating rating = new Rating();
		RatingDao ratingDao = new RatingDao();
		UserDao userDao = new UserDao();
		TitleDao titleDao = new TitleDao();

		try {
			rating.setRating(Integer.parseInt(request.getParameter("rating")));
			rating.setComment(request.getParameter("comment"));
			rating.setUser(userDao.find(Integer.parseInt(request.getParameter("userId"))));
			rating.setTitle(titleDao.find(Integer.parseInt(request.getParameter("titleId"))));
			rating.setCreatedAt(new java.sql.Date(new Date().getTime()));
			if (request.getParameter("id") == null) {
				ratingDao.insert(rating);
			} else {
				rating.setId(Integer.parseInt(request.getParameter("id")));
				ratingDao.update(rating);
			}

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(rating.toJson());
			out.flush();
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RatingDao ratingDao = new RatingDao();
		try {
			ratingDao.delete(Integer.parseInt(request.getParameter("id")));
			response.getWriter().append("Review deletada com sucesso!");
		} catch (NumberFormatException | SQLException e) {
			response.getWriter().append("Houve um erro, não foi possível deletar a review!");
			e.printStackTrace();
		}
	}

}
