package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PeopleCount
 */
@WebServlet("/PeopleCount")
public class PeopleCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String peopleCount = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeopleCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		out.write();
//        out.flush();
//        out.close();
		
//		System.out.println(session.getAttribute("peopleCount"));
        response.getWriter().print(peopleCount);
//        System.out.println(count + "," + a);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		peopleCount = request.getParameter("peopleNum");
	}

}
