package databasetermproject;

import java.sql.*;
import java.util.*;


public class project {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int number = 0;
		
		System.out.println("\t\t���� ���� ���� �ý���\n");
		
		while(number!=99) {
			System.out.println("===============================================================");
			System.out.println("1. �ý��� ����\n");
			System.out.println("-------------------------�ǻ� ����------------------------------");
			System.out.println("2. �ǻ� ���� Ȯ��\t3. �ǻ� ���� �߰�\t4. �ǻ� ���� ����\t5.�ǻ� ���� ����\n");
			System.out.println("-------------------------��ȣ�� ����-----------------------------");
			System.out.println("6. ��ȣ�� ���� Ȯ��\t7. ��ȣ�� ���� �߰�\t8. ��ȣ�� ���� ����\t9.��ȣ�� ���� ����\n");
			System.out.println("-------------------------ȯ�� ����------------------------------");
			System.out.println("10. ȯ�� ���� Ȯ��\t11. ȯ�� ���� �߰�\t12. ȯ�� ���� ����\t13.ȯ�� ���� ����\n");
			System.out.println("-------------------------���� ����------------------------------");
			System.out.println("14. ���� ���� Ȯ��\t15. ���� ���� �߰�\t16. ���� ���� ����\n");
			System.out.println("-------------------------�౹ ����------------------------------");
			System.out.println("17. �౹ ���� Ȯ��\n");
			System.out.println("-------------------------�� ����--------------------------------");
			System.out.println("18. �� ���� Ȯ��\t19. �� ���� �߰�\t20. �� ���� ����\n");
			System.out.println("-------------------------��� ����------------------------------");
			System.out.println("21. ��� ���� Ȯ��\t22. ��� ���� �߰�\t23. ��� ���� ����\n");
			System.out.println("-------------------------��ȣ�� ����-----------------------------");
			System.out.println("24. ��ȣ�� ���� Ȯ��\t25. ��ȣ�� ���� �߰�\t26. ��ȣ�� ���� ����\t27. ��ȣ�� ���� ����\n");
			System.out.println("-------------------------���� ����-------------------------------");
			System.out.println("28. ȯ�ں� ���� ��ȸ\t29. ���� id ��ȸ\n");
			System.out.println("99. ���α׷� ����");
			System.out.println("===============================================================\n");
			System.out.println("��ȣ�� �����ϼ���.");
			
			number = scan.nextInt();
			
			if(number == 1) {
				connector();
			}
			else if(number == 2) {
				doctor_info();
			}
			else if(number == 3) {
				doctor_add();
			}
			else if(number == 4) {
				doctor_delete();
			}
			else if(number == 5) {
				doctor_update();
			}
			else if(number == 6) {
				nurse_info();
			}
			else if(number == 7) {
				nurse_add();
			}
			else if(number == 8) {
				nurse_delete();
			}
			else if(number == 9) {
				nurse_update();
			}
			else if(number == 10) {
				patient_info();
			}
			else if(number == 11) {
				patient_add();
			}
			else if(number == 12) {
				patient_delete();
			}
			else if(number == 13) {
				patient_update();
			}
			else if(number == 14) {
				ward_info();
			}
			else if(number == 15) {
				ward_add();
			}
			else if(number == 16) {
				ward_delete();
			}
			else if(number == 17) {
				pharmacy_info();
			}
			else if(number == 18) {
				medicine_info();
			}
			else if(number == 19) {
				medicine_add();
			}
			else if(number == 20) {
				medicine_delete();
			}
			else if(number == 21) {
				chemist_info();
			}
			else if(number == 22) {
				chemist_add();
			}
			else if(number == 23) {
				chemist_delete();
			}
			else if(number == 24) {
				guardian_info();
			}
			else if(number == 25) {
				guardian_add();
			}
			else if(number == 26) {
				guardian_delete();
			}
			else if(number == 27) {
				guardian_update();
			}
			else if(number == 28) {
				patient_disease();
			}
			else if(number == 29) {
				disease_id();
			}
			else if (number == 99) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	}

// �ý��� ����
public static void connector() {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
 }catch(Exception e) {System.out.println(e);}
}


