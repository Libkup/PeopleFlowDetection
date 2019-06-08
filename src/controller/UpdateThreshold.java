package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Client;

/**
 * Servlet implementation class UpdateThreshold
 */
@WebServlet("/UpdateThreshold")
public class UpdateThreshold extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateThreshold() {
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
		//doGet(request, response);
		updateThreshold(request, response);
	}
	
	
	private void updateThreshold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		String threshold = request.getParameter("Threshold");
		if(threshold.startsWith("camera1")) {
			threshold = threshold.substring(7,threshold.length());
			client.updateThreshold(1, Integer.parseInt(threshold));
		}
		else if(threshold.startsWith("camera2")) {
			threshold = threshold.substring(7,threshold.length());
			client.updateThreshold(2, Integer.parseInt(threshold));
		}
		else if(threshold.startsWith("camera3")) {
			threshold = threshold.substring(7,threshold.length());
			client.updateThreshold(3, Integer.parseInt(threshold));
		}
		else if(threshold.startsWith("camera4")) {
			threshold = threshold.substring(7,threshold.length());
			client.updateThreshold(4, Integer.parseInt(threshold));
		}
		response.getWriter().print(threshold.substring(7,threshold.length()));//后期该为从session返回值		
	}

}
