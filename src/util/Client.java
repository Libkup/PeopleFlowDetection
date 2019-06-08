package util;

import dao.Cameralog;
import dao.User;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class is used to perform database query operations. To get the real-time
 * data of monitors from different locations
 * 
 * @author JG
 */
public class Client {
//	/**
//	 * This function is used to get the target data('account' <= 'value') about the
//	 * Monitor from the database.
//	 * 
//	 * @param value
//	 * @return list<Monitor>
//	 */
//	public java.util.List<Monitor> list(int value) {
//		// create a list to store the information
//		java.util.List<Monitor> lists = new ArrayList<Monitor>();
//		try {
//			Connection conn = DBConn.getINSTANCE().getConnection();
//			String sql = "select * from monitor where account >=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, value);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				Monitor monitor = new Monitor();
//				monitor.setId(rs.getInt("id"));
//				monitor.setLocation(rs.getString("location"));
//				monitor.setAccount(rs.getInt("account"));
//				// System.out.println(monitor.getId());
//				lists.add(monitor);
//			}
//			DBConn.closeConnection(conn, ps, rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return lists;
//	}
//
//	/**
//	 * This function is used to get the whole data about the Monitor from the
//	 * database.
//	 * 
//	 * @param value
//	 * @return list<Monitor>
//	 */
//	public java.util.List<Monitor> listAll() {
//		// create a list to store the information
//		java.util.List<Monitor> lists = new ArrayList<Monitor>();
//		// get the target information use sql
//		String sql = "select * from monitor";
//		try {
//			Connection conn = DBConn.getINSTANCE().getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				Monitor monitor = new Monitor();
//				monitor.setId(rs.getInt("id"));
//				monitor.setLocation(rs.getString("location"));
//				monitor.setAccount(rs.getInt("account"));
//				// System.out.println(monitor.getId());
//				lists.add(monitor);
//			}
//			DBConn.closeConnection(conn, ps, rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return lists;
//	}

//	/**
//	 * This function is used to update the value of warning
//	 * 
//	 * @param value
//	 */
//	public void updateValue(int value) {
//		try {
//			Connection conn = DBConn.getINSTANCE().getConnection();
//
//			String sql = "update global SET value=?" + " where id=1";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, value);
//			ResultSet rs = ps.executeQuery();
//			DBConn.closeConnection(conn, ps, rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * This function is used to get the global value of warning
//	 * 
//	 * @return value
//	 */
//	public int getValue() {
//		int value = 0;
//		try {
//			Connection conn = DBConn.getINSTANCE().getConnection();
//
//			String sql = "select * from global where id=1";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				value = rs.getInt("value");
//			}
//			DBConn.closeConnection(conn, ps, rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return value;
//	}
//
//	/**
//	 * This function is used to update the information of the monitor
//	 * 
//	 * @param monitor
//	 */
//	public void updateMonitor(Monitor monitor) {
//		int id = monitor.getId();
//		int account = monitor.getAccount();
//		try {
//			Connection conn = DBConn.getINSTANCE().getConnection();
//			String sql = "update monitor SET account=?" + " where id=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, account);
//			ps.setInt(2, id);
//			ResultSet rs = ps.executeQuery();
//			DBConn.closeConnection(conn, ps, rs);
//			System.out.println("一次修改。。  " + id + " " + account);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * This function is use to verify if the user exits in the database.
	 * 
	 * @param String name
	 * @return boolean true(user exited, and password correct)/false(user not exited
	 *         or password wrong)
	 */
	public boolean verifyExit(String name) {
		boolean bool = false;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "select * from user where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bool = true;
				break;
			}
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * This function is used to verify the password at the situation of the user
	 * exits.
	 * 
	 * @param user
	 * @return boolean true(password correct)/false( password wrong)
	 */
	public boolean verifyPswd(String name, String pswd) {
		String pswd2 = "";
		boolean bool = false;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "select * from user where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pswd2 = rs.getString("pswd");
			}
			DBConn.closeConnection(conn, ps, rs);
			if (pswd.equals(pswd2)) {
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * This function is used to insert a new user's information.
	 * 
	 * @param user
	 */
	public void register(User user) {
		String name = user.getName();
		String email = user.getEmail();
		String pswd = user.getPswd();
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "insert into user values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pswd);
			ResultSet rs = ps.executeQuery();
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to update the threshold of target camera
	 * 
	 * @param id
	 * @param threshold
	 */
	public void updateThreshold(int id, int threshold) {
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "update camerainfo set threshold=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, threshold);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This function is used to update the threshold of target camera
	 * 
	 * @param id
	 * @param threshold
	 */
	public void updateAccount(int id, int account) {
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "update camerainfo set account=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to get account by id
	 * 
	 * @param id
	 * @return account
	 */
	public int getAccount(int id) {
		int account = 0;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();

			String sql = "select * from camerainfo where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account = rs.getInt("account");
			}
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	/**
	 * This function is used to get highest number of people an hour.
	 * 
	 * @param id
	 * @return highest
	 */
	public int getHighest(int id) {
		int Highest = 0;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();

			String sql = "select * from camerainfo where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Highest = rs.getInt("highest");
			}
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Highest;
	}

	/**
	 * This function is used to get highest number of people an hour.
	 * 
	 * @param id
	 * @return highest_hour
	 */
	public int getHighest_hour(int id) {
		int Highest_hour = 0;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();

			String sql = "select * from camerainfo where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Highest_hour = rs.getInt("highest_hour");
			}
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Highest_hour;
	}

	/**
	 * This function is used to update the log
	 * 
	 * @param cameralog
	 */
	public void updateCameralog(Cameralog cameralog) {
		int id = cameralog.getId();
		int account = cameralog.getAccount();
		java.sql.Timestamp time = cameralog.getTime();
		String no = cameralog.getNo();

		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "insert into cameralog values(?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, no);
			ps.setInt(2, id);
			ps.setInt(3, account);
			ps.setTimestamp(4, time);
			ResultSet rs = ps.executeQuery();
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to predict the number.
	 * 
	 * @param double[] fs
	 * @return predict number
	 */
	public int predict(double[] fs) {

		int size = fs.length;
		int tsize = fs.length - 1;
		double[] arr = fs;
		double[] arr1 = new double[size];
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += arr[i];
			arr1[i] = sum;
		}
		double[] arr2 = new double[tsize];
		for (int i = 0; i < tsize; i++) {
			arr2[i] = (double) (arr1[i] + arr1[i + 1]) / 2;
		}

		double[][] B = new double[tsize][2];
		for (int i = 0; i < tsize; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 1)
					B[i][j] = 1;
				else
					B[i][j] = -arr2[i];
			}

		}

		double[][] YN = new double[tsize][1];
		for (int i = 0; i < tsize; i++) {
			for (int j = 0; j < 1; j++) {
				YN[i][j] = arr[i + 1];
			}
		}

		double[][] BT = new double[2][tsize];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < tsize; j++) {
				BT[i][j] = B[j][i];
			}
		}

		double[][] B2T = new double[2][2];
		for (int i = 0; i < 2; i++) {

			{
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < tsize; k++) {
						B2T[i][j] = B2T[i][j] + BT[i][k] * B[k][j];
					}
				}

			}
		}

		double[][] B_2T = new double[2][2];
		B_2T[0][0] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0])) * B2T[1][1];
		B_2T[0][1] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0])) * (-B2T[0][1]);
		B_2T[1][0] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0])) * (-B2T[1][0]);
		B_2T[1][1] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0])) * B2T[0][0];

		double[][] A = new double[2][tsize];
		for (int i = 0; i < 2; i++) {
			{
				for (int j = 0; j < tsize; j++) {
					for (int k = 0; k < 2; k++) {
						A[i][j] = A[i][j] + B_2T[i][k] * BT[k][j];
					}
				}

			}
		}

		double[][] C = new double[2][1];
		for (int i = 0; i < 2; i++) {

			{
				for (int j = 0; j < 1; j++) {
					for (int k = 0; k < tsize; k++) {
						C[i][j] = C[i][j] + A[i][k] * YN[k][j];
					}
				}

			}
		}

		double a = C[0][0], b = C[1][0];
		int i = 3;
		double Y = (arr[0] - b / a) * Math.exp(-a * (i + 1)) - (arr[0] - b / a) * Math.exp(-a * i);

		return (new Double(Y)).intValue();
	}

	/**
	 * This function is used to update highest of account while loading
	 * 
	 * @param id
	 * @param account
	 */
	public void updateHighest(int id, int account) {
		int highest = 0;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "select * from camerainfo where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				highest = rs.getInt("highest");
			}
			if (account >= highest) {
				sql = "update camerainfo set highest =? where id=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, account);
				ps.setInt(2, id);
				rs = ps.executeQuery();
				DBConn.closeConnection(conn, ps, rs);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to update highest_hour .
	 * 
	 * @param id
	 */
	public void updateHighest_hour(int id) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int account;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "select * from cameralog where id=? and  time between date_add(now(), interval - 1 hour) and now() ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account = rs.getInt("account");
				list.add(account);
			}
			int length = list.size();
			int max = 0;
			for (int i = 0; i < length; i++) {
				if (list.get(i) >= max) {
					max = list.get(i);
				}
			}

			sql = "update camerainfo set highest_hour =? where id =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, max);
			ps.setInt(2, id);
			rs = ps.executeQuery();
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to get the predict number.
	 * 
	 * @param id
	 * @return
	 */
	public int getPredict(int id) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int predict = 0;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "select * from cameralog where id=? and  time between date_add(now(), interval - 10.5 minute) and date_add(now(), interval - 9.5 minute)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		    if(!rs.next()) {
		    	list.add(0);
		    }
			while (rs.next()) {
				list.add(rs.getInt("account"));
				break;
			}

			sql = "select * from cameralog where id=? and  time between date_add(now(), interval - 8.5 minute) and date_add(now(), interval - 7.5 minute)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		    if(!rs.next()) {
		    	list.add(0);
		    }
			while (rs.next()) {
				list.add(rs.getInt("account"));
				break;
			}

			sql = "select * from cameralog where id=? and  time between date_add(now(), interval - 6.5 minute) and date_add(now(), interval - 5.5 minute)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		    if(!rs.next()) {
		    	list.add(0);
		    }
			while (rs.next()) {
				list.add(rs.getInt("account"));
				break;
			}

			sql = "select * from cameralog where id=? and  time between date_add(now(), interval - 4.5 minute) and date_add(now(), interval - 3.5 minute)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		    if(!rs.next()) {
		    	list.add(0);
		    }
			while (rs.next()) {
				list.add(rs.getInt("account"));
				break;
			}

			sql = "select * from cameralog where id=? and  time between date_add(now(), interval - 0.5 minute) and now()";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		    if(!rs.next()) {
		    	list.add(0);
		    }
			while (rs.next()) {
				list.add(rs.getInt("account"));
				break;
			}
			DBConn.closeConnection(conn, ps, rs);
			int length = list.size();
			double[] fs = new double[length];
			for (int i = 0; i < length; i++) {
				fs[i] = list.get(i);
			}
			predict = predict(fs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return predict;
	}
	
	/**
	 * This function is used to get threshold by id
	 * 
	 * @param id
	 * @return threshold
	 */
	public int getthreshold(int id) {
		int threshold = 0;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();

			String sql = "select * from camerainfo where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				threshold = rs.getInt("threshold");
			}
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return threshold;
	}
	
	
	
	/**
	 * This function is used to get email by name
	 * 
	 * @param name
	 * @return email
	 */
	public String getemail(String name) {
		String email="" ;
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();

			String sql = "select * from user where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				email = rs.getString("email");
			}
			DBConn.closeConnection(conn, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}

	/**
	 * This function is used to get the information of internals
	 * 
	 * @return values [two minutes latter],[now][2 minutes ago],[4 minutes ago],[6 minutes ago],[8 minutes ago],[10 minutes ago]
	 */
	public String getValues(int id) {
		String str = "";
		
		try {
			Connection conn = DBConn.getINSTANCE().getConnection();
			String sql = "select * from cameralog where id=? and time between date_add(now(), interval - 10.5 minute) and date_add(now(), interval - 9.5 minute)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(!rs.next()){
				str = str+"0"+",";
			}
			while (rs.next()) {
				str = str + rs.getInt("account") + ",";
				break;
			}

			sql = "select * from cameralog where id=? and time between date_add(now(), interval - 8.5 minute) and date_add(now(), interval - 7.5 minute)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(!rs.next()){
				str = str+"0"+",";
			}
			while (rs.next()) {
				str = str + rs.getInt("account") + ",";
				break;
			}
			
			sql = "select * from cameralog where id=? and time between date_add(now(), interval - 6.5 minute) and date_add(now(), interval - 5.5 minute)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(!rs.next()){
				str = str+"0"+",";
			}
			while (rs.next()) {
				str = str + rs.getInt("account") + ",";
				break;
			}

			sql = "select * from cameralog where id=? and time between date_add(now(), interval - 4.5 minute) and date_add(now(), interval - 3.5 minute)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(!rs.next()){
				str = str+"0"+",";
			}
			while (rs.next()) {
				str = str + rs.getInt("account") + ",";
				break;
			}

			sql = "select * from cameralog where id=? and time between date_add(now(), interval - 2.5 minute) and date_add(now(), interval - 1.5 minute)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(!rs.next()){
				str = str+"0"+",";
			}
			while (rs.next()) {
				str = str + rs.getInt("account") + ",";
				break;
			}

			sql = "select * from cameralog where id=? and time between date_add(now(), interval - 0.1 minute) and now()";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(!rs.next()){
				str = str+"0"+",";
			}
			while (rs.next()) {
				str = str + rs.getInt("account") + ",";
				break;
			}

			
			DBConn.closeConnection(conn, ps, rs);
			str += String.valueOf(getPredict(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