// �ǻ� ���� Ȯ��
public static void doctor_info() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Doctor");
		
		while(rs.next())
			System.out.println(rs.getString(1)+" "+rs.getString(2)+
					" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
}

// �ǻ� ���� �߰�
public static void doctor_add() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
	}catch(ClassNotFoundException e) {
	}catch(SQLException e) {
	}
	Scanner scan = new Scanner(System.in);
	System.out.println("�ǻ�����ȣ�� �Է��ϼ���");
	String license = scan.nextLine();
	System.out.println("�μ��� �Է��ϼ���");
	String department = scan.nextLine();
	System.out.println("�̸��� �Է��ϼ���");
	String name = scan.nextLine();
	System.out.println("��������� �Է��ϼ���");
	String birth = scan.nextLine();
	System.out.println("��å�� �Է��ϼ���");
	String position = scan.nextLine();
	
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement("INSERT INTO Doctor VALUES(?,?,?,?,?)");
		pstmt.setString(1, license);
		pstmt.setString(2, department);
		pstmt.setString(3, name);
		pstmt.setString(4, birth);
		pstmt.setString(5, position);
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("�Է� �Ϸ�");
		else
			System.out.println("�Է� ����");
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null)
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
}

// �ǻ� ���� ����
public static void doctor_delete() {
	Connection con = null;
	
	String sql = "DELETE FROM Doctor WHERE license = ?";
	String license = "";
	
	PreparedStatement pstmt = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		pstmt = con.prepareStatement(sql);
		
		System.out.println("������ �ǻ� �����ȣ�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		license = scan.next();
		
		pstmt.setString(1, license);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("���� �Ϸ�");
		else
			System.out.println("���� ����");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// �ǻ� ���� ����
public static void doctor_update() {
	
	String sql = "UPDATE Doctor SET position = ? WHERE license = ?";
	Connection con = null;
	PreparedStatement pstmt = null;	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		
		pstmt = con.prepareStatement(sql);
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("������ �ǻ� �����ȣ �Է� : ");
		String license = scan.next();
		System.out.printf("������ �ǻ� ��å �Է� : ");
		String position = scan.next();			

		pstmt.setString(1, position);
		pstmt.setString(2, license);
		
		
		int cnt = pstmt.executeUpdate(); 
		System.out.println(cnt + "���� ����Ǿ����ϴ�.");
	}catch (Exception e) {System.out.println(e.getMessage());}
	finally {
		try {				
			pstmt.close();
			con.close();
		} catch (Exception e) {
		}
 }
}

// ��ȣ�� ���� Ȯ��
public static void nurse_info() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Nurse");
		
		while(rs.next())
			System.out.println(rs.getString(1)+" "+rs.getString(2)+
					" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
}

// ��ȣ�� ���� �߰�
public static void nurse_add() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
	}catch(ClassNotFoundException e) {
	}catch(SQLException e) {
	}
	Scanner scan = new Scanner(System.in);
	System.out.println("��ȣ�� �����ȣ�� �Է��ϼ���");
	String license = scan.nextLine();
	System.out.println("�̸��� �Է��ϼ���");
	String name = scan.nextLine();
	System.out.println("��������� �Է��ϼ���");
	String birth = scan.nextLine();
	System.out.println("��å�� �Է��ϼ���");
	String position = scan.nextLine();
	System.out.println("��纴�� ��ȣ�� �Է��ϼ���");
	String wnum = scan.nextLine();
	
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement("INSERT INTO Nurse VALUES(?,?,?,?,?)");
		pstmt.setString(1, license);
		pstmt.setString(2, name);
		pstmt.setString(3, birth);
		pstmt.setString(4, position);
		pstmt.setInt(5, Integer.parseInt(wnum));
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("�Է� �Ϸ�");
		else
			System.out.println("�Է� ����");
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null)
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
}

