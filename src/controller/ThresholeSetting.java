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
 * Servlet implementation class ThresholeSetting
 */
@WebServlet("/ThresholeSetting")
public class ThresholeSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThresholeSetting() {
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
//		System.out.println((String)request.getParameter("Threshole"));
		Client client = new Client();
		String threshole = (String)request.getParameter("Threshole");
		HttpSession session = request.getSession();
		if(threshole.startsWith("camera1")){
			threshole = threshole.substring(7, threshole.length());
			client.updateThreshold(1, Integer.parseInt(threshole));
			session.setAttribute("camera1Threshole", threshole);
			//此处继续写，将threshole存到数据库和session
			response.getWriter().print(threshole);//后期该为从session返回值
		}else if(threshole.startsWith("camera2")){
			threshole = threshole.substring(7, threshole.length());
			client.updateThreshold(2, Integer.parseInt(threshole));
			session.setAttribute("camera2Threshole", threshole);
			//此处继续写，将threshole存到数据库
			response.getWriter().print(threshole);
		}
		
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
