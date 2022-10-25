import java.sql.*;

public class Test_Insert_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://192.168.56.101:4567/madang",
					"hwan-yoo","dbghkswls12");
			Object rs = con.prepareStatement("INSERT INTO Book(bookid,bookname,"
					+ "publisher,price) VALUES(50,'유환입니다','소프트웨어학과',20000)");
			
			int ret = ((PreparedStatement) rs).executeUpdate();
			System.out.println("Return : " + ret);
			con.close();
		}catch(Exception e) {System.out.println(e);}
	}

}
