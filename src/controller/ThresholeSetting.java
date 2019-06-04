package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String threshole = (String)request.getParameter("Threshole");
		if(threshole.startsWith("camera1")){
			threshole = threshole.substring(7, threshole.length());
			//此处继续写，将threshole存到数据库和session
			response.getWriter().print(threshole);//后期该为从session返回值
		}else if(threshole.startsWith("camera2")){
			threshole = threshole.substring(7, threshole.length());
			//此处继续写，将threshole存到数据库
			response.getWriter().print(threshole);
		}
		
	}

}
