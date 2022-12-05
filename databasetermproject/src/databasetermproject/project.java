package databasetermproject;

import java.sql.*;
import java.util.*;


public class project {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int number = 0;
		
		System.out.println("\t\t병원 병동 관리 시스템\n");
		
		while(number!=99) {
			System.out.println("===============================================================");
			System.out.println("1. 시스템 연결\n");
			System.out.println("-------------------------의사 정보------------------------------");
			System.out.println("2. 의사 정보 확인\t3. 의사 정보 추가\t4. 의사 정보 삭제\t5.의사 정보 수정\n");
			System.out.println("-------------------------간호사 정보-----------------------------");
			System.out.println("6. 간호사 정보 확인\t7. 간호사 정보 추가\t8. 간호사 정보 삭제\t9.간호사 정보 수정\n");
			System.out.println("-------------------------환자 정보------------------------------");
			System.out.println("10. 환자 정보 확인\t11. 환자 정보 추가\t12. 환자 정보 삭제\t13.환자 정보 수정\n");
			System.out.println("-------------------------병동 정보------------------------------");
			System.out.println("14. 병동 정보 확인\t15. 병동 정보 추가\t16. 병동 정보 삭제\n");
			System.out.println("-------------------------약국 정보------------------------------");
			System.out.println("17. 약국 정보 확인\n");
			System.out.println("-------------------------약 정보--------------------------------");
			System.out.println("18. 약 정보 확인\t19. 약 정보 추가\t20. 약 정보 삭제\n");
			System.out.println("-------------------------약사 정보------------------------------");
			System.out.println("21. 약사 정보 확인\t22. 약사 정보 추가\t23. 약사 정보 삭제\n");
			System.out.println("-------------------------보호자 정보-----------------------------");
			System.out.println("24. 보호자 정보 확인\t25. 보호자 정보 추가\t26. 보호자 정보 삭제\t27. 보호자 정보 수정\n");
			System.out.println("-------------------------병명 정보-------------------------------");
			System.out.println("28. 환자별 병명 조회\t29. 병명 id 조회\n");
			System.out.println("99. 프로그램 종료");
			System.out.println("===============================================================\n");
			System.out.println("번호를 선택하세요.");
			
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
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

// 시스템 연결
public static void connector() {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://192.168.56.101:4567/hospital",
				"hwan-yoo","dbghkswls12");
		Statement stmt = conn.createStatement();
 }catch(Exception e) {System.out.println(e);}
}


// 의사 정보 확인
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

// 의사 정보 추가
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
	System.out.println("의사면허번호를 입력하세요");
	String license = scan.nextLine();
	System.out.println("부서를 입력하세요");
	String department = scan.nextLine();
	System.out.println("이름을 입력하세요");
	String name = scan.nextLine();
	System.out.println("생년월일을 입력하세요");
	String birth = scan.nextLine();
	System.out.println("직책을 입력하세요");
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
			System.out.println("입력 완료");
		else
			System.out.println("입력 실패");
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

// 의사 정보 삭제
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
		
		System.out.println("삭제할 의사 면허번호를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		license = scan.next();
		
		pstmt.setString(1, license);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("삭제 완료");
		else
			System.out.println("삭제 실패");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// 의사 정보 수정
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
		
		System.out.printf("수정할 의사 면허번호 입력 : ");
		String license = scan.next();
		System.out.printf("수정할 의사 직책 입력 : ");
		String position = scan.next();			

		pstmt.setString(1, position);
		pstmt.setString(2, license);
		
		
		int cnt = pstmt.executeUpdate(); 
		System.out.println(cnt + "건이 실행되었습니다.");
	}catch (Exception e) {System.out.println(e.getMessage());}
	finally {
		try {				
			pstmt.close();
			con.close();
		} catch (Exception e) {
		}
 }
}

// 간호사 정보 확인
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

// 간호사 정보 추가
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
	System.out.println("간호사 면허번호를 입력하세요");
	String license = scan.nextLine();
	System.out.println("이름을 입력하세요");
	String name = scan.nextLine();
	System.out.println("생년월일을 입력하세요");
	String birth = scan.nextLine();
	System.out.println("직책을 입력하세요");
	String position = scan.nextLine();
	System.out.println("담당병동 번호를 입력하세요");
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
			System.out.println("입력 완료");
		else
			System.out.println("입력 실패");
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

// 간호사 정보 삭제
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
		
		System.out.println("삭제할 간호사 면허번호를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		license = scan.next();
		
		pstmt.setString(1, license);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("삭제 완료");
		else
			System.out.println("삭제 실패");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// 간호사 정보 수정
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
		
		System.out.printf("수정할 간호사 면허번호 입력 : ");
		String license = scan.next();
		System.out.printf("수정할 간호사 직책 입력 : ");
		String position = scan.next();
		System.out.printf("수정할 간호사 담당병동 번호 입력 : ");
		int wnum = scan.nextInt();

		pstmt.setString(1, position);
		pstmt.setString(2, license);
		pstmt.setInt(3, wnum);
		
		int cnt = pstmt.executeUpdate(); 
		System.out.println(cnt + "건이 실행되었습니다.");
	}catch (Exception e) {System.out.println(e.getMessage());}
	finally {
		try {				
			pstmt.close();
			con.close();
		} catch (Exception e) {
		}
 }
}

