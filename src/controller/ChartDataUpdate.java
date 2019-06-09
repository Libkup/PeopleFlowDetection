package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Client;

/**
 * Servlet implementation class ChartDataUpdate
 */
@WebServlet("/ChartDataUpdate")
public class ChartDataUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int[] data1 = {100,100,100,100,100,100,100};
    private static int[] data2 = {10,10,10,10,10,10,10}; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartDataUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String whichChart = request.getParameter("which");
		String datas = "";
		Client client = new Client();
		if(whichChart != null && whichChart.equals("1")){
//			for(int i = 0;i < data1.length-1; i++){
//				datas = datas + data1[i] +",";
//			}
//			datas= datas + data1[data1.length-1];
			datas = client.getValues(1);
//			System.out.println(datas);
			response.getWriter().print(datas);
		}else if(whichChart != null && whichChart.equals("2")){
			for(int i = 0;i < data2.length-1; i++){
				datas = datas + data2[i] +",";
			}
			datas= datas + data2[data2.length-1];
			response.getWriter().print(datas);
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
