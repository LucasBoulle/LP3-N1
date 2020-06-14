package webapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import beans.Title;
import model.DemographicDao;
import model.PublisherDao;
import model.TitleDao;

/**
 * Servlet implementation class TitleApi
 */
@WebServlet("/TitleApi")
public class TitleApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TitleApi() {
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
			TitleDao titleDao = new TitleDao();
			Title title = (Title) titleDao.find(Integer.parseInt(request.getParameter("id")));

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(title.toJson());
			out.flush();
		} catch (JSONException | NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().append("Houve um erro, não foi possível buscar o título!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().append(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Title title = new Title();
		TitleDao titleDao = new TitleDao();
		DemographicDao demographicDao = new DemographicDao();
		PublisherDao publisherDao = new PublisherDao();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			title.setTitle(request.getParameter("title"));
			title.setGenre(request.getParameter("genre"));
			title.setDemographic(demographicDao.find(Integer.parseInt(request.getParameter("demographicId"))));
			title.setPublisher(publisherDao.find(Integer.parseInt(request.getParameter("publisherId"))));
			title.setPublishedAt(new java.sql.Date(format.parse(request.getParameter("publishedAt")).getTime()));
			title.setBannerImageUrl(request.getParameter("bannerImageUrl"));
			if (request.getParameter("id") == null) {
				titleDao.insert(title);
			} else {
				title.setId(Integer.parseInt(request.getParameter("id")));
				titleDao.update(title);
			}

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(title.toJson());
			out.flush();
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
			response.getWriter().append("Formato de data inválida");
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TitleDao titleDao = new TitleDao();

		try {
			titleDao.delete(Integer.parseInt(request.getParameter("id")));
			response.getWriter().append("Título deletado com sucesso!");
		} catch (NumberFormatException | SQLException e) {
			response.getWriter().append("Houve um erro, não foi possível deletar o título!");
			e.printStackTrace();
		}
	}

}
