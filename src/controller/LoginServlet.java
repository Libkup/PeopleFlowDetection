package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Client;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		login(request, response);
	}
	
	/**
	 * This function : 1 (account not exited)  2 (password not correct) 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("loginUsername");
		String pswd = request.getParameter("loginPassword");
		HttpSession session = request.getSession();
		Client client = new Client();
		if(!(client.verifyExit(name))) {
			response.sendRedirect("login.jsp?isMatch=1");
		}
		boolean match = client.verifyPswd(name,pswd);
		if (match) {			
            session.setAttribute("loginUsername",name);
            request.setAttribute("loginUsername",name);
            session.setAttribute("email", client.getemail(name));
            session.setAttribute("camera1Threshole", String.valueOf(client.getthreshold(1)));
            session.setAttribute("camera2Threshole", client.getthreshold(2));
            response.sendRedirect("index.jsp");
//	        request.getRequestDispatcher("index.jsp").forward(request, response);
		} else{
			response.sendRedirect("login.jsp?isMatch=1");
			}
				
		
	}

}