// 환자 정보 확인
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

// 환자 정보 추가
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
	System.out.println("환자번호를 입력하세요");
	String pnum = scan.nextLine();
	System.out.println("이름을 입력하세요");
	String name = scan.nextLine();
	System.out.println("생년월일을 입력하세요");
	String birth = scan.nextLine();
	System.out.println("주소를 입력하세요");
	String address = scan.nextLine();
	System.out.println("병동 번호를 입력하세요");
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
			System.out.println("입력 완료");
		else
			System.out.println("입력 실패");
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

// 환자 정보 삭제
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
		
		System.out.println("삭제할 환자번호를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		pnum = scan.next();
		
		pstmt.setString(1, pnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("삭제 완료");
		else
			System.out.println("삭제 실패");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// 환자 정보 수정
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
		
		System.out.printf("수정할 환자 번호 입력 : ");
		int pnum = scan.nextInt();
		System.out.printf("수정할 주소 입력 : ");
		String address = scan.next();
		System.out.printf("수정할 병동 번호 입력 : ");
		int wnum = scan.nextInt();

		pstmt.setString(1, address);
		pstmt.setInt(2, wnum);
		pstmt.setInt(3, pnum);
		
		int cnt = pstmt.executeUpdate(); 
		System.out.println(cnt + "건이 실행되었습니다.");
	}catch (Exception e) {System.out.println(e.getMessage());}
	finally {
		try {				
			pstmt.close();
			con.close();
		} catch (Exception e) {
		}
 }
}

// 병동 정보 확인
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

// 병동 정보 추가
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
	System.out.println("병동 번호를 입력하세요");
	String wnum = scan.nextLine();
	System.out.println("층을 입력하세요");
	String floor = scan.nextLine();
	
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement("INSERT INTO Ward VALUES(?,?)");
		pstmt.setInt(1, Integer.parseInt(wnum));
		pstmt.setInt(2, Integer.parseInt(floor));
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("입력 완료");
		else
			System.out.println("입력 실패");
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

// 병동 정보 삭제
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
		
		System.out.println("삭제할 병동번호를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		wnum = scan.next();
		
		pstmt.setString(1, wnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("삭제 완료");
		else
			System.out.println("삭제 실패");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
	
}

// 약국 정보 확인
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

// 약 정보 확인
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

// 약 정보 추가
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
	System.out.println("약 번호를 입력하세요");
	String mnum = scan.nextLine();
	System.out.println("약 이름을 입력하세요");
	String name = scan.nextLine();
	System.out.println("제조사를 입력하세요");
	String made = scan.nextLine();
	System.out.println("유통기한을 입력하세요");
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
			System.out.println("입력 완료");
		else
			System.out.println("입력 실패");
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

// 약 정보 삭제
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
		
		System.out.println("삭제할 약 번호를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		mnum = scan.next();
		
		pstmt.setString(1, mnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("삭제 완료");
		else
			System.out.println("삭제 실패");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// 약사 정보 확인
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

// 약사 정보 추가
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
	System.out.println("약사 번호를 입력하세요");
	String cnum = scan.nextLine();
	System.out.println("이름을 입력하세요");
	String name = scan.nextLine();
	System.out.println("생년월일 입력하세요");
	String birth = scan.nextLine();
	System.out.println("사업자번호를 입력하세요");
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
			System.out.println("입력 완료");
		else
			System.out.println("입력 실패");
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

// 약사 정보 삭제
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
		
		System.out.println("삭제할 약사 번호를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		cnum = scan.next();
		
		pstmt.setString(1, cnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("삭제 완료");
		else
			System.out.println("삭제 실패");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// 보호자 정보 확인
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


// 보호자 정보 추가
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
	System.out.println("보호자 번호를 입력하세요");
	String gnum = scan.nextLine();
	System.out.println("관계를 입력하세요");
	String relation = scan.nextLine();
	System.out.println("전화번호를 입력하세요");
	String tel = scan.nextLine();
	
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement("INSERT INTO Guardian VALUES(?,?,?)");
		pstmt.setInt(1, Integer.parseInt(gnum));
		pstmt.setString(2, relation);
		pstmt.setString(3, tel);
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("입력 완료");
		else
			System.out.println("입력 실패");
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

// 보호자 정보 삭제
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
		
		System.out.println("삭제할 보호자 번호를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		gnum = scan.next();
		
		pstmt.setString(1, gnum);
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("삭제 완료");
		else
			System.out.println("삭제 실패");
	}catch(Exception e) {System.out.println(e.getMessage());}
	finally {
		try {
			pstmt.close();
			con.close();
		}catch(Exception e) {
	}
}
}

// 보호자 정보 수정
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
		
		System.out.printf("수정할 보호자 번호 입력 : ");
		int gnum = scan.nextInt();
		System.out.printf("수정할 전화번호 입력 : ");
		String tel = scan.next();

		pstmt.setString(1, tel);
		pstmt.setInt(2, gnum);
		
		int cnt = pstmt.executeUpdate(); 
		System.out.println(cnt + "건이 실행되었습니다.");
	}catch (Exception e) {System.out.println(e.getMessage());}
	finally {
		try {				
			pstmt.close();
			con.close();
		} catch (Exception e) {
		}
 }
}

// 환자별 병명 조회
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

// 병명 번호 조회
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