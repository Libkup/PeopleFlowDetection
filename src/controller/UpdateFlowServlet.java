package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Client;

/**
 * Servlet implementation class UpdateFlowServlet
 */
@WebServlet("/UpdateFlowServlet")
public class UpdateFlowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlowServlet() {
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
//		
		updateFlow(request, response);
	}
	public void updateFlow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		int highest1 = client.getHighest(1);
		int highest_hour1 = client.getHighest_hour(1);
		int account1 = client.getAccount(1);
		int predict1 = client.getPredict(1);
		
		
		int highest2 = client.getHighest(2);
		int highest_hour2 = client.getHighest_hour(2);
		int account2 = client.getAccount(2);
		int predict2 = client.getPredict(2);
		
		int highest3 = client.getHighest(3);
		int highest_hour3 = client.getHighest_hour(3);
		int account3 = client.getAccount(3);
		int predict3 = client.getPredict(3);
		
		response.getWriter().print(highest1+","+highest_hour1+","+account1+","+predict1+","+
		highest2+","+highest_hour2+","+account2+","+predict2+","+highest3+","+highest_hour3+
		","+account3+","+predict3);
	}
}
