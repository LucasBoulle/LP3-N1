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
import beans.User;
import model.UserDao;

/**
 * Servlet implementation class UserApi
 */
@WebServlet("/UserApi")
public class UserApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserApi() {
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
			UserDao userDao = new UserDao();
			User user = (User) userDao.find(Integer.parseInt(request.getParameter("id")));

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(user.toJson());
			out.flush();
		} catch (JSONException | NumberFormatException | SQLException e) {
			e.printStackTrace();
			response.getWriter().append("Houve um erro, não foi possível buscar o usuário!");
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		UserDao userDao = new UserDao();
		try {	
		user.setNickname(request.getParameter("nickname"));
		user.setEmail(request.getParameter("email"));
		user.setProfileImageUrl(request.getParameter("profileImageUrl"));
		user.setCreatedAt(new java.sql.Date(new Date().getTime()));
		
		if(request.getParameter("id") == null) {
			userDao.insert(user);
		} else {
			user.setId(Integer.parseInt(request.getParameter("id")));
			userDao.update(user);
		}

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(user.toJson());
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
		UserDao userDao = new UserDao();

		try {
			userDao.delete(Integer.parseInt(request.getParameter("id")));
			response.getWriter().append("Usuário deletado com sucesso!");
		} catch (NumberFormatException | SQLException e) {
			response.getWriter().append("Houve um erro, não foi possível deletar o usuário!");
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPatch(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDao userDao = new UserDao();
		User user = new User();
		try {
			if (request.getParameter("id") != null) {
				user.setId(Integer.parseInt(request.getParameter("id")));
				user.setNickname(request.getParameter("nickname"));
				user.setEmail(request.getParameter("email"));
				user.setProfileImageUrl(request.getParameter("profileImageUrl"));
				user.setCreatedAt(new java.sql.Date(new Date().getTime()));
				userDao.update(user);

				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.print(user.toJson());
				out.flush();

				response.getWriter().append("Usuário Atualizado com sucesso!");
			} else {
				response.getWriter().append("id do usuário é obrigatório");
			}
		} catch (NumberFormatException | SQLException | JSONException e) {
			response.getWriter().append("Houve um erro, não foi possível deletar o usuário!");
			e.printStackTrace();
		}

	}

}