// ��ȣ�� ���� ����
public static void nurse_delete() {
Connection con = null;
	
	String sql = "DELETE FROM Nurse WHERE license = ?";
	String license = "";
	
	PreparedStatement pstmt = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		pstmt = con.prepareStatement(sql);
		
		System.out.println("������ ��ȣ�� �����ȣ�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		license = scan.next();
		
		pstmt.setString(1, license);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("���� �Ϸ�");
		else
			System.out.println("���� ����");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// ��ȣ�� ���� ����
public static void nurse_update() {
	String sql = "UPDATE Nurse SET position = ?, wnum = ? WHERE license = ?";
	Connection con = null;
	PreparedStatement pstmt = null;	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		
		pstmt = con.prepareStatement(sql);
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("������ ��ȣ�� �����ȣ �Է� : ");
		String license = scan.next();
		System.out.printf("������ ��ȣ�� ��å �Է� : ");
		String position = scan.next();
		System.out.printf("������ ��ȣ�� ��纴�� ��ȣ �Է� : ");
		int wnum = scan.nextInt();

		pstmt.setString(1, position);
		pstmt.setString(2, license);
		pstmt.setInt(3, wnum);
		
		int cnt = pstmt.executeUpdate(); 
		System.out.println(cnt + "���� ����Ǿ����ϴ�.");
	}catch (Exception e) {System.out.println(e.getMessage());}
	finally {
		try {				
			pstmt.close();
			con.close();
		} catch (Exception e) {
		}
 }
}

// ȯ�� ���� Ȯ��
public static void patient_info() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Patient");
		
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+
					" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
}

// ȯ�� ���� �߰�
public static void patient_add() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
	}catch(ClassNotFoundException e) {
	}catch(SQLException e) {
	}
	Scanner scan = new Scanner(System.in);
	System.out.println("ȯ�ڹ�ȣ�� �Է��ϼ���");
	String pnum = scan.nextLine();
	System.out.println("�̸��� �Է��ϼ���");
	String name = scan.nextLine();
	System.out.println("��������� �Է��ϼ���");
	String birth = scan.nextLine();
	System.out.println("�ּҸ� �Է��ϼ���");
	String address = scan.nextLine();
	System.out.println("���� ��ȣ�� �Է��ϼ���");
	String wnum = scan.nextLine();
	
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement("INSERT INTO Patient VALUES(?,?,?,?,?)");
		pstmt.setInt(1, Integer.parseInt(pnum));
		pstmt.setString(2, name);
		pstmt.setString(3, birth);
		pstmt.setString(4, address);
		pstmt.setInt(5, Integer.parseInt(wnum));
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("�Է� �Ϸ�");
		else
			System.out.println("�Է� ����");
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null)
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
}

// ȯ�� ���� ����
public static void patient_delete() {
Connection con = null;
	
	String sql = "DELETE FROM Patient WHERE pnum = ?";
	String pnum = "";
	
	PreparedStatement pstmt = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		pstmt = con.prepareStatement(sql);
		
		System.out.println("������ ȯ�ڹ�ȣ�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		pnum = scan.next();
		
		pstmt.setString(1, pnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("���� �Ϸ�");
		else
			System.out.println("���� ����");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// ȯ�� ���� ����
public static void patient_update() {
	String sql = "UPDATE Patient SET address = ?, wnum = ? WHERE pnum = ?";
	Connection con = null;
	PreparedStatement pstmt = null;	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		
		pstmt = con.prepareStatement(sql);
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("������ ȯ�� ��ȣ �Է� : ");
		int pnum = scan.nextInt();
		System.out.printf("������ �ּ� �Է� : ");
		String address = scan.next();
		System.out.printf("������ ���� ��ȣ �Է� : ");
		int wnum = scan.nextInt();

		pstmt.setString(1, address);
		pstmt.setInt(2, wnum);
		pstmt.setInt(3, pnum);
		
		int cnt = pstmt.executeUpdate(); 
		System.out.println(cnt + "���� ����Ǿ����ϴ�.");
	}catch (Exception e) {System.out.println(e.getMessage());}
	finally {
		try {				
			pstmt.close();
			con.close();
		} catch (Exception e) {
		}
 }
}

// ���� ���� Ȯ��
public static void ward_info() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Ward");
		
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getInt(2));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
}

