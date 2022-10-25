import java.sql.*;

public class Test_Select_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://192.168.56.101:4567/madang",
					"hwan-yoo","dbghkswls12");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT *FROM Book");
			
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+
						" "+rs.getString(3));
						con.close();
		}catch(Exception e) {System.out.println(e);}
	}

}
