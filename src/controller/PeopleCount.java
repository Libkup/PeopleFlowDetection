package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Cameralog;
import util.Client;
import util.MD5Util;

/**
 * Servlet implementation class PeopleCount
 */
@WebServlet("/PeopleCount")
public class PeopleCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String peopleCount = "0";
	private static int highest1;
	private static int highest_hour1;
	private static int account1;
	private static int predict1;
	private static int highest2;
	private static int highest_hour2;
	private static int account2;
	private static int predict2;
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
		Client client = new Client();
		highest1 = client.getHighest(1);
		highest_hour1 = client.getHighest_hour(1);
//		System.out.println(highest_hour1);
		account1 = client.getAccount(1);
		predict1 = client.getPredict(1);
		String th = (String) request.getSession().getAttribute("camera1Threshole");
		highest2 = client.getHighest(2);
		highest_hour2 = client.getHighest_hour(2);
		account2 = client.getAccount(2);
		predict2 = client.getPredict(2);
		
//		int highest3 = client.getHighest(3);
//		int highest_hour3 = client.getHighest_hour(3);
//		int account3 = client.getAccount(3);
//		int predict3 = client.getPredict(3);
		response.getWriter().print(highest1+","+highest_hour1+","+account1+","+predict1+","+th+","+
				highest2+","+highest_hour2+","+account2+","+predict2);
//		response.getWriter().print(highest1+","+highest_hour1+","+account1+","+predict1+","+
//		highest2+","+highest_hour2+","+account2+","+predict2+","+highest3+","+highest_hour3+
//		","+account3+","+predict3);
//        response.getWriter().print(peopleCount);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		peopleCount = request.getParameter("peopleNum");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String id1 = request.getParameter("id1");
		String account1 = request.getParameter("account1");
		Cameralog cameralog1 = new Cameralog(MD5Util.MD5(id1+time, "utf-8"),Integer.parseInt(id1),Integer.parseInt(account1),time);
		
//		String id2 = request.getParameter("id2");
//		String account2 = request.getParameter("account2");
//		Cameralog cameralog2 = new Cameralog(MD5Util.MD5(id2+time, "utf-8"),Integer.parseInt(id2),Integer.parseInt(account2),time);
		
//		String id3 = request.getParameter("id3");
//		String account3 = request.getParameter("account3");
//		Cameralog cameralog3 = new Cameralog(MD5Util.MD5(id3+time, "utf-8"),Integer.parseInt(id3),Integer.parseInt(account3),time);
		
		Client client = new Client();
		client.updateCameralog(cameralog1);
//		client.updateCameralog(cameralog2);
//		client.updateCameralog(cameralog3);
		
		client.updateHighest_hour(Integer.parseInt(id1));
//		client.updateHighest_hour(Integer.parseInt(id2));
//		client.updateHighest_hour(Integer.parseInt(id3));
		
		client.updateHighest(Integer.parseInt(id1),Integer.parseInt(account1));
//		client.updateHighest(Integer.parseInt(id2),Integer.parseInt(account2));
//		client.updateHighest(Integer.parseInt(id3),Integer.parseInt(account3));
		
		client.updateAccount(Integer.parseInt(id1), Integer.parseInt(account1));
//		client.updateAccount(Integer.parseInt(id2), Integer.parseInt(account2));
//		client.updateAccount(Integer.parseInt(id2), Integer.parseInt(account3));
	}

}