// ���� ���� �߰�
public static void ward_add() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
	}catch(ClassNotFoundException e) {
	}catch(SQLException e) {
	}
	Scanner scan = new Scanner(System.in);
	System.out.println("���� ��ȣ�� �Է��ϼ���");
	String wnum = scan.nextLine();
	System.out.println("���� �Է��ϼ���");
	String floor = scan.nextLine();
	
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement("INSERT INTO Ward VALUES(?,?)");
		pstmt.setInt(1, Integer.parseInt(wnum));
		pstmt.setInt(2, Integer.parseInt(floor));
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("�Է� �Ϸ�");
		else
			System.out.println("�Է� ����");
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null)
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
}

// ���� ���� ����
public static void ward_delete() {
Connection con = null;
	
	String sql = "DELETE FROM Ward WHERE wnum = ?";
	String wnum = "";
	
	PreparedStatement pstmt = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		pstmt = con.prepareStatement(sql);
		
		System.out.println("������ ������ȣ�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		wnum = scan.next();
		
		pstmt.setString(1, wnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("���� �Ϸ�");
		else
			System.out.println("���� ����");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
	
}

// �౹ ���� Ȯ��
public static void pharmacy_info() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Pharmacy");
		
		while(rs.next())
			System.out.println(rs.getString(1)+" "+rs.getString(2)+
					" "+rs.getString(3));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
	
}

// �� ���� Ȯ��
public static void medicine_info() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Medicine");
		
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+
					" "+rs.getString(3)+" "+rs.getString(4));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
}

// �� ���� �߰�
public static void medicine_add() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
	}catch(ClassNotFoundException e) {
	}catch(SQLException e) {
	}
	Scanner scan = new Scanner(System.in);
	System.out.println("�� ��ȣ�� �Է��ϼ���");
	String mnum = scan.nextLine();
	System.out.println("�� �̸��� �Է��ϼ���");
	String name = scan.nextLine();
	System.out.println("�����縦 �Է��ϼ���");
	String made = scan.nextLine();
	System.out.println("��������� �Է��ϼ���");
	String expiration = scan.nextLine();
	
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement("INSERT INTO Patient VALUES(?,?,?,?)");
		pstmt.setInt(1, Integer.parseInt(mnum));
		pstmt.setString(2, name);
		pstmt.setString(3, made);
		pstmt.setString(4, expiration);
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("�Է� �Ϸ�");
		else
			System.out.println("�Է� ����");
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null)
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
}

// �� ���� ����
public static void medicine_delete() {
Connection con = null;
	
	String sql = "DELETE FROM Medicine WHERE mnum = ?";
	String mnum = "";
	
	PreparedStatement pstmt = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		pstmt = con.prepareStatement(sql);
		
		System.out.println("������ �� ��ȣ�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		mnum = scan.next();
		
		pstmt.setString(1, mnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("���� �Ϸ�");
		else
			System.out.println("���� ����");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// ��� ���� Ȯ��
public static void chemist_info() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Chemist");
		
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+
					" "+rs.getString(3)+" "+rs.getString(4));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
}

// ��� ���� �߰�
public static void chemist_add() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
	}catch(ClassNotFoundException e) {
	}catch(SQLException e) {
	}
	Scanner scan = new Scanner(System.in);
	System.out.println("��� ��ȣ�� �Է��ϼ���");
	String cnum = scan.nextLine();
	System.out.println("�̸��� �Է��ϼ���");
	String name = scan.nextLine();
	System.out.println("������� �Է��ϼ���");
	String birth = scan.nextLine();
	System.out.println("����ڹ�ȣ�� �Է��ϼ���");
	String businessnum = scan.nextLine();
	
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement("INSERT INTO Patient VALUES(?,?,?,?)");
		pstmt.setInt(1, Integer.parseInt(cnum));
		pstmt.setString(2, name);
		pstmt.setString(3, birth);
		pstmt.setString(4, businessnum);
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("�Է� �Ϸ�");
		else
			System.out.println("�Է� ����");
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null)
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
}

