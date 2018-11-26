package friendPac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;

public class FriendDBAimp implements FriendDBA {
	String url,user, pwd;
	//디비 세팅
	public FriendDBAimp() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		url ="jdbc:oracle:thin:@localhost:1521:xe";
		user = "scott";
		pwd = "TIGER";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	//친구추가
	@Override
	public void friendInsert(Friend f) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into friend values(friend_seq.nextval,?,?,?,?)";
			con = DriverManager.getConnection(url, user, pwd);
			 ps = con.prepareStatement(sql);
			ps.setString(1, f.getName());
			ps.setString(2, f.getPhone());
			ps.setString(3, f.getAddr());
			ps.setString(4, f.getBirth());
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {//클로즈를 해주는 이유는 sql 명령 처리할 때 연결된 서버의  과부하 방지
			if(con != null)con.close();
			if(ps != null)ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//친구 전체보기
	@Override
	public ArrayList<Friend> friendView() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "Select * from Friend";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt(1));
				f.setName(rs.getString("name"));
				f.setAddr(rs.getString("addr"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				arr.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null) rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
	
	
	//친구 검색
	@Override
	public ArrayList<Friend> friendSearch(String str, int idx) {
		String key = "";
		if(idx ==1) {
			key = "name";
		}else if(idx ==2) {
				key = "addr";
		}
		ArrayList<Friend> arr = new ArrayList<>();
		Connection con= null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql= "select * from Friend where "+key+" like '%"+str+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt(1));//= f.setNum(rs.getInt("num")); 첫번째 칼럼을 가져온다는 뜻도 된다.
				f.setName(rs.getString("name"));
				f.setAddr(rs.getString("addr"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				arr.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	//친구 수정
	@Override
	public void friendUpdate(Friend f, int num) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql ="update Friend set name  = ?, addr =? , birth = ? , phone = ? where num="+num;
				ps = con.prepareStatement(sql);
				ps.setString(1, f.getName());
				ps.setString(2, f.getAddr());
				ps.setString(3, f.getBirth());
				ps.setString(4, f.getPhone());
				ps.executeQuery();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	//친구 삭제
	@Override
	public void friendDelete(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con=DriverManager.getConnection(url, user, pwd);
			String sql = "delete From friend where num = "+ num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	// 친구 상세검색
	@Override
	public Friend friendSelect(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Friend f = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend where num = "+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				f = new Friend();
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setAddr(rs.getString("addr"));
				f.setPhone(rs.getString("phone"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	return f;	
	}

}
