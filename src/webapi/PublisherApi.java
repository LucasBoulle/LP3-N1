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

import beans.Publisher;
import model.PublisherDao;

/**
 * Servlet implementation class PublisherApi
 */
@WebServlet("/PublisherApi")
public class PublisherApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublisherApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PublisherDao publisherDao = new PublisherDao();
			Publisher publisher = (Publisher) publisherDao.find(Integer.parseInt(request.getParameter("id")));

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(publisher.toJson());
			out.flush();
		} catch (JSONException | NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().append("Houve um erro, não foi possível buscar a editora!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().append(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Publisher publisher = new Publisher ();
		PublisherDao publisherDao = new PublisherDao();
		try {
			publisher.setFullName(request.getParameter("fullName"));
			publisher.setOwnerName(request.getParameter("ownerName"));
			publisher.setCreatedAt(new java.sql.Date(new Date().getTime()));

			if (request.getParameter("id") == null) {
				publisherDao.insert(publisher);
			} else {
				publisher.setId(Integer.parseInt(request.getParameter("id")));
				publisherDao.update(publisher);
			}

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(publisher.toJson());
			out.flush();
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PublisherDao publisherDao = new PublisherDao();

		try {
			publisherDao.delete(Integer.parseInt(request.getParameter("id")));
			response.getWriter().append("Editora deletada com sucesso!");
		} catch (NumberFormatException | SQLException e) {
			response.getWriter().append("Houve um erro, não foi possível deletar editora!");
			e.printStackTrace();
		}
	}

}
