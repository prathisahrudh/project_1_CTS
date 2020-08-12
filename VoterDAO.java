package voter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VoterDAO implements voterService {

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
	public int addVoter(Voter v) 
	{
		Connection con = VoterDAO.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement("insert into voter(aadhar,phoneNo,address,email,password,name,voteStatus) values(?,?,?,?,?,?,?)");
			ps.setInt(1,v.getAadhar_number());
			ps.setDouble(2, v.getPhone_no());
			ps.setString(3, v.getAddress());
			ps.setString(4,v.getEmail());
			ps.setString(5, v.getPassword());
			ps.setString(6,v.getName());
			ps.setInt(7,v.getVote_status());
			int k = ps.executeUpdate();
			return k;
		}
		catch(Exception e) {
			System.out.println("Exception :"+e);
		}
		return 0;
	}
	
	
	@Override
	public List<Voter> getAll() {
		List<Voter> objx = new ArrayList<Voter>();
		Connection con = VoterDAO.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement("select * from voter");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) 
			{
				Voter v = new Voter();
				int x = 0;
				x = rs.getInt(7);
				v.setAadhar_number(rs.getInt(1));
				v.setPhone_no(rs.getInt(2));
				v.setAddress(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setPassword(rs.getString(5));
				v.setName(rs.getString(6));
				v.setVote_status(x);
				objx.add(v);
			}
		}
		catch(Exception e) {
			System.out.println("The exception is :"+e);
		}
		return objx;
	}

	@Override
	public int UpdateVote(Voter v) {
		Voter obj = new Voter();
		Connection con = VoterDAO.getConnect();
		try {
			String name = v.getName();
			int adhr = v.getAadhar_number();
			PreparedStatement ps=con.prepareStatement("update voter set name=\"name\" where aadhar=\"adhr\" ");
			ResultSet rs=ps.executeQuery();
		}
		catch(Exception e) {
			System.out.println("The Exception is: "+e);
		}
		return 0;
	}

}
