package partyMember;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import voter.Voter;

public class partyMemberDAO implements partyMemberService {

	static Connection con = null;
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newVoting", "root", "ITdept~8915");
			System.out.println("Connected");
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
		return con;
	}	
	
	@Override
	public List<partyMember> getAll() {
		List<partyMember> objx = new ArrayList<partyMember>();
		Connection con = partyMemberDAO.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement("select * from partyMembers");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				partyMember p = new partyMember();
				p.setMember_id(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setParty_id(rs.getInt(3));
				p.setParty_name(rs.getString(4));
				objx.add(p);
			}
		}
		catch(Exception e) {
			System.out.println("The exception :"+e);
		}
		return objx;
	}

	@Override
	public int addPartyMember(partyMember pm) {
		Connection con = partyMemberDAO.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement("insert into partyMembers values(?,?,?,?)");
			ps.setInt(1,pm.getMember_id());
			ps.setString(2,pm.getName());
			ps.setInt(3, pm.getParty_id());
			ps.setString(4,pm.getParty_name());
			int k = ps.executeUpdate();
			return k;
		}
		catch(Exception e) {
			System.out.println("Exception :"+e);
		}
		return 0;
	}

}