// ��� ���� ����
public static void chemist_delete() {
Connection con = null;
	
	String sql = "DELETE FROM Chemist WHERE cnum = ?";
	String cnum = "";
	
	PreparedStatement pstmt = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		pstmt = con.prepareStatement(sql);
		
		System.out.println("������ ��� ��ȣ�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		cnum = scan.next();
		
		pstmt.setString(1, cnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("���� �Ϸ�");
		else
			System.out.println("���� ����");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// ��ȣ�� ���� Ȯ��
public static void guardian_info() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Guardian");
		
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+
					" "+rs.getString(3));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
}


// ��ȣ�� ���� �߰�
public static void guardian_add() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
	}catch(ClassNotFoundException e) {
	}catch(SQLException e) {
	}
	Scanner scan = new Scanner(System.in);
	System.out.println("��ȣ�� ��ȣ�� �Է��ϼ���");
	String gnum = scan.nextLine();
	System.out.println("���踦 �Է��ϼ���");
	String relation = scan.nextLine();
	System.out.println("��ȭ��ȣ�� �Է��ϼ���");
	String tel = scan.nextLine();
	
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement("INSERT INTO Guardian VALUES(?,?,?)");
		pstmt.setInt(1, Integer.parseInt(gnum));
		pstmt.setString(2, relation);
		pstmt.setString(3, tel);
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("�Է� �Ϸ�");
		else
			System.out.println("�Է� ����");
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null)
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
}

// ��ȣ�� ���� ����
public static void guardian_delete() {
Connection con = null;
	
	String sql = "DELETE FROM Guardian WHERE gnum = ?";
	String gnum = "";
	
	PreparedStatement pstmt = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		pstmt = con.prepareStatement(sql);
		
		System.out.println("������ ��ȣ�� ��ȣ�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		gnum = scan.next();
		
		pstmt.setString(1, gnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("���� �Ϸ�");
		else
			System.out.println("���� ����");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// ��ȣ�� ���� ����
public static void guardian_update() {
	String sql = "UPDATE Guardian SET tel = ? WHERE gnum = ?";
	Connection con = null;
	PreparedStatement pstmt = null;	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		
		pstmt = con.prepareStatement(sql);
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("������ ��ȣ�� ��ȣ �Է� : ");
		int gnum = scan.nextInt();
		System.out.printf("������ ��ȭ��ȣ �Է� : ");
		String tel = scan.next();

		pstmt.setString(1, tel);
		pstmt.setInt(2, gnum);
		
		int cnt = pstmt.executeUpdate(); 
		System.out.println(cnt + "���� ����Ǿ����ϴ�.");
	}catch (Exception e) {System.out.println(e.getMessage());}
	finally {
		try {				
			pstmt.close();
			con.close();
		} catch (Exception e) {
		}
 }
}

// ȯ�ں� ���� ��ȸ
public static void patient_disease() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Patient_disease");
		
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
}

// ���� ��ȣ ��ȸ
public static void disease_id() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT *FROM Disease_id");
		
		while(rs.next())
			System.out.println(rs.getString(1)+" "+rs.getString(2));
					conn.close();
	}catch(Exception e) {System.out.println(e);}
}

}